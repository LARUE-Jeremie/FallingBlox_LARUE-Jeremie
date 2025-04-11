package fr.eseo.e3a.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordonneesTest {

    @Test
    void testToString() {
        Coordonnees coordonnees;

        coordonnees = new Coordonnees(-10, -10);
        assertEquals("(-10, -10)", coordonnees.toString());

        coordonnees = new Coordonnees(-1, -10);
        assertEquals("(-1, -10)", coordonnees.toString());

        coordonnees = new Coordonnees(0, -1);
        assertEquals("(0, -1)", coordonnees.toString());

        coordonnees = new Coordonnees(0, 0);
        assertEquals("(0, 0)", coordonnees.toString());

        coordonnees = new Coordonnees(1, 0);
        assertEquals("(1, 0)", coordonnees.toString());

        coordonnees = new Coordonnees(10, 1);
        assertEquals("(10, 1)", coordonnees.toString());

        coordonnees = new Coordonnees(10, 10);
        assertEquals("(10, 10)", coordonnees.toString());
    }

    @Test
    void testEquals() {
        Coordonnees coordonnees1;
        Coordonnees coordonnees2;

        coordonnees1 = new Coordonnees(-10, -10);
        coordonnees2 = new Coordonnees(-10, -10);
        assertEquals(coordonnees1, coordonnees2);

        coordonnees1 = new Coordonnees(-1, -10);
        coordonnees2 = new Coordonnees(-1, -10);
        assertEquals(coordonnees1, coordonnees2);

        coordonnees1 = new Coordonnees(0, -1);
        coordonnees2 = new Coordonnees(0, -1);
        assertEquals(coordonnees1, coordonnees2);

        coordonnees1 = new Coordonnees(0, 0);
        coordonnees2 = new Coordonnees(0, 0);
        assertEquals(coordonnees1, coordonnees2);

        coordonnees1 = new Coordonnees(1, 0);
        coordonnees2 = new Coordonnees(1, 0);
        assertEquals(coordonnees1, coordonnees2);

        coordonnees1 = new Coordonnees(10, 1);
        coordonnees2 = new Coordonnees(10, 1);
        assertEquals(coordonnees1, coordonnees2);

        coordonnees1 = new Coordonnees(10, 10);
        coordonnees2 = new Coordonnees(10, 10);
        assertEquals(coordonnees1, coordonnees2);
    }

    @Test
    void testHashCode() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        int hashCode = coordonnees.hashCode();
        assertEquals(System.identityHashCode(coordonnees), hashCode);
    }
}