package fr.eseo.e3a.poo.projet.blox.modele.pieces;

import java.util.List;
import fr.eseo.e3a.poo.projet.blox.modele.Element;

/**
 * Interface : any type of Blox
 */
public interface IPiece {
    /**
     * Get the required number of elements in the blox
     * @return NB_REQUIRED_ELEMENTS : int
     */
    int getNbRequiredElements();

    /**
     * Get the list of elements in the blox
     * @return elements : Element[]
     */
    List<Element> getElements();

    /**
     * Set the position of a blox
     * @param abscisse x-coordinate position to set
     * @param ordonnee y-coordinate to set
     */
    void setPosition(int abscisse, int ordonnee);
}
