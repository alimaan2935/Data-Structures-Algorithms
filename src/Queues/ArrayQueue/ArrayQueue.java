package Queues.ArrayQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


/**
 * Implementation of the Queue ADT using fixed-length array
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {

    //instance variables
    private T[] data; // generic array used for storage
    private int f = 0; // index of the front element
    private int sz = 0; // current number of elements

    //constructors
    public ArrayQueue(int capacity) { // consructs queue with given capacity
        data = (T[]) new Object[capacity];
    }

    //methods

    /**
     * @return the number of elements in the queue
     */
    public int size() {
        return sz;
    }

    /**
     * @return boolean checks if queue is empty
     */
    public boolean isEmpty () {
        return (sz == 0);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * Insert an element at the rear of the queue
     * @param t
     * @throws IllegalStateException
     */
    public void enqueue(T t) throws IllegalStateException {
        if (sz == data.length) throw new IllegalStateException("Queue is full");
        int avail = (f+sz) % data.length;
        data[avail] = t;
        sz++;
    }

    /**
     * @return the first element of the queue but not remove it
     */
    public T first() {
        if (isEmpty()) return null;
        return data[f];
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T answer = data[f];
        data[f] = null; // deference to help in garbage collection
        f = (f+1) % data.length;
        sz--;
        return answer;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }
}
