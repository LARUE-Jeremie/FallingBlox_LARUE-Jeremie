package fr.eseo.e3a.poo.projet.blox.modele.pieces;

import java.util.List;
import fr.eseo.e3a.poo.projet.blox.modele.Element;

/**
 * Interface : any type of Piece
 */
public interface IPiece {
    List<Element> getElements();
    void setPosition(int abscisse, int ordonnee);
}
