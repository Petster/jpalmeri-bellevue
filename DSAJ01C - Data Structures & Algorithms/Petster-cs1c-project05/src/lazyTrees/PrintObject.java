package lazyTrees;

/**
 * An object of type PrintObject uses traversal methods to
 * print out objects of type E
 *
 * @author Foothill College, Jason Palmeri
 */
public class PrintObject<E> implements Traverser<E> {
    /**
     * prints out node data in a single line format based on the node given
     *
     * @param x the node to print out
     */
    public void visit(E x) {
        System.out.print( x + " ");
    }
};