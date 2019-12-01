package pl.sdacademy.prog.zadg;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PriorityElement<T, P extends Comparable<P>> {
  private T element;
  private P priority;
}
