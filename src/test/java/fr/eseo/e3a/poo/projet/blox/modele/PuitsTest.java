package fr.eseo.e3a.poo.projet.blox.modele;

import fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos.TetrominoI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuitsTest {

    @Test
    public void testConstructeurParDefaut() {
        Puits puits = new Puits();
        assertEquals(10, puits.getLargeur());
        assertEquals(10, puits.getProfondeur());
    }

    @Test
    public void testConstructeurAvecParametresValides() {
        Puits puits = new Puits(7, 12);
        assertEquals(7, puits.getLargeur());
        assertEquals(12, puits.getProfondeur());
    }

    @Test
    public void testSetPieceSuivante() {
        Puits puits = new Puits();
        TetrominoI piece1 = new TetrominoI(new Coordonnees(0, 0), Couleur.ROUGE);
        TetrominoI piece2 = new TetrominoI(new Coordonnees(0, 0), Couleur.BLEU);

        puits.setPieceSuivante(piece1);
        assertNull(puits.getPieceActuelle());
        assertEquals(piece1, puits.getPieceSuivante());

        puits.setPieceSuivante(piece2);
        assertEquals(piece1, puits.getPieceActuelle());
        assertEquals(piece2, puits.getPieceSuivante());
    }

    @Test
    public void testSetLargeurInvalide() {
        Puits puits = new Puits();
        assertThrows(IllegalArgumentException.class, () -> puits.setLargeur(3));
    }

    @Test
    public void testSetProfondeurInvalide() {
        Puits puits = new Puits();
        assertThrows(IllegalArgumentException.class, () -> puits.setProfondeur(20)); // max = 15
    }

    @Test
    public void testToStringSansPieces() {
        Puits puits = new Puits();
        String attendu = "Puits : Dimension 10 x 10\n" +
                "Piece Actuelle : <aucune>\n" +
                "Piece Actuelle : <aucune>\n";
        assertEquals(attendu, puits.toString());
    }
}
