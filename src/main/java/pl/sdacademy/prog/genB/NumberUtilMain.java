package pl.sdacademy.prog.genB;

import java.util.Arrays;
import java.util.List;

public class NumberUtilMain {

  public static void main(String[] args) {
    final int a = 3;
    final double b = 3.5;
    final long c = 5;
    final List<Number> values = Arrays.asList(a, b, c);

    final Double medianGeneric = NumbersUtil.findMedianGeneric(values);
    System.out.println(medianGeneric);
  }
}
