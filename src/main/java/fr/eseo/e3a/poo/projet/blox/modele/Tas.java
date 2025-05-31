package fr.eseo.e3a.poo.projet.blox.modele;

import java.util.*;

public class Tas {
    private final Puits puits;
    private final List<Element> elements;

    public Tas(Puits puits) {
        this.puits = puits;
        this.elements = new ArrayList<>();
    }

    // Constructeur 2 : nbElements, lignes calculées automatiquement
    public Tas(Puits puits, int nbElements) {
        this(puits, nbElements, (nbElements / puits.getLargeur()) + 1);
    }

    // Constructeur 3 : nbElements et nbLignes, avec Random par défaut
    public Tas(Puits puits, int nbElements, int nbLignes) {
        this(puits, nbElements, nbLignes, new Random());
    }

    // Constructeur 4 : version complète avec Random fourni
    public Tas(Puits puits, int nbElements, int nbLignes, Random random) {
        this.puits = puits;
        this.elements = new ArrayList<>();
        construireTas(nbElements, nbLignes, random);
    }

    // Méthode privée pour construire le tas aléatoirement
    private void construireTas(int nbElements, int nbLignes, Random random) {
        int largeur = puits.getLargeur();
        int profondeur = puits.getProfondeur();

        if (nbLignes > profondeur || nbElements > nbLignes * largeur) {
            throw new IllegalArgumentException("Trop d'éléments ou de lignes pour le puits.");
        }

        Set<String> positionsUtilisees = new HashSet<>();
        while (elements.size() < nbElements) {
            int x = random.nextInt(largeur);
            int y = profondeur - nbLignes + random.nextInt(nbLignes);
            String cle = x + "," + y;

            if (!positionsUtilisees.contains(cle)) {
                positionsUtilisees.add(cle);
                elements.add(new Element(new Coordonnees(x, y), Couleur.getRandomCouleur(random)));
            }
        }
    }

    // Accesseurs
    public Puits getPuits() {
        return this.puits;
    }

    public List<Element> getElements() {
        return this.elements;
    }
}
