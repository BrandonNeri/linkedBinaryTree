package Lab107;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 8.7
 * 
 * An abstract base class providing some of the basic functionality 
 * of the BinaryTree interface.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    /**
     * 
     * @param p position in a tree
     * @return the Position of p's sibling(or null if no sibling exists)
     */
    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null; //p must be root
        }
        if (p == left(parent)) { //p is a left child
            return right(parent); //(right child might be null)
        } else { //p is a right child
            return left(parent); //(left child might be null)
        }
    }

    /**
     * 
     * @param p position in a tree
     * @return the number of children of Position p
     */
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    /**
     * 
     * @param p position in a tree
     * @return an iterable collection of the Positions representing p's children
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2); //max capacity of 2
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return (Iterable<Position<E>>) snapshot;
    }
}
