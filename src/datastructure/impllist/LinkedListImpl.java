package datastructure.impllist;

import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of links with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class LinkedListImpl<E> implements LinkedList<E> {
    private Link<E> first;
//    private ListIterator<E> listIterator;

    /**
     * Constructs an empty linked list.
     */
    public LinkedListImpl() {
        first = null;
//        listIterator = null;
    }

    /**
     * Returns the first element in the linked list.
     *
     * @return the first element in the linked list
     */
    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    /**
     * Removes the first element in the linked list.
     *
     * @return the removed element
     */
    public E removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Link<E> oldValue = first;
        first = first.next;
        return oldValue.data;
    }

    /**
     * Adds an element to the front of the linked list.
     *
     * @param obj the object to add
     */
    public void addFirst(E obj) {
        first = new Link<>(obj, first);
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
        E data;
        Link<E> next;

        public Link(E data, Link<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class LinkedListIterator implements ListIterator<E> {
        private Link<E> position;
        private Link<E> previous;

        /**
         * Constructs an iterator that points to the front
         * of the linked list.
         */
        public LinkedListIterator() {
            position = null;
            previous = null;
        }

        /**
         * Moves the iterator past the next element.
         *
         * @return the traversed element
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if(position == null) {
                position = first;
                return position.data;

            } else {
                previous = position;
                position = position.next;
                return position.data;
            }
        }

        /**
         * Tests if there is an element after the iterator
         * position.
         *
         * @return true if there is an element after the iterator
         * position
         */
        public boolean hasNext() {
            if (position == null){
                return first != null;
            }else {
                return position.next != null;
            }
        }

        /**
         * Adds an element before the iterator position
         * and moves the iterator past the inserted element.
         *
         * @param obj the object to add
         */
        public void add(E obj) {
            if (position == null) {
                addFirst(obj);
                position = first;

            } else {
                previous = position;
                position = new Link<>(obj, position.next);
                previous.next = position;
            }
        }

        /**
         * Removes the last traversed element. This method may
         * only be called after a call to the next() method.
         */
        public void remove() {
            if (previous == position){
                throw new IllegalStateException();
            }
            if (first == position){
                removeFirst();
                position = null;
            } else {
                previous.next = position.next;
                position = previous;
                previous = position;
            }
        }

        /**
         * Sets the last traversed element to a different
         * value.
         *
         * @param obj the object to set
         */
        public void set(E obj) {
            if(position == null){
                throw new NoSuchElementException();
            }
            position.data = obj;
        }
    }
}
