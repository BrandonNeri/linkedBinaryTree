package Lab107;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragments 8.2 to 8.5
 *
 * Note: Code Fragment 8.4 was replaced with 8.5 as it preforms better.
 *
 * An abstract base class providing some of the basic functionality 
 * of the Tree interface.
 *
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public abstract class AbstractTree<E> implements Tree<E> {

    /**
     *
     * @param p position in a tree
     * @return true if position p has at least one child, false if not
     */
    @Override
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    /**
     *
     * @param p position in a tree
     * @return true if position p does not have any children, false if not
     */
    @Override
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    /**
     *
     * @param p position in a tree
     * @return true if the position is a root, false if not
     */
    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    /**
     * 
     * @return true if the tree is empty, false if not
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 
     * @param p position in a tree
     * @return the number of levels separating Position p from the root
     */
    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    /**
     * 
     * @param p position in a tree
     * @return the height of the subtree rooted at Position p
     */
    public int height(Position<E> p) {
        int h = 0; // base case if p is external
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }
}
