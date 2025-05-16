package fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3a.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3a.poo.projet.blox.modele.Couleur;
import fr.eseo.e3a.poo.projet.blox.modele.Element;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TetrominoITest {

    @Test
    public void testConstructeurEtGetElements() {
        TetrominoI tetromino = new TetrominoI(new Coordonnees(6, 5), Couleur.CYAN);
        List<Element> elements = tetromino.getElements();

        assertEquals(4, elements.size());
        assertTrue(elements.stream().anyMatch(e -> e.getCoordonnees().getAbscisse() == 6 && e.getCoordonnees().getOrdonnee() == 6));
        assertTrue(elements.stream().anyMatch(e -> e.getCoordonnees().getAbscisse() == 6 && e.getCoordonnees().getOrdonnee() == 5));
        assertTrue(elements.stream().anyMatch(e -> e.getCoordonnees().getAbscisse() == 6 && e.getCoordonnees().getOrdonnee() == 4));
        assertTrue(elements.stream().anyMatch(e -> e.getCoordonnees().getAbscisse() == 6 && e.getCoordonnees().getOrdonnee() == 3));
    }

    @Test
    public void testCouleurElements() {
        TetrominoI tetromino = new TetrominoI(new Coordonnees(0, 0), Couleur.ROUGE);
        for (Element e : tetromino.getElements()) {
            assertEquals(Couleur.ROUGE, e.getCouleur());
        }
    }

    @Test
    public void testToString() {
        TetrominoI tetromino = new TetrominoI(new Coordonnees(6, 5), Couleur.CYAN);
        String result = tetromino.toString();

        assertTrue(result.contains("TetrominoI :"));
        assertTrue(result.contains("    (6, 6) - CYAN"));
        assertTrue(result.contains("    (6, 5) - CYAN"));
        assertTrue(result.contains("    (6, 4) - CYAN"));
        assertTrue(result.contains("    (6, 3) - CYAN"));
    }
}
