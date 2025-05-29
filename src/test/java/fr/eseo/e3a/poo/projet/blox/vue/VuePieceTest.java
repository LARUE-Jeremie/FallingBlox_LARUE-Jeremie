package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class VuePieceTest {

    @Test
    public void testTeinte() {
        Color couleurOriginale = new Color(100, 150, 200);
        Color couleurTeintee = VuePiece.teinte(couleurOriginale);

        assertTrue(couleurTeintee.getRed() > couleurOriginale.getRed());
        assertTrue(couleurTeintee.getGreen() > couleurOriginale.getGreen());
        assertTrue(couleurTeintee.getBlue() > couleurOriginale.getBlue());

        assertTrue(couleurTeintee.getRed() <= 255);
        assertTrue(couleurTeintee.getGreen() <= 255);
        assertTrue(couleurTeintee.getBlue() <= 255);
    }

    @Test
    public void testAfficherPiece() {
        Puits puits = new Puits(10, 20);
        IPiece piece = UsineDePiece.genererTetromino();
        piece.setPuits(puits);
        puits.setPieceSuivante(piece);

        VuePiece vuePiece = new VuePiece(piece, 30);

        javax.swing.JFrame fenetre = new javax.swing.JFrame("Test VuePiece");
        javax.swing.JPanel panneau = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                vuePiece.afficherPiece((Graphics2D) g);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 600);
            }
        };

        fenetre.setContentPane(panneau);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);

        try {
            Thread.sleep(3000); // 3 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fenetre.dispose();
    }
}
