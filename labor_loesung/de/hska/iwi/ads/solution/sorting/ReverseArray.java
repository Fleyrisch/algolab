package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {
    @Override
    public void reverse(E[] a, int from, int to) {
        int left =  from;
        int right = to;
        // Elemente vertauschen
        while (left < right) {
            E temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            // Grenzen verschieben
            left++;
            right--;
        }
    }
}
