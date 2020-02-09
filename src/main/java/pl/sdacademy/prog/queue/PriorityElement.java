package pl.sdacademy.prog.queue;

// reprezentuje pojedynczy element generyczny w generycznej kolejce priorytetowej
public class PriorityElement<V, P extends Comparable<P>> {

  private V value;
  private P priority;

  public PriorityElement(final V value, final P priority) {
    this.value = value;
    this.priority = priority;
  }

  public V getValue() {
    return value;
  }

  public P getPriority() {
    return priority;
  }
}
