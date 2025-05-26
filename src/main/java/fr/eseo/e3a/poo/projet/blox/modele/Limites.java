package fr.eseo.e3a.poo.projet.blox.modele;

public class Limites {
    private final int minimum;
    private final int _default;
    private final int maximum;

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
