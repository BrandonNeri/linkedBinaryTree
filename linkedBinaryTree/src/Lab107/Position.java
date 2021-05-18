package Lab107;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 7.7
 *
 * An implementation of a simple Position Interface.
 *
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public interface Position<E> {

    /**
     *
     * @return the element stored at this position.
     * @throws IllegalStateException
     */
    E getElement() throws IllegalStateException;
}
