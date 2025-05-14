package fr.eseo.e3a.poo.projet.blox.modele;

/**
 * Coordonnees of an element
 */
public class Coordonnees {

    private int abscisse;
    private int ordonnee;


    /**
     * Coordonnees' constructor
     * @param abscisse
     * @param ordonnee
     */
    public Coordonnees(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }


    public int getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    @Override
    public String toString() {
        return "(" + abscisse + ", " + ordonnee + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Coordonnees coordonnees = (Coordonnees) obj;
        return (
                this.getAbscisse() == coordonnees.getAbscisse() &&
                this.getOrdonnee() == coordonnees.getOrdonnee()
        );
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(abscisse, ordonnee);
    }
}
