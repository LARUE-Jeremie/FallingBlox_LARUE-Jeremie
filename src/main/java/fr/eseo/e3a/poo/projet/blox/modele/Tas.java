package fr.eseo.e3a.poo.projet.blox.modele;

import fr.eseo.e3a.poo.projet.blox.modele.pieces.IPiece;

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

    public Puits getPuits() {
        return this.puits;
    }

    public List<Element> getElements() {
        return this.elements;
    }

    public void ajouterElements(IPiece piece) {
        this.elements.addAll(piece.getElements());
    }

    public boolean peutAjouter(IPiece piece) {
        for (Element element : piece.getElements()) {
            Coordonnees pos = element.getCoordonnees();
            int x = pos.getAbscisse();
            int y = pos.getOrdonnee();
            if (x < 0 || x >= puits.getLargeur()) {
                return false;
            }
            if (y < 0 || y >= puits.getProfondeur()) {
                return false;
            }
            for (Element elTas : elements) {
                if (elTas.getCoordonnees().equals(pos)) {
                    return false;
                }
            }
        }
        return true;
    }
}
