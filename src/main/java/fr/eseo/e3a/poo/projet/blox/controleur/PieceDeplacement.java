package fr.eseo.e3a.poo.projet.blox.controleur;

import fr.eseo.e3a.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

public class PieceDeplacement extends MouseAdapter implements MouseMotionListener {

    private VuePuits vuePuits;
    private Integer derniereColonne = null;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Puits puits = vuePuits.getPuits();
        if (puits == null) return;
        IPiece piece = puits.getPieceActuelle();
        if (piece == null) return;
        int tailleCase = vuePuits.getTaille();
        int colonneCurseur = e.getX() / tailleCase;
        int posPieceX = piece.getReferentElement().getCoordonnees().getAbscisse();
        int deplacementX = colonneCurseur - posPieceX;
        if (deplacementX != 0) {
            try {
                piece.deplacerDe(deplacementX, 0);
                vuePuits.repaint();
            } catch (IllegalArgumentException ex) {
                // ignore exception
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    public void setVuePuits(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() > 0) {
            IPiece piece = vuePuits.getPuits().getPieceActuelle();
            if (piece != null) {
                try {
                    piece.deplacerDe(0, 1);
                    vuePuits.repaint();
                } catch (IllegalArgumentException ex) {
                    // ignore exception
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        derniereColonne = null;
    }

}
