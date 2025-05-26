package fr.eseo.e3a.poo.projet.blox.modele;

public enum ModesDeGeneration {
    ALEATOIRE_COMPLET(0),
    ALEATOIRE_PIECE(1),
    CYCLIC(2);

    private int id;

    ModesDeGeneration(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
