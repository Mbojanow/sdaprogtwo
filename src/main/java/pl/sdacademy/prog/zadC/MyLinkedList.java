package pl.sdacademy.prog.zadC;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class MyLinkedList<T> {

    private MyNode<T> head;

    public MyLinkedList(final T head) {
        this.head = new MyNode<>(head);
    }

    public MyNode<T> getHead() {
        return head;
    }

    public void add(final T element) {
        final MyNode<T> newNode = new MyNode<>(element);

        MyNode<T> tmp = this.head;
        while (nonNull(tmp.getNext())) {
            tmp = tmp.getNext();
        }

        tmp.setNext(newNode);
    }

    public T get(final int index) {
        MyNode<T> tmp = this.head;
        for (int idx = 0; idx < index; idx++) {
            tmp = tmp.getNext();
            if (isNull(tmp)) {
                throw new IndexOutOfBoundsException("Element with given index does not exist");
            }
        }
        return tmp.getValue();
    }
}
