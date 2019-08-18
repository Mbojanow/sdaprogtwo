package pl.sdacademy.prog.zadG;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MyPriorityQueue<T, V extends Comparable<V>> extends AbstractQueue<T> {
    private LinkedList<MyPriorityElement<T, V>> elements = new LinkedList<>();
    private final V defaultPriority;

    public MyPriorityQueue(final V defaultPriority) {
        this.defaultPriority = defaultPriority;
    }

    @Override
    public Iterator<T> iterator() {
        return elements.stream()
                .map(MyPriorityElement::getElement)
                .collect(Collectors.toList())
                .iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean offer(final T value) {
        final MyPriorityElement<T, V> element = new MyPriorityElement<>(value, defaultPriority);
        addElement(element);
        return true;
    }

    public boolean enqueue(final T value, final V priority) {
        final MyPriorityElement<T, V> element = new MyPriorityElement<>(value, priority);
        addElement(element);
        return true;
    }

    private void addElement(final MyPriorityElement<T, V> element) {
        if (elements.isEmpty()) {
            elements.addFirst(element);
            return;
        }

        final int initialSize = elements.size();
        for (int idx = 0; idx < elements.size(); idx++) {
            if (elements.get(idx).getPriority().compareTo(element.getPriority()) < 0) {
                elements.add(idx, element);
                break;
            }
        }

        final int newSize = elements.size();
        if (initialSize == newSize) {
            elements.addLast(element);
        }
    }

    @Override
    public T poll() {
        final T value = peek();
        elements.removeFirst();
        return value;
    }

    @Override
    public T peek() {
        return elements.getFirst().getElement();
    }
}
