package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;

public class VuePuits extends JPanel {

    private Puits puits;
    private int taille;
    public static final int TAILLE_PAR_DEFAUT = 10;

    /**
     * VuePuits' Constructor
     * @param puits the well
     */
    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    /**
     * VuePuits' Constructor
     * @param puits the well
     * @param taille size of an element in the well
     */
    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(
            taille * puits.getLargeur(),
            taille * puits.getProfondeur()
        ));
    }

    public Puits getPuits() {
        return puits;
    }

    public int getTaille() {
        return taille;
    }

    /**
     * Set up the view of the well
     * @param puits the well
     */
    public void setPuits(Puits puits) {
        this.puits = puits;
        this.setPreferredSize(new Dimension(
            taille * puits.getLargeur(),
            taille * puits.getProfondeur()
        ));
        revalidate();
        repaint();
    }

    /**
     * Set up the size of an element in the well
     * @param taille the size of an element
     */
    public void setTaille(int taille) {
        this.taille = taille;
        this.setPreferredSize(new Dimension(
            taille * puits.getLargeur(),
            taille * puits.getProfondeur()
        ));
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /* appel vers super pour remplir le fond du JPanel */

        /*Le paramètre g est copié en utilisant la méthode create()
         * puis converti en instance de Graphics2D grâce à
         * un transtypage (cast) explicite.
         */
        Graphics2D g2D = (Graphics2D) g.create();

        // Couleur de fond : blanc (au cas où)
        setBackground(Color.WHITE);
        /* Nous utiliserons l'instance de Graphics2D */
        g2D.setColor(Color.LIGHT_GRAY);

        int largeur = puits.getLargeur();
        int profondeur = puits.getProfondeur();

        for (int x = 0; x <= largeur; x++) {
            g2D.drawLine(x * taille, 0, x * taille, profondeur * taille);
        }

        for (int y = 0; y <= profondeur; y++) {
            g2D.drawLine(0, y * taille, largeur * taille, y * taille);
        }

        /* Puis nous libérons la mémoire */
        g2D.dispose();
    }
}
