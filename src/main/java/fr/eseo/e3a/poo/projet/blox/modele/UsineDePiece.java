package fr.eseo.e3a.poo.projet.blox.modele;

import fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos.*;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Generating blox based on the selected mode
 */
public class UsineDePiece {
    private static int _mode = ModesDeGeneration.ALEATOIRE_PIECE.getId();
    private static int cyclicIndex = 0;
    private static final Random random = new Random();
    private static final int DEFAULT_ABSCISSE = 2;
    private static final int DEFAULT_ORDONNEE = 3;

    private static final Couleur[] COULEURS = Couleur.values();
    private static final List<Class<? extends Tetromino>> TETROMINO_CLASSES = Arrays.asList(
        TetrominoO.class,
        TetrominoI.class
    );

    /**
     * UsineDePiece's constructor; empty because it's a static class
     */
    private UsineDePiece() {
    }

    /**
     * Set the chosen mode
     * @param mode the chosen mode
     */
    public static void setMode(int mode) {
        _mode = ModesDeGeneration.values()[mode].getId();
        if (mode == ModesDeGeneration.CYCLIC.getId()) {
            cyclicIndex = 0;
        }
    }

    /**
     * Create new intance of a Tetromino
     */
    private static Tetromino instancierTetromino(Class<? extends Tetromino> clazz, Coordonnees coordonnees, Couleur couleur) {
        try {
            Constructor<? extends Tetromino> constructeur = clazz.getConstructor(Coordonnees.class, Couleur.class);
            return constructeur.newInstance(coordonnees, couleur);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l’instanciation du Tetromino", e);
        }
    }

    /**
     * Generate a new Tetromino, depends on the mode
     * @return a new Tetromino
     */
    public static Tetromino genererTetromino() {
        Coordonnees coordonnees = new Coordonnees(DEFAULT_ABSCISSE, DEFAULT_ORDONNEE);

        switch (_mode) {
            case 0: // ALEATOIRE_COMPLET
                Couleur couleurRandom = COULEURS[random.nextInt(COULEURS.length)];
                Class<? extends Tetromino> classeRandom = TETROMINO_CLASSES.get(random.nextInt(TETROMINO_CLASSES.size()));
                return instancierTetromino(classeRandom, coordonnees, couleurRandom);

            case 2: // CYCLIC
                Class<? extends Tetromino> classeCyclic = TETROMINO_CLASSES.get(cyclicIndex);
                // tempBlox with a default color
                Tetromino tempBloxCyclic = instancierTetromino(classeCyclic, coordonnees, Couleur.ROUGE);
                Couleur defaultColor = tempBloxCyclic.getDefaultColor();
                Tetromino blox = instancierTetromino(classeCyclic, coordonnees, defaultColor);
                cyclicIndex = (cyclicIndex + 1) % TETROMINO_CLASSES.size();
                return blox;

            case 1: // ALEATOIRE_PIECE
            default:
                Class<? extends Tetromino> classe = TETROMINO_CLASSES.get(random.nextInt(TETROMINO_CLASSES.size()));
                // tempBlox with a default color
                Tetromino tempBlox = instancierTetromino(classe, coordonnees, Couleur.ROUGE);
                return instancierTetromino(classe, coordonnees, tempBlox.getDefaultColor());
        }
    }
}
