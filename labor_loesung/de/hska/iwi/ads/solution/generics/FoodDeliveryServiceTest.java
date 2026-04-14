package de.hska.iwi.ads.solution.generics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.generics.Address;
import de.hska.iwi.ads.generics.Pizza;

public class FoodDeliveryServiceTest {

    @Test
    void testDeliver() {
        FoodDeliveryService<Pizza> service = new FoodDeliveryService<>();

        Address addr1 = new Address("Karlsruhe");
        Address addr2 = new Address("Berlin");

        Cardbox<Pizza> box1 = new Cardbox<>(10, new Pizza("Margherita"));
        Cardbox<Pizza> box2 = new Cardbox<>(20, new Pizza("Salami"));
        Cardbox<Pizza> box3 = new Cardbox<>(15, new Pizza("Funghi"));

        service.addBox(box1, addr1);
        service.addBox(box2, addr2);
        service.addBox(box3, addr1);

        // Lieferung für addr1
        Set<?> delivered = service.deliver(addr1);

        // Nur richtige Boxen geliefert?
        assertEquals(2, delivered.size());
        assertTrue(delivered.contains(box1));
        assertFalse(delivered.contains(box2));
        assertTrue(delivered.contains(box3));

        // Wurden sie entfernt?
        assertEquals(1, service.getFoodBoxes().size());
        assertFalse(service.getFoodBoxes().containsKey(box1));
        assertTrue(service.getFoodBoxes().containsKey(box2));
        assertFalse(service.getFoodBoxes().containsKey(box3));
    }
}