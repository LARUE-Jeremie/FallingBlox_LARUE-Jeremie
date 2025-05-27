package fr.eseo.e3a.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.*;

public class CouleurTest {

    @Test
    public void testCouleursEnumAssociees() {
        assertEquals(Color.RED, Couleur.ROUGE.getCouleurPourAffichage());
        assertEquals(Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage());
        assertEquals(Color.BLUE, Couleur.BLEU.getCouleurPourAffichage());
        assertEquals(Color.GREEN, Couleur.VERT.getCouleurPourAffichage());
        assertEquals(Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage());
        assertEquals(Color.CYAN, Couleur.CYAN.getCouleurPourAffichage());
        assertEquals(Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage());
    }

    @Test
    public void testNonNullColors() {
        for (Couleur couleur : Couleur.values()) {
            assertNotNull(couleur.getCouleurPourAffichage(), "Couleur pour affichage ne doit pas être nulle");
        }
    }
}
