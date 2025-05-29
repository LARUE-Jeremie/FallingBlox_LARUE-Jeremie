package fr.eseo.e3a.poo.projet.blox.modele;

import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;

/**
 * Well, used as a playground for the game and blox
 */
public class Puits {
    private int largeur;
    private int profondeur;
    private final Limites LARGEUR_LIMITES = new Limites(5, 10, 15);
    private final Limites PROFONDEUR_LIMITES = new Limites(5, 10, 15);
    private IPiece pieceActuelle;
    private IPiece pieceSuivante;

    /**
     * Puits' Constructor
     */
    public Puits() {
        this.largeur = LARGEUR_LIMITES.getDefault();
        this.profondeur = PROFONDEUR_LIMITES.getDefault();
    }

    /**
     * Puits' Constructor
     * @param largeur width of a well
     * @param profondeur height of a well
     */
    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
    }

    public IPiece getPieceActuelle() {
        return pieceActuelle;
    }

    public IPiece getPieceSuivante() {
        return pieceSuivante;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setPieceSuivante(IPiece pieceSuivante) {
        if (this.pieceSuivante != null) {
            this.pieceActuelle = this.pieceSuivante;
            this.pieceActuelle.setPosition(largeur/2, -4);
        }
        this.pieceSuivante = pieceSuivante;
    }

    public void setProfondeur(int profondeur) {
        if (profondeur < PROFONDEUR_LIMITES.getMinimum() || PROFONDEUR_LIMITES.getMaximum() < profondeur) {
            throw new IllegalArgumentException("profondeur invalide");
        }
        this.profondeur = profondeur;
    }

    public void setLargeur(int largeur) {
        if (largeur < LARGEUR_LIMITES.getMinimum() || LARGEUR_LIMITES.getMaximum() < largeur) {
            throw new IllegalArgumentException("largeur invalide");
        }
        this.largeur = largeur;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
            .append("Puits : Dimension ")
            .append(largeur)
            .append(" x ")
            .append(profondeur)
            .append("\n")
            .append("Piece Actuelle : ")
            .append(pieceActuelle != null ? pieceActuelle : "<aucune>")
            .append("\n")
            .append("Piece Actuelle : ")
            .append(pieceSuivante != null ? pieceSuivante : "<aucune>")
            .append("\n");
        return stringBuilder.toString();
    }
}
