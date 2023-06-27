package lazyTrees;

/**
 * the Traverser interface represents an object that can be used to traverse
 * a data structure containing elements of type E
 *
 * @author Foothill College, Jason Palmeri
 */
public interface Traverser<E> {
    /**
     * performs a visit action on the provided node
     *
     * @param x the node to visit
     */
    public void visit(E x);
}