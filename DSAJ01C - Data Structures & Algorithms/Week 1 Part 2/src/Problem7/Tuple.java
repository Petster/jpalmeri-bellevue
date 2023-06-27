package Problem7;

public class Tuple<K, V extends K> {
    private final K k;

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    private final V v;

    public Tuple(K key, V value) {
        this.k = key;
        this.v = value;
    }

    public String toString() {
        return String.format("KEY: '%s', VALUE: '%s'", k, v);
    }
}
