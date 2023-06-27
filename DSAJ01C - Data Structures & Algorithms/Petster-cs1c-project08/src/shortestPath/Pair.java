package shortestPath;

/**
 * A generic class representing a pair of elements.
 *
 * @param <E> the type of the first element
 * @param <F> the type of the second element
 */
public class Pair<E, F>
{
    public E first;
    public F second;

    /**
     * Constructs a new Pair object with the given elements.
     *
     * @param x the first element of the pair
     * @param y the second element of the pair
     */
    public Pair(E x, F y) {
        first = x;
        second = y;
    }

    /**
     * Checks if this Pair is equal to the specified object.
     *
     * @param rhs the object to compare for equality
     * @return true if the specified object is equal to this Pair, false otherwise
     */
    public boolean equals(Object rhs) {
        Pair<E, F> other;
        other = (Pair<E, F>)rhs;
        return first.equals(other.first);
    }

    /**
     * Returns the hash code value for this Pair.
     *
     * @return the hash code value for this Pair
     */
    public int hashCode() {
        return first.hashCode();
    }
}