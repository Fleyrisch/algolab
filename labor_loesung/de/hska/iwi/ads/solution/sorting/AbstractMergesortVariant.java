package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

abstract class AbstractMergesortVariant<E extends Comparable<E>> extends AbstractMergesort<E> {

    @Override
    protected final void mergesort(E[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergesort(a, left, mid);
        mergesort(a, mid + 1, right);
        beforeMerge(a, left, mid, right);
        merge(a, b, left, mid, right);
        copyBack(a, left, right);
    }

    protected void beforeMerge(E[] a, int left, int mid, int right) {
    }

    protected abstract void merge(E[] a, E[] b, int left, int mid, int right);

    private void copyBack(E[] a, int left, int right) {
        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }
}
