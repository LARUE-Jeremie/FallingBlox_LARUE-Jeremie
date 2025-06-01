package fr.eseo.e3a.poo.projet.blox;

import fr.eseo.e3a.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3a.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3a.poo.projet.blox.exception.BloxException;
import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3a.poo.projet.blox.vue.VuePiece;
import fr.eseo.e3a.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3a.poo.projet.blox.modele.UsineDePiece;
import javax.swing.*;
import java.awt.*;

public class FallingBloxVersion1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Création du puits
            Puits puits;
            if (args.length == 2) {
                int nbElements = Integer.parseInt(args[0]);
                int nbLignes = Integer.parseInt(args[1]);
                puits = new Puits(10, 20, nbElements, nbLignes);
            } else if (args.length == 1) {
                int nbElements = Integer.parseInt(args[0]);
                puits = new Puits(10, 20, nbElements, 1);
            } else {
                puits = new Puits(10, 20);
            }

            // 2. Initialisation des pièces
            puits.setPieceSuivante(UsineDePiece.genererTetromino());
            puits.setPieceSuivante(UsineDePiece.genererTetromino());

            // 3. Création de la vue
            int taille = 30;
            VuePuits vuePuits = new VuePuits(puits, taille);
            vuePuits.setVuePiece(new VuePiece(puits.getPieceActuelle(), taille));
            PanneauInformation panneauInfo = new PanneauInformation(puits);

            // 4. Contrôleurs souris
            vuePuits.addMouseMotionListener(new PieceDeplacement(vuePuits));
            vuePuits.addMouseWheelListener(new PieceDeplacement(vuePuits));
            vuePuits.addMouseListener(new PieceRotation(vuePuits));

            // 5. Création de la fenêtre
            JFrame fenetre = new JFrame("Falling Blox");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setLayout(new BorderLayout());
            fenetre.add(vuePuits, BorderLayout.CENTER);
            fenetre.add(panneauInfo, BorderLayout.EAST);
            fenetre.pack();
            fenetre.setLocationRelativeTo(null);
            fenetre.setVisible(true);
            fenetre.setResizable(false); // Pour l'instant, on suit la consigne de non redimensionnable

            // 6. Gravité automatique avec Timer
            Timer timer = new Timer(500, e -> {
                try {
                    puits.gravite();
                } catch (BloxException ex) {
                    System.err.println("Erreur de gravité : " + ex.getMessage());
                }
            });
            timer.start();
        });
    }
}
