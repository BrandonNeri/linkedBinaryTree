package Lab107;

import java.util.Iterator;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 8.1
 * 
 * An implementation of an interface for a tree where nodes can have 
 * an arbitrary number of children.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public interface Tree<E> extends Iterable<E> {

    /**
     * 
     * @return the position of the root of the tree (or null if empty)
     */
    Position<E> root();

    /**
     * 
     * @param p position in a tree
     * @return Returns the position of the parent of position p (or null if p is the root).
     * @throws IllegalArgumentException
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p position in a tree
     * @return an iterable collection containing the children of position p (if any)
     * @throws IllegalArgumentException 
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p position in a tree
     * @return the number of children of position p
     * @throws IllegalArgumentException
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p position in a tree
     * @return true if position p has at least one child
     * @throws IllegalArgumentException
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p position in a tree
     * @return true if position p does not have any children
     * @throws IllegalArgumentException
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @param p position in a tree
     * @return true if position p is the root of the tree
     * @throws IllegalArgumentException
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     * 
     * @return the number of positions (and hence elements) that are contained in the tree
     */
    int size();

    /**
     * 
     * @return true if the tree does not contain any positions (and thus no elements)
     */
    boolean isEmpty();

    /**
     * 
     * @return an iterator for all elements in the tree (so that the tree itself is Iterable)
     */
    @Override
    Iterator<E> iterator();

    /**
     * 
     * @return an iterable collection of all positions of the tree
     */
    Iterable<Position<E>> positions();
}
