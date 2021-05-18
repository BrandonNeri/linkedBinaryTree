package Lab107;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 8.6
 * 
 * An implementation of an interface for a binary tree, in which 
 * each node has at most two children.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public interface BinaryTree<E> extends Tree<E> {
    /** 
     * 
     * @param p position in a tree
     * @return the Position of p's left child (or null if no child exists)
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /** 
     * 
     * @param p position in a tree
     * @return the Position of p's right child (or null if no child exists)
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /** 
     * 
     * @param p position in a tree
     * @return the Position of p's sibling (or null if no sibling exists)
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
