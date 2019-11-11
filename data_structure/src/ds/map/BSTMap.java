package ds.map;

import ds.bst.BinarySearchTree;

import java.util.Iterator;

public class BSTMap<K extends Comparable, V> implements Map<K,V> {
    private static class BSTEntry<K extends Comparable,V> implements Entry<K,V>, Comparable<Entry<K,V>> {
        K key;
        V value;

        public BSTEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public int compareTo(Entry<K, V> entry) {
            return key.compareTo(entry.getKey());
        }

        public String toString() {
            return "{"  + key + "->" + value + "}";
        }
    }

    protected BinarySearchTree<Entry<K,V>> tree;

    public BSTMap() {
        tree = new BinarySearchTree<Entry<K,V>>();
    }

    @Override
    public V put(K key, V value) {
        return ((Entry<K,V>) tree.insert(new BSTEntry(key,value))).getValue();
    }

    @Override
    public V get(K key) {
        return ((Entry<K,V>) tree.find(new BSTEntry(key,null))).getValue();
    }

    @Override
    public V remove(K key) {
        return ((Entry<K,V>) tree.remove(new BSTEntry(key,null))).getValue();
    }

    @Override
    public Iterator<K> keys() {
        return new Iterator<K>() {
            Iterator<Entry<K,V>> iterator = entries();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public K next() {
                return iterator.next().getKey();
            }
        };
    }

    @Override
    public Iterator<V> values() {
        return new Iterator<V>() {
            Iterator<Entry<K,V>> iterator = entries();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public V next() {
                return iterator.next().getValue();
            }
        };
    }

    @Override
    public Iterator<Entry<K, V>> entries() {
        return tree.iterator();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public int size() {
        return tree.size();
    }

    public String toString() {
        return tree.toString();
    }
}
