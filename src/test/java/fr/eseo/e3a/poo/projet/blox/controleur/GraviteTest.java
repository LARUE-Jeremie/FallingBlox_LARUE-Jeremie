package fr.eseo.e3a.poo.projet.blox.controleur;

import fr.eseo.e3a.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3a.poo.projet.blox.modele.Couleur;
import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos.TetrominoI;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos.TetrominoO;
import fr.eseo.e3a.poo.projet.blox.vue.VuePuits;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class GraviteTest {
    @Test
    public void testGraviteAutomatique() throws InterruptedException {
        JFrame frame = new JFrame("Test Gravite");
        Puits puits = new Puits(10, 20);
        VuePuits vuePuits = new VuePuits(puits, 30);
        puits.setPieceSuivante(new TetrominoO(new Coordonnees(4, 0), Couleur.ROUGE));
        puits.setPieceSuivante(new TetrominoI(new Coordonnees(0, 0), Couleur.ORANGE));

        frame.setContentPane(vuePuits);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setVisible(true);

        new Gravite(vuePuits, 500);
        Thread.sleep(3000);
        frame.dispose();
    }
}
