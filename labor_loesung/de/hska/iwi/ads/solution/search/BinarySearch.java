package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

  @Override
  public int search(E[] a, E key, int left, int right) {
    // key nicht in a[left...right] enthalten
    // key < a[left]
    if (key.compareTo(a[left]) < 0) {
      return left - 1;
    }
    // key > a[right]
    if (key.compareTo(a[right]) > 0) {
      return right + 1;
    }

    // a[left] <= key <= a[right]
    int insertionIndex = lowerBound(a, key, left, right);

    if (a[insertionIndex].compareTo(key) == 0) {
      return insertionIndex;
    }
    // a[i-1] < key < a[i]
    return insertionIndex;
  }

  private int lowerBound(E[] a, E key, int left, int right) {
    int low = left;
    int high = right;

    // Suchbereich um key herum halbieren bis low == high
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (a[mid].compareTo(key) < 0) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return low;
  }
}
