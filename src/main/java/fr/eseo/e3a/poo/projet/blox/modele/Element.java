package fr.eseo.e3a.poo.projet.blox.modele;

/**
 * Smallest, in game, element. Part of a blox
 */
public class Element {
    private Coordonnees coordonnees;
    private Couleur couleur;

    /**
     * Element's Constructor
     * @param coordonnees localisation of an element
     */
    public Element(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    /**
     * Element's Constructor
     * @param abscisse x-coordinate position to set
     * @param ordonnee y-coordinate to set
     */
    public Element(int abscisse, int ordonnee) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
    }

    /**
     * Element's Constructor
     * @param coordonnees localisation of an element
     * @param couleur color of an element
     */
    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    /**
     * Element's Constructor
     * @param abscisse x-coordinate position to set
     * @param ordonnee y-coordinate to set
     * @param couleur color of an element
     */
    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
        this.couleur = couleur;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "(" + this.coordonnees.getAbscisse() + ", " + this.coordonnees.getOrdonnee() + ") - " + this.couleur;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Element element = (Element) obj;
        return (
            this.coordonnees.getAbscisse() == element.coordonnees.getAbscisse() &&
            this.coordonnees.getOrdonnee() == element.coordonnees.getOrdonnee() &&
            this.couleur == element.couleur
        );
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(coordonnees, couleur);
    }

    /**
     * Make a move on an element
     * @param deltaX x-coordinate vector
     * @param deltaY y-coordinate vector
     */
    public void deplacerDe(int deltaX, int deltaY) {
        this.coordonnees.setAbscisse(this.coordonnees.getAbscisse() + deltaX);
        this.coordonnees.setOrdonnee(this.coordonnees.getOrdonnee() + deltaY);
    }
}
