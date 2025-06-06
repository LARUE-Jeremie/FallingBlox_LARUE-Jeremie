package fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3a.poo.projet.blox.exception.BloxException;
import fr.eseo.e3a.poo.projet.blox.modele.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TetrominoTest {

    @Test
    public void testGetNbRequiredElements() {
        Tetromino tetromino = new TetrominoI(new Coordonnees(0, 0), Couleur.ROUGE);
        assertEquals(4, tetromino.getNbRequiredElements());
    }

    @Test
    public void testGetElements() {
        Tetromino tetromino = new TetrominoO(new Coordonnees(1, 1), Couleur.BLEU);
        List<Element> elements = tetromino.getElements();
        assertEquals(4, elements.size());

        for (Element element : elements) {
            assertEquals(Couleur.BLEU, element.getCouleur());
        }
    }

    @Test
    public void testSetPosition() {
        Tetromino tetromino = new TetrominoI(new Coordonnees(0, 0), Couleur.JAUNE);
        tetromino.setPosition(3, 2);
        assertEquals(3, tetromino.coordonnees.getAbscisse());
        assertEquals(2, tetromino.coordonnees.getOrdonnee());
    }

    @Test
    public void testSetAndGetPuits() {
        Tetromino tetromino = new TetrominoO(new Coordonnees(0, 0), Couleur.VERT);
        Puits puits = new Puits();
        tetromino.setPuits(puits);
        assertEquals(puits, tetromino.getPuits());
    }

    @Test
    public void testToStringNotEmpty() {
        Tetromino tetromino = new TetrominoI(new Coordonnees(0, 0), Couleur.VIOLET);
        String str = tetromino.toString();
        assertNotNull(str);
        assertTrue(str.contains("("));
        assertTrue(str.contains(") - "));
    }

    @Test
    public void testDeplacementValideDroite() throws BloxException {
        Tetromino tetromino = new TetrominoO(new Coordonnees(2, 2), Couleur.BLEU);
        tetromino.deplacerDe(1, 0);
        for (Element e : tetromino.getElements()) {
            assertTrue(e.getCoordonnees().getAbscisse() >= 2, "Déplacement vers la droite incorrect");
        }
    }

    @Test
    public void testDeplacementValideGauche() throws BloxException {
        Tetromino tetromino = new TetrominoO(new Coordonnees(2, 2), Couleur.BLEU);
        tetromino.deplacerDe(-1, 0);
        for (Element e : tetromino.getElements()) {
            assertTrue(e.getCoordonnees().getAbscisse() <= 2, "Déplacement vers la gauche incorrect");
        }
    }

    @Test
    public void testDeplacementValideBas() throws BloxException {
        Tetromino tetromino = new TetrominoO(new Coordonnees(2, 2), Couleur.BLEU);
        tetromino.deplacerDe(0, 1);
        for (Element e : tetromino.getElements()) {
            assertTrue(e.getCoordonnees().getOrdonnee() >= 2, "Déplacement vers le bas incorrect");
        }
    }

    @Test
    public void testDeplacementInvalideHaut() {
        Tetromino tetromino = new TetrominoO(new Coordonnees(2, 2), Couleur.BLEU);
        assertThrows(IllegalArgumentException.class, () -> tetromino.deplacerDe(0, -1),
                "Déplacement vers le haut devrait lancer une exception");
    }

    @Test
    public void testDeplacementInvalideDiagonaleHautGauche() {
        Tetromino tetromino = new TetrominoO(new Coordonnees(2, 2), Couleur.BLEU);
        assertThrows(IllegalArgumentException.class, () -> tetromino.deplacerDe(-1, -1),
                "Déplacement diagonal devrait lancer une exception");
    }

}
