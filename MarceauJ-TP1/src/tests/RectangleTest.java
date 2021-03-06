package tests;

import exceptions.FormeException;
import formes.Cercle;
import formes.Rectangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe RectangleTest
 * Cette classe gère les tests JUnit de la classe Rectangle
 *
 * @see java.lang.Object
 * @author Bob Binette
 * @version 0.1 : 26 janvier 2022
 */
public class RectangleTest {

    private Rectangle rectangle1, rectangle2, rectangle3, rectangle4, rectangle5, rectangle6;

    @Before
    public void setUp() throws FormeException {
        rectangle1 = new Rectangle(1, 1);
        rectangle2 = new Rectangle(2, 2);
        rectangle3 = new Rectangle(5, 10);
        rectangle4 = new Rectangle(10, 5);
        rectangle5 = new Rectangle(30, 11);
        rectangle6 = new Rectangle(12, 30);
    }

    @Test
    public void testInvalides() {
        try {
            new Rectangle(Rectangle.MIN_VAL - 1, Rectangle.MAX_VAL);
            fail("Rectangle invalide");

        } catch (FormeException e) {
        }

        try {
            new Rectangle(Rectangle.MAX_VAL, Rectangle.MIN_VAL - 1);
            fail("Rectangle invalide");

        } catch (FormeException e) {
        }

        try {
            new Rectangle(Rectangle.MIN_VAL - 1, Rectangle.MAX_VAL);
            fail("Rectangle invalide");

        } catch (FormeException e) {
        }

        try {
            new Rectangle(Rectangle.MAX_VAL, Rectangle.MIN_VAL - 1);
            fail("Rectangle invalide");

        } catch (FormeException e) {
        }

        try {
            new Rectangle(Rectangle.MIN_VAL - 1, Rectangle.MIN_VAL - 1);
            fail("Rectangle invalide");

        } catch (FormeException e) {
        }

        try {
            new Rectangle(Rectangle.MAX_VAL + 1, Rectangle.MAX_VAL + 1);
            fail("Rectangle invalide");

        } catch (FormeException e) {
        }
    }

    @Test
    public void calculerPerimetre() {
        assertEquals(rectangle1.calculerPerimetre(), 4);
        assertEquals(rectangle2.calculerPerimetre(), 8);
        assertEquals(rectangle3.calculerPerimetre(), 30);
        assertEquals(rectangle4.calculerPerimetre(), 30);
        assertEquals(rectangle5.calculerPerimetre(), 82);
        assertEquals(rectangle6.calculerPerimetre(), 84);
    }

    @Test
    public void calculerSurface() {
        assertEquals(rectangle1.calculerSurface(), 1);
        assertEquals(rectangle2.calculerSurface(), 4);
        assertEquals(rectangle3.calculerSurface(), 50);
        assertEquals(rectangle4.calculerSurface(), 50);
        assertEquals(rectangle5.calculerSurface(), 330);
        assertEquals(rectangle6.calculerSurface(), 360);
    }

    @Test
    public void testEquals() {
        assertTrue(rectangle3.equals(rectangle4));
    }

    @Test
    public void testToString() {
        assertEquals(rectangle1.toString(), "Rectangle rouge 1, 1");
        assertEquals(rectangle2.toString(), "Rectangle rouge 2, 2");
        assertEquals(rectangle3.toString(), "Rectangle rouge 5, 10");
        assertEquals(rectangle4.toString(), "Rectangle rouge 10, 5");
        assertEquals(rectangle5.toString(), "Rectangle rouge 30, 11");
        assertEquals(rectangle6.toString(), "Rectangle rouge 12, 30");
    }

    @Test
    public void getCouleur() {
        assertEquals(rectangle1.getCouleur(), Rectangle.COULEUR_DEFAUT);
        assertEquals(rectangle2.getCouleur(), Rectangle.COULEUR_DEFAUT);
        assertEquals(rectangle3.getCouleur(), Rectangle.COULEUR_DEFAUT);
        assertEquals(rectangle4.getCouleur(), Rectangle.COULEUR_DEFAUT);
        assertEquals(rectangle5.getCouleur(), Rectangle.COULEUR_DEFAUT);
        assertEquals(rectangle6.getCouleur(), Rectangle.COULEUR_DEFAUT);
    }

    @Test
    public void getHauteur() {
        assertEquals(rectangle1.getHauteur(), Rectangle.MIN_VAL);
        assertEquals(rectangle2.getHauteur(), 2);
        assertEquals(rectangle3.getHauteur(), 5);
        assertEquals(rectangle4.getHauteur(), 10);
        assertEquals(rectangle5.getHauteur(), Rectangle.MAX_VAL);
        assertEquals(rectangle6.getHauteur(), 12);
    }

    @Test
    public void getLargeur() {
        assertEquals(rectangle1.getLargeur(), Rectangle.MIN_VAL);
        assertEquals(rectangle2.getLargeur(), 2);
        assertEquals(rectangle3.getLargeur(), 10);
        assertEquals(rectangle4.getLargeur(), 5);
        assertEquals(rectangle5.getLargeur(), 11);
        assertEquals(rectangle6.getLargeur(), Rectangle.MAX_VAL);
    }

    @Test
    public void getNom() {
        assertEquals(rectangle1.getNom(), "Rectangle");
        assertEquals(rectangle2.getNom(), "Rectangle");
        assertEquals(rectangle3.getNom(), "Rectangle");
        assertEquals(rectangle4.getNom(), "Rectangle");
        assertEquals(rectangle5.getNom(), "Rectangle");
        assertEquals(rectangle6.getNom(), "Rectangle");
    }

    @Test
    public void setCouleur() {
        // Couleur vide
        rectangle1.setCouleur("");
        assertEquals(rectangle1.getCouleur(), Rectangle.COULEUR_DEFAUT);

        // Autre couleur
        rectangle2.setCouleur("violet");
        assertEquals(rectangle2.getCouleur(), Rectangle.COULEUR_DEFAUT);

        // Pour toutes les couleurs disponibles
        for (String c : Rectangle.LES_COULEURS) {
            rectangle3.setCouleur(c);
            assertEquals(rectangle3.getCouleur(), c);
        }
    }

    @Test
    public void setHauteur() {
        for (int x = 1; x <= 30; x++) {
            rectangle1.setHauteur(x);
            assertEquals(rectangle1.getHauteur(), x);
        }
    }

    @Test
    public void setLargeur() {
        for (int x = 1; x <= 30; x++) {
            rectangle1.setLargeur(x);
            assertEquals(rectangle1.getLargeur(), x);
        }
    }
}