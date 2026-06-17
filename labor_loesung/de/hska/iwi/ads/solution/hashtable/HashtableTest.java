package de.hska.iwi.ads.solution.hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.dictionary.AbstractDictionary.DictionaryFullException;
import de.hska.iwi.ads.dictionary.MapTest;

public class HashtableTest extends MapTest {

  @Override
  public <K extends Comparable<K>, V> Map<K, V> createMap() {
    return new Hashtable<>(23);
  }

  @Test
  void testOverwriteReturnsOldValue() {
    Map<Integer, String> map = createMap();

    map.put(1, "Eins");

    assertEquals("Eins", map.put(1, "One"));
    assertEquals("One", map.get(1));
    assertEquals(1, map.size());
  }

  @Test
  void testQuadraticProbingHandlesCollisions() {
    Map<Integer, String> map = new Hashtable<>(11);

    map.put(1, "Eins");
    map.put(12, "Zwoelf");
    map.put(23, "Dreiundzwanzig");

    assertEquals("Eins", map.get(1));
    assertEquals("Zwoelf", map.get(12));
    assertEquals("Dreiundzwanzig", map.get(23));
    assertEquals(3, map.size());
  }

  @Test
  void testFullTableThrowsDictionaryFullException() {
    Map<Integer, String> map = new Hashtable<>(1);

    map.put(1, "Eins");

    assertThrows(DictionaryFullException.class, () -> map.put(2, "Zwei"));
  }

  @Test
  void testRemoveIsUnsupported() {
    Map<Integer, String> map = createMap();

    assertThrows(UnsupportedOperationException.class, () -> map.remove(1));
  }
}
