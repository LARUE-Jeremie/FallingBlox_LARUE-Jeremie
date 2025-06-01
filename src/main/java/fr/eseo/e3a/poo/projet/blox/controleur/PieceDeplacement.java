package fr.eseo.e3a.poo.projet.blox.controleur;

import fr.eseo.e3a.poo.projet.blox.exception.BloxException;
import fr.eseo.e3a.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

/**
 * Manages blox's movements
 */
public class PieceDeplacement extends MouseAdapter implements MouseMotionListener {

    private VuePuits vuePuits;
    private Integer derniereColonne = null;

    /**
     * PieceDeplacement's Constructor
     * @param vuePuits
     */
    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }

    /**
     * Manages the mouse's movement, follow the cursor
     * @param e the event to be processed
     */
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
            } catch (BloxException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    public void setVuePuits(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }

    /**
     * Manages the wheel's movement
     * @param e the event to be processed
     */
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
                } catch (BloxException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        derniereColonne = null;
    }

}
