package fr.eseo.e3a.poo.projet.blox.controleur;

import fr.eseo.e3a.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3a.poo.projet.blox.modele.Couleur;
import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos.TetrominoI;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3a.poo.projet.blox.vue.VuePiece;
import fr.eseo.e3a.poo.projet.blox.vue.VuePuits;
import javax.swing.*;

public class PieceDeplacementRotationTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Puits puits = new Puits(10, 20);
            IPiece piece = new TetrominoI(new Coordonnees(2, 3), Couleur.ORANGE);
            puits.setPieceSuivante(piece);
            puits.setPieceSuivante(piece);

            VuePuits vuePuits = new VuePuits(puits, 30);
            vuePuits.setVuePiece(new VuePiece(puits.getPieceActuelle(), vuePuits.getTaille()));

            PieceRotation rotation = new PieceRotation(vuePuits);
            vuePuits.addMouseListener(rotation);

            JFrame fenetre = new JFrame("Test Rotation Souris");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.add(vuePuits);
            fenetre.pack();
            fenetre.setLocationRelativeTo(null);
            fenetre.setVisible(true);
        });
    }
}
