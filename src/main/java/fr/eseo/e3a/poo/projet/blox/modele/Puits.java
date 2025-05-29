package fr.eseo.e3a.poo.projet.blox.modele;

import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Well, used as a playground for the game and blox
 */
public class Puits {
    private int largeur;
    private int profondeur;
    private final Limites LARGEUR_LIMITES = new Limites(5, 10, 15);
    private final Limites PROFONDEUR_LIMITES = new Limites(5, 10, 15);
    private final int SPAWN_POINT = -4;
    private IPiece pieceActuelle;
    private IPiece pieceSuivante;
    private final PropertyChangeSupport pcs;
    public static final String MODIFICATION_PIECE_ACTUELLE = "modificationPieceActuelle";
    public static final String MODIFICATION_PIECE_SUIVANTE = "modificationPieceSuivante";

    public Puits() {
        this.largeur = LARGEUR_LIMITES.getDefault();
        this.profondeur = PROFONDEUR_LIMITES.getDefault();
        this.pcs = new PropertyChangeSupport(this);
    }

    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.pcs = new PropertyChangeSupport(this);
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

    public void setPieceSuivante(IPiece nouvellePieceSuivante) {
        IPiece anciennePieceActuelle = this.pieceActuelle;
        IPiece anciennePieceSuivante = this.pieceSuivante;
        this.pieceActuelle = anciennePieceSuivante;
        if (this.pieceActuelle != null) {
            this.pieceActuelle.setPuits(this);
            this.pieceActuelle.setPosition(largeur/2, SPAWN_POINT);
        }
        pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, anciennePieceActuelle, this.pieceActuelle);
        this.pieceSuivante = nouvellePieceSuivante;
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, anciennePieceSuivante, this.pieceSuivante);
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
        return "Puits : Dimension " + largeur + " x " + profondeur + "\n"
                + "Piece Actuelle : " + (pieceActuelle != null ? pieceActuelle : "<aucune>") + "\n"
                + "Piece Suivante : " + (pieceSuivante != null ? pieceSuivante : "<aucune>") + "\n";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
