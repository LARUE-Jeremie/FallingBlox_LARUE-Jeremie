package fr.eseo.e3a.poo.projet.blox.controleur;

import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3a.poo.projet.blox.vue.VuePuits;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Manages blox's rotations
 */
public class PieceRotation extends MouseAdapter {
    private final VuePuits vuePuits;

    /**
     * PieceRotation's Constructor
     * @param vuePuits
     */
    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }

    /**
     * Manages the mouse's click
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        IPiece piece = vuePuits.getPuits().getPieceActuelle();
        if (piece == null) return;

        try {
            if (SwingUtilities.isLeftMouseButton(e)) {
                piece.tourner(false); // anti-horaire
            } else if (SwingUtilities.isRightMouseButton(e)) {
                piece.tourner(true);  // horaire
            }
            vuePuits.repaint();
        } catch (IllegalArgumentException ex) {
            // ignore exception
        }
    }
}
