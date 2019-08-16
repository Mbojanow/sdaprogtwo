package pl.sdacademy.prog.zadC;

public class MyNode<T> {
    private T value;
    private MyNode<T> next;

    public MyNode(final T value) {
        this.value = value;
    }

    public MyNode(final T value, final MyNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNext(final MyNode<T> next) {
        this.next = next;
    }
}
