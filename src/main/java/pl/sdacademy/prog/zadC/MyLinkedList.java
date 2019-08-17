package pl.sdacademy.prog.zadC;

import java.util.AbstractList;
import java.util.List;

import static java.util.Objects.*;

public class MyLinkedList<T> extends AbstractList<T> {

    private MyNode<T> head;

    public MyLinkedList(final T head) {
        this.head = new MyNode<>(head);
    }

    public MyNode<T> getHead() {
        return head;
    }

    @Override
    public int size() {
        MyNode<T> tmp = head;
        int size = 0;
        while (nonNull(tmp)) {
            tmp = tmp.getNext();
            size++;
        }

        return size;
    }

    public boolean add(final T element) {
        final MyNode<T> newNode = new MyNode<>(element);

        MyNode<T> tmp = this.head;
        while (nonNull(tmp.getNext())) {
            tmp = tmp.getNext();
        }

        tmp.setNext(newNode);
        return true;
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

    public T remove(final int index) {
        MyNode<T> current = head;
        MyNode<T> prev = null;

        for (int idx = 0; idx < index; idx++) {
            if (isNull(current.getNext())) {
                throw new IndexOutOfBoundsException();
            }
            prev = current;
            current = current.getNext();
        }

        final MyNode<T> removedElement = current;
        prev.setNext(current.getNext());
        return removedElement.getValue();
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
