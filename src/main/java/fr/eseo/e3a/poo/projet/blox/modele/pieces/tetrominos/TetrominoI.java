package fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3a.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3a.poo.projet.blox.modele.Couleur;
import fr.eseo.e3a.poo.projet.blox.modele.Element;
import java.util.List;

public class TetrominoI extends Tetromino {

    private final Couleur defaultColor = Couleur.ORANGE;
    private Element referentElement;

    /**
     * Tetromino's Constructor
     * @param coordonnees localisation of a blox
     * @param couleur color of a blox
     */
    public TetrominoI(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        int x_reference = coordonnees.getAbscisse();
        int y_reference = coordonnees.getOrdonnee();
        this.elements.add(new Element(x_reference, y_reference +1, couleur));
        referentElement = new Element(x_reference, y_reference, couleur);
        this.elements.add(referentElement);
        this.elements.add(new Element(x_reference, y_reference -1, couleur));
        this.elements.add(new Element(x_reference, y_reference -2, couleur));
    }

    @Override
    public Couleur getDefaultColor() {
        return defaultColor;
    }

    @Override
    public List<Element> getElements() {
        return super.getElements();
    }

    @Override
    public Element getReferentElement() {
        return referentElement;
    }

    @Override
    public String toString() {
        return "TetrominoI :\n" + super.toString();
    }
}
