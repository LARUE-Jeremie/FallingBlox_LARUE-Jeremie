package fr.eseo.e3a.poo.projet.blox.controleur;

import fr.eseo.e3a.poo.projet.blox.exception.BloxException;
import fr.eseo.e3a.poo.projet.blox.vue.VuePuits;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Manages the gravity
 * the falling part of the game
 */
public class Gravite implements ActionListener {
    private static final int PERIODICITE_PAR_DEFAUT = 1000;

    private final VuePuits vuePuits;
    private final Timer timer;
    private int periodicite;

    /**
     * Gravite's Constructor
     * @param vuePuits well's view
     */
    public Gravite(VuePuits vuePuits) {
        this(vuePuits, PERIODICITE_PAR_DEFAUT);
    }

    /**
     * Gravite's Constructor
     * @param vuePuits well's view
     * @param periodicite time between each call of gravity
     */
    public Gravite(VuePuits vuePuits, int periodicite) {
        this.vuePuits = vuePuits;
        this.periodicite = periodicite;
        this.timer = new Timer(periodicite, this);
        this.timer.start();
    }

    public int getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
        this.timer.setDelay(periodicite);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            vuePuits.getPuits().gravite();
        } catch (BloxException e) {
            throw new RuntimeException(e);
        }
        vuePuits.repaint();
    }
}
