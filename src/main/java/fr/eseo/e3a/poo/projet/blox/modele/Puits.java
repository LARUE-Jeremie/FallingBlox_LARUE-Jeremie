package fr.eseo.e3a.poo.projet.blox.modele;

import fr.eseo.e3a.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3a.poo.projet.blox.exception.BloxException;
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
    private final Tas tas;

    /**
     * Puits' Constructor
     */
    public Puits() {
        this.largeur = LARGEUR_LIMITES.getDefault();
        this.profondeur = PROFONDEUR_LIMITES.getDefault();
        this.pcs = new PropertyChangeSupport(this);
        this.tas = new Tas(this);
    }

    /**
     * Puits' Constructor
     * @param largeur width of the well
     * @param profondeur deepness of the well
     */
    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.pcs = new PropertyChangeSupport(this);
        this.tas = new Tas(this);
    }

    /**
     * Puits' Constructor
     * @param largeur width of the well
     * @param profondeur deepness of the well
     * @param nbElements number of elements
     * @param nbLignes number of lines
     */
    public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
        this.setLargeur(largeur);
        this.setProfondeur(profondeur);
        this.pcs = new PropertyChangeSupport(this);
        this.tas = new Tas(this, nbElements, nbLignes);
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

    public Tas getTas() {
        return this.tas;
    }

    /**
     * Manage the collision
     */
    private void gererCollision() {
        tas.ajouterElements(pieceActuelle);
        setPieceSuivante(pieceSuivante);
    }

    /**
     * Use the gravity
     */
    public void gravite() throws BloxException {
        if (pieceActuelle == null) {
            return;
        }
        if (peutDeplacer(pieceActuelle, 0, 1)) {
            pieceActuelle.deplacerDe(0, 1);
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, null, pieceActuelle);
        } else {
            if (!tas.peutAjouter(pieceActuelle)) {
                throw new BloxException("Impossible d'ajouter la pièce au tas.", 0);
            }
            tas.ajouterElements(pieceActuelle);
            IPiece ancienne = pieceActuelle;
            pieceActuelle = null;
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, ancienne, null);

            setPieceSuivante(pieceSuivante);
            setPieceSuivante(UsineDePiece.genererTetromino());
        }
    }

    public boolean peutDeplacer(IPiece piece, int deltaX, int deltaY) {
        for (Element element : piece.getElements()) {
            int x = element.getCoordonnees().getAbscisse() + deltaX;
            int y = element.getCoordonnees().getOrdonnee() + deltaY;
            // Hors limites du puits
            if (x < 0 || x >= getLargeur() || y < 0 || y >= getProfondeur()) {
                return false;
            }
            // Collision avec le tas
            for (Element elTas : tas.getElements()) {
                if (elTas.getCoordonnees().getAbscisse() == x &&
                        elTas.getCoordonnees().getOrdonnee() == y) {
                    return false;
                }
            }
        }
        return true;
    }
}
