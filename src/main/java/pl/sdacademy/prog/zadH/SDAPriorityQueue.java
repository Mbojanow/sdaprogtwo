package pl.sdacademy.prog.zadH;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SDAPriorityQueue<T, P extends Comparable<P>> extends AbstractQueue<T> {
  private LinkedList<SDAPriorityElement<T, P>> elements = new LinkedList<>();

  private P defaultPriority;

  public SDAPriorityQueue(final P defaultPriority) {
    this.defaultPriority = defaultPriority;
  }

  public boolean offer(final T element) {
    return offer(element, defaultPriority);
  }

  @Override
  public T poll() {
    return elements.removeFirst().getValue();
  }

  @Override
  public T peek() {
    return elements.getFirst().getValue();
  }

  public boolean offer(final T element, final P priority) {
    final P priorityToBeInserted = priority;
    final SDAPriorityElement<T, P> elementToInsert = new SDAPriorityElement<>(element, priorityToBeInserted);
    if (elements.isEmpty()) {
      elements.addFirst(elementToInsert);
      return true;
    }

    for (int idx = 0; idx < elements.size(); idx++) {
      final P actualElementPriority = elements.get(idx).getPriority();
      final int compareResult = priorityToBeInserted.compareTo(actualElementPriority);
      // -1 priorityToBeInserted < actualElementPriority
      // 0 == priorytety równe
      // 1 priorityToBeInserted > actualElementPriority
      if (compareResult == 1) {
        elements.add(idx, elementToInsert);
        return true;
      }
    }

    elements.addLast(elementToInsert);
    return true;
  }

  @Override
  public Iterator<T> iterator() {
    return elements.stream()
        .map(SDAPriorityElement::getValue)
        .collect(Collectors.toList()).iterator();
  }

  @Override
  public int size() {
    return elements.size();
  }
}
