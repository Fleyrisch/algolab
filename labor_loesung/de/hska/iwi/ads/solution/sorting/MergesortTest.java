package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.sorting.Sort;

public class MergesortTest {

  private <E extends Comparable<E>> void sort(E[] a) {
    Sort<E> sort = createSort();
    sort.sort(a);
  }

  private <E extends Comparable<E>> Sort<E> createSort() {
    return new Mergesort<>();
  }

  @Test
  void testSortEmptyArray() {
    Integer[] a = {};

    sort(a);

    assertArrayEquals(new Integer[] {}, a);
  }

  @Test
  void testSortSingleElement() {
    Integer[] a = {42};

    sort(a);

    assertArrayEquals(new Integer[] {42}, a);
  }

  @Test
  void testSortUnsortedIntegers() {
    Integer[] a = {5, 1, 4, 2, 3};

    sort(a);

    assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, a);
  }

  @Test
  void testSortReverseSortedIntegers() {
    Integer[] a = {9, 7, 5, 3, 1};

    sort(a);

    assertArrayEquals(new Integer[] {1, 3, 5, 7, 9}, a);
  }

  @Test
  void testSortArrayWithDuplicates() {
    Integer[] a = {4, 2, 4, 1, 2, 3};

    sort(a);

    assertArrayEquals(new Integer[] {1, 2, 2, 3, 4, 4}, a);
  }

  @Test
  void testSortStrings() {
    String[] a = {"delta", "alpha", "charlie", "bravo"};

    sort(a);

    assertArrayEquals(new String[] {"alpha", "bravo", "charlie", "delta"}, a);
  }

  @Test
  void testSortIsStableForEqualKeys() {
    StableElement[] a = {
        new StableElement(2, "A"),
        new StableElement(1, "B"),
        new StableElement(2, "C"),
        new StableElement(1, "D"),
        new StableElement(2, "E")
    };

    sort(a);

    assertArrayEquals(
        new StableElement[] {
            new StableElement(1, "B"),
            new StableElement(1, "D"),
            new StableElement(2, "A"),
            new StableElement(2, "C"),
            new StableElement(2, "E")
        },
        a
    );
  }

  private static final class StableElement implements Comparable<StableElement> {
    private final int key;
    private final String id;

    private StableElement(int key, String id) {
      this.key = key;
      this.id = id;
    }

    @Override
    public int compareTo(StableElement other) {
      return Integer.compare(this.key, other.key);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof StableElement other)) {
        return false;
      }
      return this.key == other.key && this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
      return 31 * key + id.hashCode();
    }
  }
}
