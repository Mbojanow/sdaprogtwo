package pl.sdacademy.prog.paczka;

import java.util.List;
import java.util.ServiceLoader;

public class AutoServiceDemo {
  public static void main(String[] args) {
    ServiceLoader.load(PickEventAggregationService.class)
        .findFirst()
        .ifPresent(x -> x.aggregate(List.of()));
  }
}
