package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos.TetrominoI;

import javax.swing.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits() {
        JFrame fenetre = new JFrame("Test : Puits");
        Puits puits = new Puits(10, 20);

        IPiece piece = UsineDePiece.genererTetromino();
        piece.setPuits(puits);
        puits.setPieceSuivante(piece);

        VuePuits vuePuits = new VuePuits(puits);
        VuePiece vuePiece = new VuePiece(puits.getPieceActuelle(), vuePuits.getTaille());
        vuePuits.setVuePiece(vuePiece);

        fenetre.setContentPane(vuePuits);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    private void testConstructeurPuitsTaille() {
        JFrame fenetre = new JFrame("Test : Puits et Taille");
        Puits puits = new Puits(10, 20);

        var piece = UsineDePiece.genererTetromino();
        piece.setPuits(puits);
        puits.setPieceSuivante(piece);

        int taille = 30;
        VuePuits vuePuits = new VuePuits(puits, taille);
        VuePiece vuePiece = new VuePiece(puits.getPieceActuelle(), taille);
        vuePuits.setVuePiece(vuePiece);

        fenetre.setContentPane(vuePuits);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VuePuitsAffichageTest());
    }
}