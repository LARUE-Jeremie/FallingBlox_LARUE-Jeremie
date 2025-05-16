package fr.eseo.e3a.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3a.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3a.poo.projet.blox.modele.Couleur;
import fr.eseo.e3a.poo.projet.blox.modele.Element;

public class TetrominoI extends Tetromino {

    public TetrominoI(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        int x_reference = coordonnees.getAbscisse();
        int y_reference = coordonnees.getOrdonnee();
        this.elements.add(new Element(x_reference, y_reference +1, couleur));
        this.elements.add(new Element(x_reference, y_reference, couleur));
        this.elements.add(new Element(x_reference, y_reference -1, couleur));
        this.elements.add(new Element(x_reference, y_reference -2, couleur));
    }

    @Override
    public String toString() {
        return null; // TODO
    }
}
