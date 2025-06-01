package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.modele.Element;
import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.Tas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

public class VueTas {
    public static final double MULTIPLIER_NUANCE = 0.3;

    private final VuePuits vuePuits;
    private final int taille;

    public VueTas(VuePuits vuePuits, int taille) {
        this.vuePuits = vuePuits;
        this.taille = taille;
    }

    public static Color nuance(Color couleur) {
        int r = (int) (couleur.getRed() * (1 - MULTIPLIER_NUANCE));
        int g = (int) (couleur.getGreen() * (1 - MULTIPLIER_NUANCE));
        int b = (int) (couleur.getBlue() * (1 - MULTIPLIER_NUANCE));
        return new Color(r, g, b);
    }

    public void afficher(Graphics2D g2D) {
        Puits puits = vuePuits.getPuits();
        Tas tas = puits.getTas();
        List<Element> elements = tas.getElements();
        int largeur = puits.getLargeur();

        for (Element element : elements) {
            if (element != null) {
                int x = element.getCoordonnees().getAbscisse() * taille;
                int y = element.getCoordonnees().getOrdonnee() * taille;
                g2D.setColor(nuance(element.getCouleur().getCouleurPourAffichage()));
                g2D.fill3DRect(x, y, taille, taille, true);
            }
        }
    }

    public VuePuits getVuePuits() {
        return vuePuits;
    }

    public int getTaille() {
        return taille;
    }
}
