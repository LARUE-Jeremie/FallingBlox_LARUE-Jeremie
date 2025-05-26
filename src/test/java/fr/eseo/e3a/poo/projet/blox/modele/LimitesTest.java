package fr.eseo.e3a.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LimitesTest {

    @Test
    public void testConstructeurEtAccesseurs() {
        Limites limites = new Limites(1, 5, 10);

        assertEquals(1, limites.getMinimum(), "Minimum incorrect");
        assertEquals(5, limites.getDefault(), "Valeur par défaut incorrecte");
        assertEquals(10, limites.getMaximum(), "Maximum incorrect");
    }

    @Test
    public void testLimitesNegatives() {
        Limites limites = new Limites(-10, -5, 0);

        assertEquals(-10, limites.getMinimum());
        assertEquals(-5, limites.getDefault());
        assertEquals(0, limites.getMaximum());
    }

    @Test
    public void testLimitesEgales() {
        Limites limites = new Limites(3, 3, 3);

        assertEquals(3, limites.getMinimum());
        assertEquals(3, limites.getDefault());
        assertEquals(3, limites.getMaximum());
    }
}
