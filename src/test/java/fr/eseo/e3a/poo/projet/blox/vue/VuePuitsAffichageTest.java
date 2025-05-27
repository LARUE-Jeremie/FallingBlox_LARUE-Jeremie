package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.modele.Puits;

import javax.swing.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits() {
        JFrame fenetre = new JFrame("Test : Puits");
        Puits puits = new Puits(10, 20);
        VuePuits vuePuits = new VuePuits(puits);
        fenetre.setContentPane(vuePuits);
        fenetre.pack(); // prend en compte la taille de préférence
        fenetre.setLocationRelativeTo(null); // centre la fenêtre
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    private void testConstructeurPuitsTaille() {
        JFrame fenetre = new JFrame("Test : Puits et Taille");
        Puits puits = new Puits(10, 20);
        VuePuits vuePuits = new VuePuits(puits, 30); // Exemple de taille
        fenetre.setContentPane(vuePuits);
        fenetre.pack(); // prend en compte la taille de préférence
        fenetre.setLocationRelativeTo(null); // centre la fenêtre
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VuePuitsAffichageTest());
    }
}