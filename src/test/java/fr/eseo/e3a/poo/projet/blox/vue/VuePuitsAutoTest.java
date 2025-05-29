package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class VuePuitsAutoTest {

    @Test
    public void testVuePuitsAvecPieceRenduAutomatique() {
        final int largeur = 10;
        final int hauteur = 20;
        final int taille = 20;

        Puits puits = new Puits(largeur, hauteur);
        IPiece piece = UsineDePiece.genererTetromino();
        piece.setPuits(puits);
        puits.setPieceSuivante(piece);

        VuePuits vuePuits = new VuePuits(puits, taille);
        VuePiece vuePiece = new VuePiece(piece, taille);
        vuePuits.setVuePiece(vuePiece);

        BufferedImage image = new BufferedImage(
                largeur * taille, hauteur * taille, BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g2d = image.createGraphics();
        vuePuits.paintComponent(g2d);
        g2d.dispose();

        boolean pixelNonBlanc = false;
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if ((image.getRGB(x, y) & 0xFFFFFF) != 0xFFFFFF) {
                    pixelNonBlanc = true;
                    break;
                }
            }
            if (pixelNonBlanc) break;
        }

        assertTrue(pixelNonBlanc, "L'image doit contenir au moins un pixel coloré (non blanc)");
    }
}
