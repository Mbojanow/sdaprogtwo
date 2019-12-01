package pl.sdacademy.prog.zadg;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

public class PriorityQueue<T, P extends Comparable<P>> extends AbstractQueue<T> {

  private LinkedList<PriorityElement<T, P>> elements;
  private P defaultPriority;

  public PriorityQueue(final P defaultPriority) {
    this.defaultPriority = defaultPriority;
    elements = new LinkedList<>();
  }

  @Override
  public Iterator<T> iterator() {
    return elements.stream()
        .map(PriorityElement::getElement)
        .iterator();
  }

  @Override
  public int size() {
    return elements.size();
  }

  @Override
  public boolean offer(final T t) {
    addElement(t, defaultPriority);
    return true;
  }

  public boolean offer(final T t, final P priority) {
    addElement(t, priority);
    return true;
  }

  private void addElement(final T element, final P priority) {
    if (elements.isEmpty()) {
      elements.addFirst(new PriorityElement<>(element, priority));
      return;
    }

    final int originalSize = elements.size();
    for (int idx = 0; idx < originalSize; idx++) {
      if (elements.get(idx).getPriority().compareTo(priority) > 0) {
        elements.add(idx, new PriorityElement<>(element, priority));
        break;
      }
    }

    final int afterLoopSize = elements.size();
    if (afterLoopSize == originalSize) {
      elements.addLast(new PriorityElement<>(element, priority));
    }
  }

  @Override
  public T poll() {
    return Optional.ofNullable(elements.poll()).map(PriorityElement::getElement)
        .orElse(null);
  }

  @Override
  public T peek() {
    return Optional.ofNullable(elements.peek()).map(PriorityElement::getElement)
        .orElse(null);
  }
}
