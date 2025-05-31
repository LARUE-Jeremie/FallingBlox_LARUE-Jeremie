package fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3a.poo.projet.blox.exception.BloxException;
import fr.eseo.e3a.poo.projet.blox.modele.*;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
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

    @Test
    void testDeplacementValide() throws BloxException {
        TetrominoI tetromino = new TetrominoI(new Coordonnees(3, 3), Couleur.VERT);
        tetromino.deplacerDe(0, 1);
        assertEquals(new Coordonnees(3, 4), tetromino.getReferentElement().getCoordonnees());
    }

    @Test
    void testDeplacementInvalide() {
        TetrominoI tetromino = new TetrominoI(new Coordonnees(3, 3), Couleur.VERT);
        assertThrows(IllegalArgumentException.class, () -> tetromino.deplacerDe(-1, -1));
        assertThrows(IllegalArgumentException.class, () -> tetromino.deplacerDe(0, -1));
    }

    @Test
    public void testRotationHoraire() throws BloxException {
        TetrominoI tetromino = new TetrominoI(new Coordonnees(5, 5), Couleur.ORANGE);
        List<Element> elementsAvant = tetromino.getElements().stream()
                .map(e -> new Element(e.getCoordonnees().getAbscisse(), e.getCoordonnees().getOrdonnee(), e.getCouleur()))
                .collect(Collectors.toList());
        tetromino.tourner(true);
        List<Element> elementsApres = tetromino.getElements();
        assertEquals(elementsAvant.get(1).getCoordonnees(), tetromino.getReferentElement().getCoordonnees());
        boolean auMoinsUnDifferent = false;
        for (int i = 0; i < elementsAvant.size(); i++) {
            if (!elementsAvant.get(i).getCoordonnees().equals(elementsApres.get(i).getCoordonnees())) {
                auMoinsUnDifferent = true;
                break;
            }
        }
        assertTrue(auMoinsUnDifferent, "Au moins un élément doit avoir changé de position après rotation horaire.");
    }

    @Test
    public void testRotationAntiHoraire() throws BloxException {
        TetrominoI tetromino = new TetrominoI(new Coordonnees(5, 5), Couleur.ORANGE);
        List<Element> elementsAvant = tetromino.getElements().stream()
                .map(e -> new Element(e.getCoordonnees().getAbscisse(), e.getCoordonnees().getOrdonnee(), e.getCouleur()))
                .collect(Collectors.toList());
        tetromino.tourner(false);
        List<Element> elementsApres = tetromino.getElements();
        assertEquals(elementsAvant.get(1).getCoordonnees(), tetromino.getReferentElement().getCoordonnees());
        boolean auMoinsUnDifferent = false;
        for (int i = 0; i < elementsAvant.size(); i++) {
            if (!elementsAvant.get(i).getCoordonnees().equals(elementsApres.get(i).getCoordonnees())) {
                auMoinsUnDifferent = true;
                break;
            }
        }
        assertTrue(auMoinsUnDifferent, "Au moins un élément doit avoir changé de position après rotation antihoraire.");
    }

    @Test
    public void testRotationNeModifiePasLeReferent() throws BloxException {
        TetrominoI tetromino = new TetrominoI(new Coordonnees(5, 5), Couleur.ORANGE);
        Coordonnees coordReferentAvant = tetromino.getReferentElement().getCoordonnees();
        tetromino.tourner(true);
        assertEquals(coordReferentAvant, tetromino.getReferentElement().getCoordonnees());
        tetromino.tourner(false);
        assertEquals(coordReferentAvant, tetromino.getReferentElement().getCoordonnees());
    }

    @Test
    public void testDeplacementInvalideDiagonale() {
        IPiece piece = new TetrominoO(new Coordonnees(2, 2), Couleur.BLEU);
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(1, 1));
    }

    @Test
    public void testDeplacementSortiePuits() throws BloxException {
        Puits puits = new Puits(5, 10);
        IPiece piece = new TetrominoO(new Coordonnees(3, 5), Couleur.BLEU);
        puits.setPieceSuivante(piece);
        puits.setPieceSuivante(new TetrominoO(new Coordonnees(0, 0), Couleur.ROUGE));
        assertThrows(BloxException.class, () -> piece.deplacerDe(1, 0));
    }

    @Test
    public void testDeplacementCollisionTas() throws BloxException {
        Puits puits = new Puits(5, 10);
        IPiece piece = new TetrominoI(new Coordonnees(2, 2), Couleur.BLEU);
        puits.setPieceSuivante(piece);
        puits.setPieceSuivante(piece);
        puits.getTas().getElements().add(new Element(new Coordonnees(2, 3), Couleur.JAUNE));
        assertThrows(BloxException.class, () -> piece.deplacerDe(0, 1));
    }
}
