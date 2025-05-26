package fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3a.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3a.poo.projet.blox.modele.Couleur;
import fr.eseo.e3a.poo.projet.blox.modele.Element;

import java.util.List;

public class TetrominoO extends Tetromino {

    private final Couleur defaultColor = Couleur.ROUGE;
    private Element referentElement;

    public TetrominoO(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        int x_reference = coordonnees.getAbscisse();
        int y_reference = coordonnees.getOrdonnee();
        referentElement = new Element(x_reference, y_reference, couleur);
        this.elements.add(referentElement);
        this.elements.add(new Element(x_reference, y_reference -1, couleur));
        this.elements.add(new Element(x_reference +1, y_reference -1, couleur));
        this.elements.add(new Element(x_reference +1, y_reference, couleur));
    }

    @Override
    public List<Element> getElements() {
        return super.getElements();
    }

    @Override
    public Couleur getDefaultColor() {
        return defaultColor;
    }

    @Override
    public Element getReferentElement() {
        return referentElement;
    }

    @Override
    public String toString() {
        return "TetrominoO :\n" + super.toString();
    }
}
