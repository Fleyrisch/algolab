package de.hska.iwi.ads.solution.sorting;

public class Mergesort<E extends Comparable<E>> extends AbstractMergesortVariant<E> {
    @Override
    protected void merge(E[] a, E[] b, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;

        for (int i = left; i <= right; i++) {
            if ((r > right) || (l <= mid && a[l].compareTo(a[r]) <= 0)) {
                b[i] = a[l];
                l++;
            } else {
                b[i] = a[r];
                r++;
            }
        }
    }
}
