package pl.sdacademy.prog.zadG;

public class MyPriorityElement<T, V extends Comparable<V>> {

    private T element;
    private V priority;

    public MyPriorityElement(final T element, final V priority) {
        this.element = element;
        this.priority = priority;
    }

    public T getElement() {
        return element;
    }

    public V getPriority() {
        return priority;
    }
}
