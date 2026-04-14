package de.hska.iwi.ads.solution.generics;

import de.hska.iwi.ads.generics.AbstractDeliveryService;
import de.hska.iwi.ads.generics.Address;
import de.hska.iwi.ads.generics.Box;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FoodDeliveryService<T> extends AbstractDeliveryService<T> {

    @Override
    public Map<Box<T>, Address> getFoodBoxes() {
        return stackOfFoodBoxes;
    }

    @Override
    public Set<Box<T>> deliver(Address address) {
        Set<Box<T>> result = new HashSet<>();

        // Sammeln
        for (Map.Entry<Box<T>, Address> entry : stackOfFoodBoxes.entrySet()) {
            if (entry.getValue().equals(address)) {
                result.add(entry.getKey());
            }
        }

        // Entfernen
        for (Box<T> box : result) {
            stackOfFoodBoxes.remove(box);
        }

        return result;
    }
}
