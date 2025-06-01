package fr.eseo.e3a.poo.projet.blox.modele;

import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos.TetrominoI;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class TasTest {

    @Test
    public void testConstructeurVide() {
        Puits puits = new Puits();
        Tas tas = new Tas(puits);
        assertTrue(tas.getElements().isEmpty());
        assertEquals(puits, tas.getPuits());
    }

    @Test
    public void testConstructeurAvecElementsEtLignes() {
        Puits puits = new Puits(5, 10);
        Tas tas = new Tas(puits, 10, 3);
        List<Element> elements = tas.getElements();
        assertEquals(10, elements.size());
    }

    @Test
    public void testConstructeurCompletAvecRandom() {
        Puits puits = new Puits(6, 15);
        Random rand = new Random(42);
        Tas tas = new Tas(puits, 12, 4, rand);
        assertEquals(12, tas.getElements().size());
    }

    @Test
    public void testConstructeurAvecCalculNbLignes() {
        Puits puits = new Puits(5, 10);
        Tas tas = new Tas(puits, 12);
        assertEquals(12, tas.getElements().size());
    }

    @Test
    public void testExceptionSiTropDElements() {
        Puits puits = new Puits(3, 2);
        assertThrows(IllegalArgumentException.class, () -> {
            new Tas(puits, 10, 1);
        });
    }

    @Test
    public void testAjouterElements() {
        Puits puits = new Puits();
        Tas tas = puits.getTas();
        assertEquals(0, tas.getElements().size());
        IPiece piece = new TetrominoI(new Coordonnees(0, 0), Couleur.ROUGE);
        tas.ajouterElements(piece);
        assertEquals(piece.getNbRequiredElements(), tas.getElements().size());
    }
}
