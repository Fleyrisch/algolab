package de.hska.iwi.ads.solution.tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.dictionary.MapTest;

public class BinarySearchTreeTest extends MapTest {

  @Override
  public <K extends Comparable<K>, V> Map<K, V> createMap() {
    return new BinarySearchTree<K, V>();
  }

  @Test
  void putReturnsOldValueWhenKeyAlreadyExists() {
    Map<Integer, String> tree = createMap();

    assertNull(tree.put(4, "Vier"));
    assertEquals("Vier", tree.put(4, "Four"));

    assertEquals(1, tree.size());
    assertEquals("Four", tree.get(4));
  }

  @Test
  void supportsComparableStringKeys() {
    Map<String, Integer> tree = createMap();

    tree.put("m", 1);
    tree.put("a", 2);
    tree.put("z", 3);

    assertEquals(2, tree.get("a"));
    assertEquals(1, tree.get("m"));
    assertEquals(3, tree.get("z"));
    assertNull(tree.get("x"));
  }
}
