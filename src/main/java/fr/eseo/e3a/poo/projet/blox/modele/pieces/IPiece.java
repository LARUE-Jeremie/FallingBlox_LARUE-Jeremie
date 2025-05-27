package fr.eseo.e3a.poo.projet.blox.modele.pieces;

import java.util.List;
import fr.eseo.e3a.poo.projet.blox.modele.Couleur;
import fr.eseo.e3a.poo.projet.blox.modele.Element;
import fr.eseo.e3a.poo.projet.blox.modele.Puits;

/**
 * Interface : any type of Blox
 */
public interface IPiece {
    /**
     * Get the required number of elements in the blox
     * @return the required number of elements
     */
    int getNbRequiredElements();

    /**
     * Get the list of elements in the blox
     * @return the list of elements
     */
    List<Element> getElements();

    /**
     * Set the position of a blox
     * @param abscisse x-coordinate position to set
     * @param ordonnee y-coordinate to set
     */
    void setPosition(int abscisse, int ordonnee);

    /**
     * Get the well; where the blox is
     * @return the well
     */
    Puits getPuits();

    /**
     * Get the well; where the blox is
     * @param puits the well
     */
    void setPuits(Puits puits);

    /**
     * Get the referent element of a blox
     * @return
     */
    Element getReferentElement();

    /**
     * Get the default color of a blox
     * @return
     */
    Couleur getDefaultColor();
}
