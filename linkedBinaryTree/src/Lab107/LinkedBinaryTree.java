package Lab107;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragments 8.8 to 8.11
 * 
 * Code includes multiple methods added to create preOrder, postOrder, 
 * inOrder, and breathFirst Tree Traversals.
 *
 * A concrete implementation of a binary tree using a node-based,
 * linked structure.
 *
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    
    //---------------- Nested Node Class ----------------
    protected static class Node<E> implements Position<E> {

        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child (if any)
        private Node<E> right; // a reference to the right child (if any)

        /**
         * 
         * Constructs a node with the given element and neighbors.
         * @param e
         * @param above
         * @param leftChild
         * @param rightChild
         */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        /**
         * 
         * @return the element at a given node
         */
        @Override
        public E getElement() {
            return element;
        }

        /**
         * 
         * @return the parent node in a tree
         */
        public Node<E> getParent() {
            return parent;
        }

        /**
         * 
         * @return the left child node in a tree
         */
        public Node<E> getLeft() {
            return left;
        }

        /**
         * 
         * @return the right child node in a tree
         */
        public Node<E> getRight() {
            return right;
        }

        /**
         * 
         * Sets an element at a given position/node.
         * 
         * @param e a given element to set
         */
        public void setElement(E e) {
            element = e;
        }

        /**
         * 
         * Sets the parent node to a new node
         * 
         * @param parentNode a given parent node
         */
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        /**
         * 
         * Sets the left child to a different node
         * 
         * @param leftChild a given left node
         */
        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        /**
         * 
         * Sets the right child to a different node
         * 
         * @param rightChild a given right node
         */
        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
    } //----------- End of Nested Node Class -----------

    /**
     * 
     * Factory function to create a new node storing element e.
     * 
     * @param e
     * @param parent
     * @param left
     * @param right
     * @return a newly created node
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    // LinkedBinaryTree Instance Variables
    protected Node<E> root = null; // root of the tree
    private int size = 0; // number of nodes in the tree

    /**
     * 
     * Default Constructor for the LinkedBinaryTree Class.
     */
    public LinkedBinaryTree() {
        // constructs an empty binary tree
    }          

    /**
     * 
     * Validates the position and returns it as a node.
     * 
     * Nonpublic Utility
     * 
     * @param p position in a tree
     * @return a valid node to be used in a given tree
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) { // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    /**
     * 
     * Accessor method (not already implemented in AbstractBinaryTree)
     * 
     * @return the number of nodes in the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 
     * Accessor method (not already implemented in AbstractBinaryTree)
     * 
     * @return the root Position of the tree (or null if tree is empty).
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * 
     * Accessor method (not already implemented in AbstractBinaryTree)
     * 
     * @param p position in a tree
     * @return the Position of p's parent (or null if p is root).
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * 
     * Accessor method (not already implemented in AbstractBinaryTree)
     * 
     * @param p position in a tree
     * @return the Position of p's left child (or null if no child exists).
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * 
     * Accessor method (not already implemented in AbstractBinaryTree)
     * 
     * @param p position in a tree
     * @return  the Position of p's right child (or null if no child exists).
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    /**
     * 
     * Update method supported by this class
     * 
     * Places element e at the root of an empty tree and returns its new Position.
     * 
     * @param e a given element
     * @return the new position of an element placed in the tree
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * 
     * Update method supported by this class
     * 
     * Creates a new left child of Position p storing element e; returns its Position.
     * 
     * @param p a given position
     * @param e a given element
     * @return the new position of an element placed in the tree
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("p already has a left child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * 
     * Update method supported by this class
     * 
     * Creates a new right child of Position p storing element e; returns its Position.
     * 
     * @param p a given position
     * @param e a given element
     * @return the new position of an element placed in the tree
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * 
     * Update method supported by this class
     * 
     * Replaces the element at Position p with e and returns the replaced element.
     * 
     * @param p a given position
     * @param e a given element
     * @return the replaced element
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * 
     * Update method supported by this class
     * 
     * Attaches trees t1 and t2 as left and right subtrees of external p.
     * 
     * @param p a given position
     * @param t1 a given linkedBinaryTree
     * @param t2 another given linkedBinaryTree
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf");
        }
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) { // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) { // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * 
     * Update method supported by this class
     * 
     * Removes the node at Position p and replaces it with its child, if any.
     * 
     * @param p position in a tree 
     * @return the element removed
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null) {
            child.setParent(node.getParent());  // child's grandparent becomes its parent
        }
        if (node == root) {
            root = child; // child becomes root
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null); // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
        return temp;
    }
    
    /**
     * 
     * Added recursive method, not originally part of the LinkedBinaryTree 
     * Class, that will create a preOrderTree at a given position.
     * 
     * @param p position in a tree
     * @param list position in a list
     */
    private void preOrderTree(Position<E> p, List<Position<E>> list) {
        list.add(p);
        for (Position<E> child : children(p)) {
            preOrderTree(child, list);
        }
    }

    /**
     * 
     * Added recursive method, not originally part of the LinkedBinaryTree 
     * Class, that will return a preOrder of a specified tree when the 
     * method is called upon.
     * 
     * @return a group of positions and elements formatted in preorder
     */
    public Iterable<Position<E>> createPreOrder() {
        List<Position<E>> p = new ArrayList<>();
        if (!isEmpty()) { preOrderTree(root(), p); }
        return (Iterable<Position<E>>) p;
    }
    
    /**
     * 
     * Added recursive method, not originally part of the LinkedBinaryTree 
     * Class, that will create a postOrderTree at a given position.
     * 
     * @param p position in a tree
     * @param snapshot position in a list
     */
    private void postOrderTree(Position<E> p, List<Position<E>> list) {
        for (Position<E> child : children(p)) {
            postOrderTree(child, list);
        }
        list.add(p);
    }

    /**
     * 
     * Added recursive method, not originally part of the LinkedBinaryTree 
     * Class, that will return a postOrder of a specified tree when the 
     * method is called upon.
     * 
     * @return a group of positions and elements formatted in postOrder
     */
    public Iterable<Position<E>> createPostOrder() {
        List<Position<E>> p = new ArrayList<>();
        if (!isEmpty()) { postOrderTree(root(), p); }
        return (Iterable<Position<E>>) p;
    }

    /**
     * 
     * Added recursive method, not originally part of the LinkedBinaryTree 
     * Class, that will create a inOrderTree at a given position.
     * 
     * @param p position in a tree
     * @param list position in a list
     */
    private void inOrderTree(Position<E> p, List<Position<E>> list) {
        if (left(p) != null) { inOrderTree(left(p), list); }
        list.add(p);
        if (right(p) != null) { inOrderTree(right(p), list); }
    }

    /**
     * 
     * Added recursive method, not originally part of the LinkedBinaryTree 
     * Class, that will return an inOrder of a specified tree when the 
     * method is called upon.
     * 
     * @return a group of positions and elements formatted inOrder
     */
    public Iterable<Position<E>> createInOrder() {
        List<Position<E>> p = new ArrayList<>();
        if (!isEmpty()) { inOrderTree(root(), p); }
        return p;
    }
    
    /**
     * 
     * Added recursive method, not originally part of the LinkedBinaryTree 
     * Class, that will return a breadth-first order of a specified tree 
     * when the method is called upon.
     * 
     * @return an iterable colection of positions for the tree in breadth-first order
     */
    public Iterable<Position<E>> createBreadthFirst() {
        List<Position<E>> breadthFirst = new ArrayList<>();
        if (!isEmpty()) {
            LinkedQueue<Position<E>> list = new LinkedQueue<>();
            list.enqueue(root());
            while (!(list.isEmpty())) {
                Position<E> p = list.dequeue();
                breadthFirst.add(p);
                for (Position<E> child : children(p)) {
                    list.enqueue(child);
                }
            }
        }
        return breadthFirst;
    }

    /**
     * 
     * Unused method.
     * 
     * @return an inorder iterable group of positions in tree
     */
    @Override
    public Iterable<Position<E>> positions() {
        return createInOrder();
    }
    
    /**
     * 
     * Unused method.
     * 
     * @return a new iterator for the LinkedBinaryTree
     */
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
} //----------- End of LinkedBinaryTree Class -----------
