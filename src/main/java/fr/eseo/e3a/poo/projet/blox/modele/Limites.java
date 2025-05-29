package fr.eseo.e3a.poo.projet.blox.modele;

/**
 * Set up limits' values for well
 */
public class Limites {
    private final int minimum;
    private final int _default;
    private final int maximum;

    /**
     * Limites's Constructor
     * @param minimum minimum value for the limites
     * @param _default default value
     * @param maximum maximum value for the limites
     */
    public Limites(int minimum, int _default, int maximum) {
        this.minimum = minimum;
        this._default = _default;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getDefault() {
        return _default;
    }

    public int getMaximum() {
        return maximum;
    }
}
