package fr.eseo.e3a.poo.projet.blox.modele.pieces;

import java.util.List;
import fr.eseo.e3a.poo.projet.blox.modele.Element;

/**
 * Interface : any type of Blox
 */
public interface IPiece {
    /**
     * @return The needed number of elements in the blox
     */
    int getNbElements();
    /**
     * @return The list of elements in the blox
     */
    List<Element> getElements();
    /**
     * Set the position of a blox
     * @param abscisse x-coordinate position to set
     * @param ordonnee y-coordinate to set
     */
    void setPosition(int abscisse, int ordonnee);
}
