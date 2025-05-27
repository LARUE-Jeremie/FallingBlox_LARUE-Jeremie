package fr.eseo.e3a.poo.projet.blox.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    private Coordonnees coord1;
    private Coordonnees coord2;
    private Couleur couleur1;
    private Couleur couleur2;
    private Element element1;
    private Element element2;
    private Element element3;
    private Element element4;

    @BeforeEach
    void setUp() {
        coord1 = new Coordonnees(5, 10);
        coord2 = new Coordonnees(5, 10);

        couleur1 = Couleur.ROUGE;
        couleur2 = Couleur.BLEU;

        element1 = new Element(coord1, couleur1);
        element2 = new Element(coord1, couleur1);
        element3 = new Element(coord2, couleur2);
        element4 = new Element(5, 10, couleur1);
    }

    @Test
    void testConstructorWithCoordonnees() {
        assertEquals(coord1, element1.getCoordonnees());
        assertEquals(couleur1, element1.getCouleur());
    }

    @Test
    void testConstructorWithAbscisseOrdonnee() {
        assertEquals(coord1, element4.getCoordonnees());
        assertEquals(couleur1, element4.getCouleur());
    }

    @Test
    void testSettersAndGetters() {
        Coordonnees newCoord = new Coordonnees(10, 20);
        element1.setCoordonnees(newCoord);
        assertEquals(newCoord, element1.getCoordonnees());

        Couleur newColor = Couleur.VERT;
        element1.setCouleur(newColor);
        assertEquals(newColor, element1.getCouleur());
    }

    @Test
    void testToString() {
        assertEquals("(5, 10) - ROUGE", element1.toString());
    }

    @Test
    void testEquals() {
        assertEquals(element1, element2);
        assertNotEquals(element1, element3);
        assertNotEquals(element1, null);
        assertNotEquals(element1, "String");
    }

    @Test
    void testHashCode() {
        assertEquals(element1.hashCode(), element2.hashCode());
        assertNotEquals(element1.hashCode(), element3.hashCode());
    }
}
