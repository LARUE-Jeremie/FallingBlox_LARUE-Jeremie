package fr.eseo.e3a.poo.projet.blox.vue;

import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VuePuitsTest {

    private Puits puits;
    private Puits autrePuits;

    @BeforeEach
    public void setUp() {
        puits = new Puits(10, 20);
        autrePuits = new Puits(5, 15);
    }

    @Test
    public void testConstructeurAvecUnPuits() {
        VuePuits vuePuits = new VuePuits(puits);
        assertEquals(puits, vuePuits.getPuits(), "Le puits doit être celui passé au constructeur");
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuits.getTaille(), "La taille par défaut doit être utilisée");
    }

    @Test
    public void testConstructeurAvecPuitsEtTaille() {
        int taille = 25;
        VuePuits vuePuits = new VuePuits(puits, taille);
        assertEquals(puits, vuePuits.getPuits(), "Le puits doit être celui passé au constructeur");
        assertEquals(taille, vuePuits.getTaille(), "La taille doit être celle passée au constructeur");
    }

    @Test
    public void testSetPuits() {
        VuePuits vuePuits = new VuePuits(puits);
        vuePuits.setPuits(autrePuits);
        assertEquals(autrePuits, vuePuits.getPuits(), "Le puits doit être mis à jour");
    }

    @Test
    public void testSetTaille() {
        VuePuits vuePuits = new VuePuits(puits);
        vuePuits.setTaille(30);
        assertEquals(30, vuePuits.getTaille(), "La taille doit être mise à jour");
    }
}
