package pl.sdacademy.prog.zadC;

import static java.util.Objects.*;

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

    public void addHead(final T element) {
        final MyNode<T> newHead = new MyNode<>(element);
        newHead.setNext(this.head);
        this.head = newHead;
    }

    public void remove(final int index) {
        MyNode<T> current = head;
        MyNode<T> prev = null;

        for (int idx = 0; idx < index; idx++) {
            if (isNull(current.getNext())) {
                throw new IndexOutOfBoundsException();
            }
            prev = current;
            current = current.getNext();
        }

        prev.setNext(current.getNext());
    }

    public void add(final int index, final T element) {
        MyNode<T> tmp = head;
        for (int idx = 0; idx < index - 1; idx++) {
            if (isNull(tmp.getNext())) {
                throw new IndexOutOfBoundsException();
            }
            tmp = tmp.getNext();
        }

        final MyNode<T> newNode = new MyNode<>(element);
        newNode.setNext(tmp.getNext());
        tmp.setNext(newNode);
    }
}
