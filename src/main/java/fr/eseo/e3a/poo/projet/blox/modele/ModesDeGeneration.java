package fr.eseo.e3a.poo.projet.blox.modele;

/**
 * Enum : Generation modes enabled
 */
public enum ModesDeGeneration {
    ALEATOIRE_COMPLET(0),
    ALEATOIRE_PIECE(1),
    CYCLIC(2);

    private int id;

    /**
     * ModesDeGeneration's Constructor
     * @param id number linked to a mode
     */
    ModesDeGeneration(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
