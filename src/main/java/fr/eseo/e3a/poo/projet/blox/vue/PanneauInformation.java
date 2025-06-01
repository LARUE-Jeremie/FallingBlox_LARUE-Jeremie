package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {

    private VuePiece vuePiece;

    public PanneauInformation(Puits puits) {
        puits.addPropertyChangeListener(this);
        this.setPreferredSize(new Dimension(70, 70));
        this.setBackground(Color.WHITE);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Puits.MODIFICATION_PIECE_SUIVANTE.equals(evt.getPropertyName())) {
            IPiece nouvellePiece = (IPiece) evt.getNewValue();
            this.vuePiece = new VuePiece(nouvellePiece, 10);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vuePiece != null) {
            Graphics2D g2D = (Graphics2D) g.create();
            vuePiece.afficherPiece(g2D);
            g2D.dispose();
        }
    }
}
