package fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3a.poo.projet.blox.exception.BloxException;
import fr.eseo.e3a.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3a.poo.projet.blox.modele.Couleur;
import fr.eseo.e3a.poo.projet.blox.modele.Element;
import fr.eseo.e3a.poo.projet.blox.modele.Puits;
import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base for : Tetrominos; 4 elements
 */
public abstract class Tetromino implements IPiece {

    protected static final int NB_REQUIRED_ELEMENTS = 4;
    protected List<Element> elements;
    protected Coordonnees coordonnees;
    protected Puits puits;

    /**
     * Tetromino's Constructor
     * @param coordonnees localisation of a blox
     * @param couleur color of a blox
     */
    public Tetromino(Coordonnees coordonnees, Couleur couleur) {
        this.elements = new ArrayList<>();
        setElements(coordonnees, couleur);

        if (this.elements == null || this.elements.size() != NB_REQUIRED_ELEMENTS) {
            throw new IllegalStateException("Un tetromino doit comporter exactement " + NB_REQUIRED_ELEMENTS + " éléments.");
        }
        if (this.coordonnees == null || this.coordonnees != coordonnees) {
            throw new IllegalStateException("Le tetromino n'est pas a la bonne position. postion : " + this.coordonnees + " | devrait être : " + coordonnees);
        }
    }

    /**
     * Set the elements of a blox
     * @param coordonnees localisation of a blox
     * @param couleur color of a blox
     */
    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    @Override
    public int getNbRequiredElements() {
        return NB_REQUIRED_ELEMENTS;
    }

    @Override
    public List<Element> getElements() {
        return this.elements;
    }

    @Override
    public void setPosition(int abscisse, int ordonnee) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
    }

    @Override
    public Puits getPuits() {
        return puits;
    }

    @Override
    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Element e : this.getElements()) {
            stringBuilder
                .append("    (")
                .append(e.getCoordonnees().getAbscisse())
                .append(", ")
                .append(e.getCoordonnees().getOrdonnee())
                .append(") - ")
                .append(e.getCouleur())
                .append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException, BloxException {
        boolean deplacementHorizontal = (deltaX != 0 && deltaY == 0);
        boolean deplacementVertical = (deltaX == 0 && deltaY > 0);
        if (!deplacementHorizontal && !deplacementVertical) {
            throw new IllegalArgumentException(
                    "Déplacement invalide, uniquement autorisé :\n" +
                            "horizontale vers la gauche/droite\n" +
                            "verticale vers le bas."
            );
        }
        Puits puits = getPuits();
        if (puits != null) {
            int largeur = puits.getLargeur();
            int profondeur = puits.getProfondeur();
            List<Element> elementsTas = puits.getTas().getElements();
            for (Element element : elements) {
                int newX = element.getCoordonnees().getAbscisse() + deltaX;
                int newY = element.getCoordonnees().getOrdonnee() + deltaY;
                if (newX < 0 || newX >= largeur || newY >= profondeur) {
                    throw new BloxException("La pièce sort du puits", BloxException.BLOX_SORTIE_PUITS);
                }
                for (Element tasElement : elementsTas) {
                    if (tasElement.getCoordonnees().getAbscisse() == newX &&
                            tasElement.getCoordonnees().getOrdonnee() == newY) {
                        throw new BloxException("Collision avec un élément du tas", BloxException.BLOX_COLLISION);
                    }
                }
            }
        }
        for (Element element : elements) {
            element.deplacerDe(deltaX, deltaY);
        }
    }

    @Override
    public void tourner(boolean sensHoraire) throws IllegalArgumentException, BloxException {
        Element referent = getReferentElement();
        int xRef = referent.getCoordonnees().getAbscisse();
        int yRef = referent.getCoordonnees().getOrdonnee();

        for (Element element : elements) {
            if (element != referent) {
                int x = element.getCoordonnees().getAbscisse();
                int y = element.getCoordonnees().getOrdonnee();

                // 1. Translater au pivot
                int dx = x - xRef;
                int dy = y - yRef;

                // 2. Rotation
                int xRot, yRot;
                if (sensHoraire) {
                    xRot = dy;
                    yRot = -dx;
                } else {
                    xRot = -dy;
                    yRot = dx;
                }

                // 3. Retranslation
                element.getCoordonnees().setAbscisse(xRef + xRot);
                element.getCoordonnees().setOrdonnee(yRef + yRot);
            }
        }
    }
}
