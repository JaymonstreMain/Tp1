package formes;

import exceptions.FormeException;

public class Rectangle {

    //Attributs constants (toujours publics)
    public static final int MIN_VAL = 1;
    public static final int MAX_VAL = 30;
    public static final String[] LES_COULEURS = {"rouge", "vert", "bleu", "jaune", "noir", "orange"};
    public static final String COULEUR_DEFAUT = "rouge";

    //Atributs (toujours privés)
    private int hauteur;
    private int largeur;
    private static String nom;
    private String couleur;

    //Constructeurs
    public Rectangle(int pHauteur, int pLargeur) throws FormeException {
        if (validerHauteur(pHauteur) && validerLargeur(pLargeur)) {
            setHauteur(pHauteur);
            setLargeur(pLargeur);
        } else {
            throw new FormeException();
        }

        Rectangle.nom = "Rectangle";

        setCouleur(COULEUR_DEFAUT);
    }

    //Méthodes publiques
    public int calculerPerimetre() {
        return ((2 * this.hauteur) + (2 * this.largeur));
    }

    public int calculerSurface() {
        return (this.hauteur * this.largeur);
    }

    public boolean equals(Object pObjet) {
        Rectangle rectObjet = (Rectangle) pObjet;

        boolean estEgal;

        if (rectObjet.calculerSurface() == calculerSurface() && rectObjet.getCouleur().equals(getCouleur())) {
            estEgal = true;
        } else {
            estEgal = false;
        }

        return estEgal;
    }

    public String toString() {
        return (Rectangle.nom + " " + this.couleur + " " + this.hauteur + ", " + this.largeur);
    }

    //Accesseurs
    public String getCouleur() {
        return this.couleur;
    }

    public int getHauteur() {
        return this.hauteur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public static String getNom() {
        return Rectangle.nom;
    }

    //Mutateurs
    public void setCouleur(String pCouleur) {
        if (validerCouleur(pCouleur)) {
            this.couleur = pCouleur;
        } else {
            this.couleur = COULEUR_DEFAUT;
        }
    }

    public void setHauteur(int pHauteur) {
        if (validerHauteur(pHauteur)) {
            this.hauteur = pHauteur;
        }
    }

    public void setLargeur(int pLargeur) {
        if (validerLargeur(pLargeur)) {
            this.largeur = pLargeur;
        }
    }

    //Méthodes privées
    private static boolean validerCouleur(String pCouleur) {
        boolean estCouleurValide = false;

        for (int i = 0; i < LES_COULEURS.length; i++) {
            if (LES_COULEURS[i].equals(pCouleur.trim().toLowerCase())) {
                estCouleurValide = true;
                break;
            }
        }

        return estCouleurValide;
    }

    private static boolean validerHauteur(int pHauteur) {
        boolean estHauteurValide;

        if (pHauteur >= MIN_VAL && pHauteur <= MAX_VAL) {
            estHauteurValide = true;
        } else {
            estHauteurValide = false;
        }

        return estHauteurValide;
    }

    private static boolean validerLargeur(int pLargeur) {
        boolean estLargeurValide;

        if (pLargeur >= MIN_VAL && pLargeur <= MAX_VAL) {
            estLargeurValide = true;
        } else {
            estLargeurValide = false;
        }

        return estLargeurValide;
    }
}