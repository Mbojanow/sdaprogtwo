package pl.sdacademy.prog.slack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo {
  public static void main(String[] args) {
    final List<Integer> x = new LinkedList<>();

    //x.getFirst();


    final AbstractDemo abstractDemo = new NotAbstractDemo();
    abstractDemo.appliesSomeLogic();
    abstractDemo.toImplement();
    //abstractDemo.hello();


  }
}
