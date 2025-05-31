package fr.eseo.e3a.poo.projet.blox.exception;

/**
 * Blox's exception
 */
public class BloxException extends Exception {
    public static final int BLOX_COLLISION = 0;
    public static final int BLOX_SORTIE_PUITS = 1;
    private final int type;

    /**
     * BloxException's Constructor
     *
     * @param message error's message
     * @param type exception's type
     */
    public BloxException(String message, int type) {
        super(message);
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}
