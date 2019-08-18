package pl.sdacademy.prog.zadG;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

public class MyQueue<T> extends AbstractQueue<T> {

    private LinkedList<T> elements = new LinkedList<>();

    @Override
    public boolean offer(final T t) {
        elements.addLast(t);
        return true;
    }

    @Override
    public T poll() {
        final T element = peek();
        elements.removeFirst();
        return element;
    }

    @Override
    public T peek() {
        return elements.getFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }
}
