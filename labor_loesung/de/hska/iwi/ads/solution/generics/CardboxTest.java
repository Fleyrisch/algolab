package de.hska.iwi.ads.solution.generics;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CardboxTest {

    @Test
    void testCompareTo() {
        Cardbox<String> box1 = new Cardbox<>(10, "A");
        Cardbox<String> box2 = new Cardbox<>(20, "B");
        Cardbox<String> box3 = new Cardbox<>(10, "C");

        assertTrue(box1.compareTo(box2) < 0);
        assertTrue(box2.compareTo(box1) > 0);
        assertEquals(0, box1.compareTo(box3));
    }
}
