package pl.sdacademy.prog.queue;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue<V, P extends Comparable<P>> extends AbstractQueue<V> {
  private LinkedList<PriorityElement<V, P>> elements = new LinkedList<>();
  private final P defaultPriority;

  public PriorityQueue(final P defaultPriority) {
    this.defaultPriority = defaultPriority;
  }

  @Override
  public Iterator<V> iterator() {
    return elements.stream()
        //w streamie ElementyPriority<V, P>; // ITERATOR() dostępny na streamie
        .map(PriorityElement::getValue).iterator();
        //.collect(Collectors.toList()).iterator();
  }

  @Override
  public int size() {
    return elements.size();
  }

  @Override
  public boolean offer(final V v) {
    return offer(v, defaultPriority);
  }

  public boolean offer(final V v, final P priority) {
    if (elements.isEmpty()) {
      elements.add(new PriorityElement<>(v, priority));
      return true;
    }

    final int beforeSize = elements.size();
    for (int idx = 0; idx < elements.size(); idx++) {
      if (priority.compareTo(elements.get(idx).getPriority()) > 0) {
        elements.add(idx, new PriorityElement<>(v, priority));
        return true;
      }
    }

    //if (beforeSize == elements.size()) {
    elements.addLast(new PriorityElement<>(v, priority));
    //}
    return true;
  }

  @Override
  public V poll() {
    return elements.poll().getValue();
  }

  @Override
  public V peek() {
    return elements.peek().getValue();
  }
}
