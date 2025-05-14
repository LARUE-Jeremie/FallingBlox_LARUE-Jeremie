package fr.eseo.e3a.poo.projet.blox.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoordonneesTest {

    private Coordonnees coordonnees1;
    private Coordonnees coordonnees2;
    private Coordonnees coordonnees3;

    @BeforeEach
    void setUp() {
        coordonnees1 = new Coordonnees(10, 20);
        coordonnees2 = new Coordonnees(10, 20);
        coordonnees3 = new Coordonnees(30, 40);
    }

    @Test
    void testConstructor() {
        assertEquals(10, coordonnees1.getAbscisse());
        assertEquals(20, coordonnees1.getOrdonnee());
    }

    @Test
    void testGetters() {
        assertEquals(10, coordonnees1.getAbscisse());
        assertEquals(20, coordonnees1.getOrdonnee());
    }

    @Test
    void testSetters() {
        coordonnees1.setAbscisse(15);
        coordonnees1.setOrdonnee(25);

        assertEquals(15, coordonnees1.getAbscisse());
        assertEquals(25, coordonnees1.getOrdonnee());
    }

    @Test
    void testToString() {
        assertEquals("(10, 20)", coordonnees1.toString());
    }

    @Test
    void testEquals() {
        assertEquals(coordonnees1, coordonnees2);
        assertNotEquals(coordonnees1, coordonnees3);
        assertNotEquals(null, coordonnees1);
    }

    @Test
    void testHashCode() {
        assertEquals(coordonnees1.hashCode(), coordonnees2.hashCode());
        assertNotEquals(coordonnees1.hashCode(), coordonnees3.hashCode());
    }
}
