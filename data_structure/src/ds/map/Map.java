package ds.map;

import java.util.Iterator;

public interface Map<K extends Comparable, V> {
    V put(K key, V value);
    V get(K key);
    V remove(K key);
    Iterator<K> keys();
    Iterator<V> values();
    Iterator<Entry<K,V>> entries();
    boolean isEmpty();
    int size();
}
