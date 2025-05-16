package fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3a.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3a.poo.projet.blox.modele.Couleur;
import fr.eseo.e3a.poo.projet.blox.modele.Element;
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
}
