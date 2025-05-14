package fr.eseo.e3a.poo.projet.blox.modele;

/**
 * Smallest, in game, element. Part of a blox
 */
public class Element {
    private Coordonnees coordonnees;
    private Couleur couleur;

    public Element(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Element(int abcisse, int ordonnee) {
        this.coordonnees = new Coordonnees(abcisse, ordonnee);
    }

    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    public Element(int abcisse, int ordonnee, Couleur couleur) {
        this.coordonnees = new Coordonnees(abcisse, ordonnee);
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
}
