package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

import java.util.AbstractMap;


public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {

    private ListElement findElement(K key) {
        ListElement current = head;

        while (current != null) {
            if (current.entry.getKey().equals(key)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    // Gibt den Wert zurück, der unter dem angegebenen Schlüssel o in der Liste ist.
    @SuppressWarnings("unchecked")
    @Override
    public V get(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        K key = (K) o;

        ListElement element = findElement(key);

        // kein Wert mit Schlüssel existiert
        if (element == null) {
            return null;
        }

        return element.entry.getValue();
    }

    //  Fügt den Wert am Anfang der doppelt verketteten Liste ein und gibt null zurück
    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }

        ListElement element = findElement(key);

        // Schlüssel existiert
        // Wert überschreiben und alten Wert zurückgeben
        if (element != null) {
            V oldValue = element.entry.getValue();
            element.entry.setValue(value);
            return oldValue;
        }

        // Schlüssel existiert nicht
        // Neues Element einfügen
        Entry<K, V> entry = new AbstractMap.SimpleEntry<>(key, value);

        ListElement newElement = new ListElement(entry, null, head);

        if (head != null) {
            head.previous = newElement;
        }

        head = newElement;
        size++;

        return null;
    }
}
