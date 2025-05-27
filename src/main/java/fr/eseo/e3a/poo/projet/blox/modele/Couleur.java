package fr.eseo.e3a.poo.projet.blox.modele;

import java.awt.*;

/**
 * Enum : Colors enabled
 */
public enum Couleur {
    ROUGE(Color.RED),
    ORANGE(Color.ORANGE),
    BLEU(Color.BLUE),
    VERT(Color.GREEN),
    JAUNE(Color.YELLOW),
    CYAN(Color.CYAN),
    VIOLET(Color.MAGENTA);

    private Color couleurPourAffichage;

    /**
     * Color's Constructor
     * @param couleurPourAffichage color to show (java.awt)
     */
    Couleur(Color couleurPourAffichage) {
        this.couleurPourAffichage = couleurPourAffichage;
    }

    public Color getCouleurPourAffichage() {
        return couleurPourAffichage;
    }
}
