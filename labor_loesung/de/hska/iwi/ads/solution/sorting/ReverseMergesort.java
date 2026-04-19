package de.hska.iwi.ads.solution.sorting;

public class ReverseMergesort<E extends Comparable<E>> extends AbstractMergesortVariant<E> {
    @Override
    protected void beforeMerge(E[] a, int left, int mid, int right) {
        if (mid + 1 < right) {
            ReverseArray<E> reverser = new ReverseArray<>();
            reverser.reverse(a, mid + 1, right);
        }
    }

    @Override
    protected void merge(E[] a, E[] b, int left, int mid, int right) {
        int l = left;
        int r = right;

        for (int i = left; i <= right; i++) {
            if (l <= mid && (r <= mid || a[l].compareTo(a[r]) <= 0)) {
                b[i] = a[l];
                l++;
            } else {
                b[i] = a[r];
                r--;
            }
        }
    }
}
