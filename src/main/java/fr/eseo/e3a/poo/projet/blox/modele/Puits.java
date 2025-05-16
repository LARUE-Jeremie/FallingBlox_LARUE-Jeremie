package fr.eseo.e3a.poo.projet.blox.modele;

/**
 * Well, used as a playground for blox
 */
public class Puits {
    private final int LARGEUR_PAR_DEFAUT = 10;
    private final int PROFONDEUR_PAR_DEFAUT = 20;
    private int largeur;
    private int profondeur;

    public Puits() {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.profondeur = PROFONDEUR_PAR_DEFAUT;
    }

    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
    }
}
