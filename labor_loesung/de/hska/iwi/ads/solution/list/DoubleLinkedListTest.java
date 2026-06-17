package de.hska.iwi.ads.solution.list;

import java.util.Map;

import de.hska.iwi.ads.dictionary.MapTest;

public class DoubleLinkedListTest extends MapTest {

  @Override
  public <K extends Comparable<K>, V> Map<K, V> createMap() {
    return new DoubleLinkedList<>();
  }
}
