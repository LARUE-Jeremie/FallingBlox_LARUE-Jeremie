package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.modele.Element;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import java.util.List;

import java.awt.*;

public class VuePiece {
    public static final double MULTIPLIER_TEINTE = 0.7;
    private final IPiece piece;
    private final int taille;

    /**
     * VuePiece's Constructor
     * @param piece the blox
     * @param taille size
     */
    public VuePiece(IPiece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    /**
     * Changes the color of a blox
     * @param couleur color
     * @return the new Color
     */
    public static Color teinte(Color couleur) {
        int r = couleur.getRed();
        int g = couleur.getGreen();
        int b = couleur.getBlue();

        r += (int)((255 - r) * MULTIPLIER_TEINTE);
        g += (int)((255 - g) * MULTIPLIER_TEINTE);
        b += (int)((255 - b) * MULTIPLIER_TEINTE);

        return new Color(r, g, b);
    }

    /**
     * Show the blox
     * @param g2D instance of Graphics2D
     */
    public void afficherPiece(Graphics2D g2D) {
        if (piece == null) return;
        List<Element> elements = piece.getElements();
        for (int i = 0; i < elements.size(); i++) {
            Element e = elements.get(i);
            int x = e.getCoordonnees().getAbscisse() * taille;
            int y = e.getCoordonnees().getOrdonnee() * taille;

            Color couleur = e.getCouleur().getCouleurPourAffichage();
            g2D.setColor(e == piece.getReferentElement() ? teinte(couleur) : couleur);
            g2D.fill3DRect(x, y, taille, taille, true);
        }
    }
}
