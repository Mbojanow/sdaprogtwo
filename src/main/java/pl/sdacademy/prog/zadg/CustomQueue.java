package pl.sdacademy.prog.zadg;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CustomQueue<T> extends AbstractQueue<T> {

  private LinkedList<T> elements = new LinkedList<>();

  @Override
  public Iterator<T> iterator() {
    return elements.iterator();
  }

  @Override
  public int size() {
    return elements.size();
  }

  @Override
  public boolean offer(final T t) {
    return elements.add(t);
  }

  @Override
  public T poll() {
    return elements.removeFirst();
//    final T element = elements.getFirst();
//    elements.removeFirst();
//    return element;
  }

  @Override
  public T peek() {
    return elements.getFirst();
  }
}
