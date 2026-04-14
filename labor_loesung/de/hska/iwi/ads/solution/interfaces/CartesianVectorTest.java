package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.Vector;
import de.hska.iwi.ads.interfaces.VectorTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartesianVectorTest extends VectorTest {
    @Override
    public Vector createVector(double x, double y) {
        return new CartesianVector(x, y);
    }

    // Konstruktor und Getter testen
    @Test
    void testGetXAndY() {
        Vector v = createVector(3.0, -2.0);
        assertEquals(3.0, v.getX(), 0.0000001);
        assertEquals(-2.0, v.getY(), 0.0000001);
    }

    // Addition testen
    @Test
    void testAddNormal() {
        Vector v1 = createVector(1.0, 2.0);
        Vector v2 = createVector(3.0, 4.0);

        Vector result = v1.add(v2);

        assertEquals(4.0, result.getX(), 0.0000001);
        assertEquals(6.0, result.getY(), 0.0000001);
    }

    @Test
    void testAddNull() {
        Vector v = createVector(2.0, 3.0);

        Vector result = v.add(null);

        assertEquals(2.0, result.getX(), 0.0000001);
        assertEquals(3.0, result.getY(), 0.0000001);
    }

//    // Skalierung testen
//    @Test
//    void testScale() {
//        Vector v = createVector(2.0, 3.0);
//        v.scale(2.0);
//
//        assertEquals(4.0, v.getX(), 0.0000001);
//        assertEquals(6.0, v.getY(), 0.0000001);
//    }
//
//    @Test
//    void testScaleNegative() {
//        Vector v = createVector(1.0, 1.0);
//
//        try {
//            v.scale(-1.0);
//            fail("Exception expected");
//        } catch (IllegalArgumentException e) {}
//    }

    // Dimension/Länge testen
    @Test
    void testLength() {
        Vector v = createVector(3.0, 4.0);
        assertEquals(5.0, v.getLength(), 0.0000001);
    }

    @Test
    void testDimension() {
        Vector v = createVector(3.0, 4.0);
        assertEquals(5.0, v.getDimension(), 0.0000001);
    }

    // Unveränderlichkeit bei Addition
    @Test
    void testAddDoesNotModifyOriginal() {
        Vector v1 = createVector(1.0, 2.0);
        Vector v2 = createVector(3.0, 4.0);

        v1.add(v2);

        assertEquals(1.0, v1.getX(), 0.0000001);
        assertEquals(2.0, v1.getY(), 0.0000001);
    }
}
