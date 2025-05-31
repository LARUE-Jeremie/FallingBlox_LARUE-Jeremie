package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuits extends JPanel implements PropertyChangeListener {

    private Puits puits;
    private int taille;
    public static final int TAILLE_PAR_DEFAUT = 10;
    private VuePiece vuePiece;
    private PieceDeplacement pieceDeplacement;

    /**
     * VuePuits' Constructor
     * @param puits the well
     */
    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
        this.setBackground(Color.WHITE);
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
        this.pieceDeplacement = new PieceDeplacement(this);
        this.addMouseMotionListener(pieceDeplacement);
        this.addMouseListener(pieceDeplacement);
        this.addMouseWheelListener(pieceDeplacement);
        puits.addPropertyChangeListener(evt -> {
            if (Puits.MODIFICATION_PIECE_ACTUELLE.equals(evt.getPropertyName())) {
                IPiece nouvellePiece = (IPiece) evt.getNewValue();
                if (nouvellePiece != null) {
                    this.vuePiece = new VuePiece(nouvellePiece, this.taille);
                } else {
                    this.vuePiece = null;
                }
                repaint();
            }
        });
    }

    public Puits getPuits() {
        return puits;
    }

    public int getTaille() {
        return taille;
    }

    public VuePiece getVuePiece() {
        return this.vuePiece;
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
        if (pieceDeplacement != null) {
            pieceDeplacement.setVuePuits(this);
        }
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

    public void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
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

        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D);
        }

        /* Puis nous libérons la mémoire */
        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Puits.MODIFICATION_PIECE_ACTUELLE.equals(evt.getPropertyName())) {
            IPiece nouvellePiece = (IPiece) evt.getNewValue();
            if (nouvellePiece != null) {
                setVuePiece(new VuePiece(nouvellePiece, taille));
            } else {
                vuePiece = null;
                repaint();
            }
        }
    }
}
