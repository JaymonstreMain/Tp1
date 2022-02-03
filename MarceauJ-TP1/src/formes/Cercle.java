package formes;

import exceptions.FormeException;

public class Cercle {
    //Attributs constants (toujours publiques)
    public static final int MIN_VAL = 1;
    public static final int MAX_VAL = 30;
    public static final int RAYON_DEFAUT = 10;
    public static final String[] LES_COULEURS = {"rouge", "vert", "bleu", "jaune", "noir", "orange"};
    public static final String COULEUR_DEFAUT = "vert";

    //Attributs (toujours privés)
    private int rayon;
    private static String nom;
    private String couleur;

    //Constructeurs
    public Cercle() throws FormeException {
        this(RAYON_DEFAUT);
    }


    public Cercle(int rayon) throws FormeException {
        if (validerRayon(rayon)) {
            setRayon(rayon);
        } else {
            throw new FormeException();
        }

        Cercle.nom = "Cercle";

        setCouleur(COULEUR_DEFAUT);
    }

    public int calculerPerimetre() {
        return (int) (2 * Math.PI * this.rayon);
    }

    public int calculerSurface() {
        return (int) (Math.PI * Math.pow(this.rayon, 2));
    }

    public boolean equals(Object objet) {
        Cercle cercle = (Cercle) objet;
        boolean estEgal;

        if (cercle.calculerSurface() == calculerSurface() && cercle.getCouleur().equals(getCouleur())) {
            estEgal = true;
        } else {
            estEgal = false;
        }

        return estEgal;
    }

    public String toString() {
        return Cercle.nom + " " + this.couleur + " " + this.rayon;
    }

    public static void main(String[] args) {

    }

    //Accesseurs
    public String getCouleur() {
        return this.couleur;
    }

    public int getRayon() {
        return this.rayon;
    }

    public static String getNom() {
        return Cercle.nom;
    }

    //Mutateurs
    public void setCouleur(String couleur) {
        if (validerCouleur(couleur)) {
            this.couleur = couleur;
        } else {
            this.couleur = COULEUR_DEFAUT;
        }
    }

    public void setRayon(int rayon) {
        if (validerRayon(rayon)) {
            this.rayon = rayon;
        }
    }

    //Méthodes privées
    private static boolean validerCouleur(String couleur) {
        boolean estCouleurValide = false;
        for (int i = 0; i < LES_COULEURS.length; i++) {
            if (LES_COULEURS[i].equals(couleur.trim().toLowerCase())) {
                estCouleurValide = true;
                i = LES_COULEURS.length;
            }
        }

        return estCouleurValide;
    }

    private static boolean validerRayon(int rayon) {
        boolean estRayonValide;
        if (rayon >= MIN_VAL && rayon <= MAX_VAL) {
            estRayonValide = true;
        } else {
            estRayonValide = false;
        }

        return estRayonValide;
    }
}