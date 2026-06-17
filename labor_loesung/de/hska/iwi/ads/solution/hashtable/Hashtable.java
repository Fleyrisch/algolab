package de.hska.iwi.ads.solution.hashtable;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

import de.hska.iwi.ads.dictionary.AbstractDictionary.DictionaryFullException;
import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {

  public Hashtable(int capacity) {
    super(checkedCapacity(capacity));
  }

  private static int checkedCapacity(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException();
    }
    return capacity;
  }

  private int hash(K key) {
    return Math.floorMod(key.hashCode(), hashtable.length);
  }

  private int probeIndex(K key, int attempt) {
    return Math.floorMod(hash(key) + attempt * attempt, hashtable.length);
  }

  // Gibt den Wert der sich unter dem angegebenen Schlüssel o in der Hashtabelle befindet zurück.
  // Gibt null zurück, falls kein Wert mit diesem Schlüssel existiert.
  @SuppressWarnings("unchecked")
  @Override
  public V get(Object o) {
    if (o == null) {
      throw new NullPointerException();
    }

    K key = (K) o;

    for (int attempt = 0; attempt < hashtable.length; attempt++) {
      Entry<K, V> entry = hashtable[probeIndex(key, attempt)];

      if (entry == null) {
        return null;
      }
      if (entry.getKey().equals(key)) {
        return entry.getValue();
      }
    }

    return null;
  }

  // Fügt den Wert value in einen leeren Behälter in der Hashtabelle ein. Falls schon ein Wert mit dem angegebenen
  // Schlüssel key in der Tabelle vorhanden ist, wird in dessen Behälter der Wert mit value überschrieben und
  // der alte Wert zurückgegeben.
  @Override
  public V put(K key, V value) {
    if (key == null) {
      throw new NullPointerException();
    }

    for (int attempt = 0; attempt < hashtable.length; attempt++) {
      int index = probeIndex(key, attempt);
      Entry<K, V> entry = hashtable[index];

      if (entry == null) {
        hashtable[index] = new AbstractMap.SimpleEntry<>(key, value);
        size++;
        return null;
      }
      if (entry.getKey().equals(key)) {
        V oldValue = entry.getValue();
        entry.setValue(value);
        return oldValue;
      }
    }

    // kein Platz mehr
    throw new DictionaryFullException();
  }

  @Override
  public Iterator<Entry<K, V>> iterator() {
    return new Iterator<Entry<K, V>>() {
      private int current = 0;

      private void moveToNextNonEmptySlot() {
        while (current < hashtable.length && hashtable[current] == null) {
          current++;
        }
      }

      {
        moveToNextNonEmptySlot();
      }

      @Override
      public boolean hasNext() {
        return current < hashtable.length;
      }

      @Override
      public Entry<K, V> next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }

        Entry<K, V> entry = hashtable[current];
        current++;
        moveToNextNonEmptySlot();
        return entry;
      }
    };
  }

  @Override
  public V remove(Object key) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void clear() {
    throw new UnsupportedOperationException();
  }
}
