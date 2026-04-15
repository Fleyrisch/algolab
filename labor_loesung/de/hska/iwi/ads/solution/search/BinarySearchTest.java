package de.hska.iwi.ads.solution.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;

public class BinarySearchTest extends SearchTest {

  @Override
  public <E extends Comparable<E>> Search<E> createSearch() {
    return new BinarySearch<>();
  }

  @Test
  void testDuplicateValuesReturnLowestIndexInSubRange() {
    Integer[] a = {0, 2, 2, 2, 2, 5};
    Search<Integer> search = createSearch();

    assertEquals(2, search.search(a, 2, 2, 4));
  }

  @Test
  void testMissingValueReturnsInsertionPointInsideSubRange() {
    Integer[] a = {0, 2, 4, 6, 8, 10};
    Search<Integer> search = createSearch();

    assertEquals(3, search.search(a, 5, 1, 4));
  }

  @Test
  void testAllEqualValuesStillReturnLowestIndex() {
    Integer[] a = {4, 4, 4, 4, 4, 4};
    Search<Integer> search = createSearch();

    assertEquals(0, search.search(a, 4));
  }
}
