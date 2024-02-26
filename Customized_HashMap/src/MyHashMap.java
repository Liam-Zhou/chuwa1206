public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }

        int index = getIndex(key);
        Node<K, V> node = buckets[index]; // get the first node in the bucket

        while (node != null) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
            node = node.getNext();
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.setNext(buckets[index]);
        buckets[index] = newNode;
        size++;

        if ( (double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int index = getIndex(key);
        Node<K, V> node = buckets[index];

        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }

        int index = getIndex(key);
        Node<K, V> node = buckets[index];
        Node<K, V> prev = null; // u need to keep track of the previous node

        while (node != null) {
            if (node.getKey().equals(key)) {
                if (prev == null) {
                    buckets[index] = node.getNext();
                } else {
                    prev.setNext(node.getNext());
                }
                size--;
                return;
            }
            prev = node;
            node = node.getNext();
        }
    }

    public int getIndex(K key) {
        return key.hashCode() % buckets.length;
    }

    private void resize() {
        Node<K, V>[] temp = buckets;
        buckets = new Node[buckets.length * 2];
        size = 0; //reset the size, otherwise it will be doubled

        for (Node<K, V> node : temp) {
            while (node != null) {
                put(node.getKey(), node.getValue());
                node = node.getNext();
            }
        }
    }
}
