package Lab107;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 6.9
 * 
 * An implementation of a simple Queue Interface. A collection of objects 
 * that are inserted and removed according to the first-in first-out principle.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public interface Queue<E> {

    /**
     * 
     * @return  the number of elements in the queue.
     */
    int size();

    /**
     * 
     * @return true if the queue is empty, false if not.
     */
    boolean isEmpty();

    /**
     * 
     * Inserts an element at the rear of the queue.
     * 
     * @param e
     */
    void enqueue(E e);

    /**
     * 
     * @return the first element of the queue, but does not remove it (null if empty).
     */
    E first();

    /**
     * 
     * @return first element of the queue and removes it (null if empty).
     */
    E dequeue();
}
