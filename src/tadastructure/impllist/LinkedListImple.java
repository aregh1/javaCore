package tadastructure.impllist;

/**
 * A linked list is a sequence of links with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class LinkedListImple<E> implements LinkedList<E> {
    private Link<E> first;

    /**
     * Constructs an empty linked list.
     */
    public LinkedListImple() {

    }

    /**
     * Returns the first element in the linked list.
     *
     * @return the first element in the linked list
     */
    public E getFirst() {

        return null;
    }

    /**
     * Removes the first element in the linked list.
     *
     * @return the removed element
     */
    public E removeFirst() {

        return null;
    }

    /**
     * Adds an element to the front of the linked list.
     *
     * @param obj the object to add
     */
    public void addFirst(E obj) {
       if(first == null){

       }

    }

    /**
     * Returns an iterator for iterating through this list.
     *
     * @return an iterator for iterating through this list
     */
    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    private class Link<E> {
        public E data;
        public Link<E> next;
    }

    private ListIterator<E> listIterator ;

    private class LinkedListIterator implements ListIterator<E> {
        private Link<E> position = null;
        private Link<E> previous = null;

        /**
         * Constructs an iterator that points to the front
         * of the linked list.
         */
        public LinkedListIterator() {
        }

        /**
         * Moves the iterator past the next element.
         *
         * @return the traversed element
         */
        public E next() {

            return null;
        }

        /**
         * Tests if there is an element after the iterator
         * position.
         *
         * @return true if there is an element after the iterator
         *         position
         */
        public boolean hasNext() {

           return false;

        }

        /**
         * Adds an element before the iterator position
         * and moves the iterator past the inserted element.
         *
         * @param obj the object to add
         */
        public void add(E obj) {

        }

        /**
         * Removes the last traversed element. This method may
         * only be called after a call to the next() method.
         */
        public void remove() {

        }

        /**
         * Sets the last traversed element to a different
         * value.
         *
         * @param obj the object to set
         */
        public void set(E obj) {

        }
    }
}
