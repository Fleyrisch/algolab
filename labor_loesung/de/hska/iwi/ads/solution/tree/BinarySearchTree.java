package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {

  @Override
  @SuppressWarnings("unchecked")
  public V get(Object o) {
    K key = (K) o;
    if (key == null) {
      throw new NullPointerException();
    }

    Node current = root;

    while (current != null) {
      int comparison = key.compareTo(current.entry.getKey());
      if (comparison == 0) {
        return current.entry.getValue();
      }
      current = comparison < 0 ? current.left : current.right;
    }
    // Key nicht gefunden
    return null;
  }

  @Override
  public V put(K key, V value) {
    if (key == null) {
      throw new NullPointerException();
    }
    // Leerer Baum
    if (root == null) {
      root = new Node(key, value);
      size++;
      return null;
    }

    Node current = root;
    while (true) {
      int comparison = key.compareTo(current.entry.getKey());
      // Key existiert schon, überschreiben und alten Wert zurückgeben
      if (comparison == 0) {
        V oldValue = current.entry.getValue();
        current.entry.setValue(value);
        return oldValue;
      }

      if (comparison < 0) {
        // Linker Teilbaum existiert noch nicht
        if (current.left == null) {
          current.left = new Node(key, value);
          size++;
          return null;
        }
        // Linker Teilbaum existiert
        current = current.left;
      } else {
        // Rechter Teilbaum existiert noch nicht
        if (current.right == null) {
          current.right = new Node(key, value);
          size++;
          return null;
        }
        // Rechter Teilbaum existiert
        current = current.right;
      }
    }
  }
}
