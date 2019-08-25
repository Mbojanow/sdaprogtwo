package pl.sdacademy.prog.genA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FruitBox<T extends Fruit> {

  private List<T> fruits = new ArrayList<>();

  public FruitBox() {
  }

  public void addFruit(final T fruit) {
    fruits.add(fruit);
  }

  public void removeRotten() {
    final int fruitsNumBeforeRemoving = fruits.size();
    fruits = fruits.stream()
        .filter(fruit -> !fruit.isRotten())
        .collect(Collectors.toList());
    final int fruitsRemoved = fruitsNumBeforeRemoving - fruits.size();
    log.info("Number of fruits removed " + fruitsRemoved);
  }
}
