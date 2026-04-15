package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class Mergesort<E extends Comparable<E>> extends AbstractMergesort<E> {
    @Override
    protected void mergesort(E[] a, int left, int right) {
        // Rekursives Aufteilen und danach Mergen
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(a, left, mid);
            mergesort(a, mid + 1, right);
            merge(a, b, left, mid, right);
        }
    }

    private void merge(E[] a,E[] b, int left,int mid, int right) {
        int l = left;
        int r = mid + 1;

        for (int i = left; i <= right; i++) {
            if ((r > right) || (l <= mid && a[l].compareTo(a[r]) <= 0)) {
                b[i] = a[l];
                l += 1;
            } else {
                b[i] = a[r];
                r += 1;
            }
        }
        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }
}