package fr.eseo.e3a.poo.projet.blox.modele;

import fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsineDePieceTest {

    @BeforeEach
    public void resetMode() {
        // Always reset mode before each test
        UsineDePiece.setMode(ModesDeGeneration.ALEATOIRE_PIECE.getId());
    }

    @Test
    public void testGenererTetrominoAleatoirePiece() {
        UsineDePiece.setMode(ModesDeGeneration.ALEATOIRE_PIECE.getId());
        Tetromino tetromino = UsineDePiece.genererTetromino();

        assertNotNull(tetromino, "Le tetromino généré ne doit pas être null");
        assertEquals(2, tetromino.getReferentElement().getCoordonnees().getAbscisse());
        assertEquals(3, tetromino.getReferentElement().getCoordonnees().getOrdonnee());
        assertEquals(tetromino.getDefaultColor(), tetromino.getReferentElement().getCouleur(), "La couleur doit être la couleur par défaut");
    }

    @Test
    public void testGenererTetrominoAleatoireComplet() {
        UsineDePiece.setMode(ModesDeGeneration.ALEATOIRE_COMPLET.getId());
        Tetromino tetromino = UsineDePiece.genererTetromino();

        assertNotNull(tetromino, "Le tetromino généré ne doit pas être null");
        assertEquals(2, tetromino.getReferentElement().getCoordonnees().getAbscisse());
        assertEquals(3, tetromino.getReferentElement().getCoordonnees().getOrdonnee());
        assertNotNull(tetromino.getReferentElement().getCouleur(), "La couleur ne doit pas être null");
    }

    @Test
    public void testGenererTetrominoCyclic() {
        UsineDePiece.setMode(ModesDeGeneration.CYCLIC.getId());
        Tetromino t1 = UsineDePiece.genererTetromino();
        Tetromino t2 = UsineDePiece.genererTetromino();

        assertNotNull(t1);
        assertNotNull(t2);
        assertNotEquals(t1.getClass(), t2.getClass(), "Les classes doivent être différentes dans le mode CYCLIC si au moins deux pièces");

        assertEquals(t1.getDefaultColor(), t1.getReferentElement().getCouleur(), "Doit être la couleur par défaut");
        assertEquals(t2.getDefaultColor(), t2.getReferentElement().getCouleur(), "Doit être la couleur par défaut");
    }
}
