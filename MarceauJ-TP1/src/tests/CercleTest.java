package tests;

import exceptions.FormeException;
import formes.Cercle;
import formes.Rectangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CercleTest {

    private Cercle cercle1, cercle2, cercle3, cercle4;

    @Before
    public void setUp() throws Exception {
        cercle1 = new Cercle(Cercle.MIN_VAL);
        cercle2 = new Cercle();
        cercle3 = new Cercle(Cercle.MAX_VAL);
        cercle4 = new Cercle(2);
    }

    @Test
    public void testInvalides() {
        try {
            new Cercle(Cercle.MIN_VAL - 1);
            fail("Cercle invalide");

        } catch (FormeException e) {
        }

        try {
            new Cercle(Cercle.MAX_VAL + 1);
            fail("Cercle invalide");

        } catch (FormeException e) {
        }
    }

    @Test
    public void calculerPerimetre() {
        assertEquals(cercle1.calculerPerimetre(), 6);
        assertEquals(cercle2.calculerPerimetre(), 12);
        assertEquals(cercle3.calculerPerimetre(), 188);
    }

    @Test
    public void calculerSurface() {
        assertEquals(cercle1.calculerSurface(), 3);
        assertEquals(cercle2.calculerSurface(), 12);
        assertEquals(cercle3.calculerSurface(), 2827);
    }

    @Test
    public void testEquals() {
        assertTrue(cercle2.equals(cercle4));
    }

    @Test
    public void testToString() {
        assertEquals(cercle1.toString(), "Cercle vert 1");
        assertEquals(cercle2.toString(), "Cercle vert 2");
        assertEquals(cercle3.toString(), "Cercle vert 30");
    }

    @Test
    public void main() {
    }

    @Test
    public void getCouleur() {
        assertEquals(cercle1.getCouleur(), Cercle.COULEUR_DEFAUT);
        assertEquals(cercle2.getCouleur(), Cercle.COULEUR_DEFAUT);
        assertEquals(cercle3.getCouleur(), Cercle.COULEUR_DEFAUT);
    }

    @Test
    public void getRayon() {
        assertEquals(cercle1.getRayon(), Cercle.MIN_VAL);
        assertEquals(cercle2.getRayon(), 2);
        assertEquals(cercle3.getRayon(), Cercle.MAX_VAL);
    }

    @Test
    public void getNom() {
        assertEquals(cercle1.getNom(), "Cercle");
        assertEquals(cercle2.getNom(), "Cercle");
        assertEquals(cercle3.getNom(), "Cercle");
    }

    @Test
    public void setCouleur() {
        // Couleur vide
        cercle1.setCouleur("");
        assertEquals(cercle1.getCouleur(), Cercle.COULEUR_DEFAUT);

        // Autre couleur
        cercle2.setCouleur("violet");
        assertEquals(cercle2.getCouleur(), Cercle.COULEUR_DEFAUT);

        // Pour toutes les couleurs disponibles
        for (String c : Rectangle.LES_COULEURS) {
            cercle3.setCouleur(c);
            assertEquals(cercle3.getCouleur(), c);
        }
    }

    @Test
    public void setRayon() {
        for (int x = 1; x <= 30; x++) {
            cercle1.setRayon(x);
            assertEquals(cercle1.getRayon(), x);
        }
    }
}