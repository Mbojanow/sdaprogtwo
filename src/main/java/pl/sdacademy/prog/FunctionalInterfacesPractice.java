package pl.sdacademy.prog;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesPractice {

  public Predicate<Person> getIsAdultPredicate() {
    return (person) -> person.getAge() >= 18;
  }

  public Predicate<Person> getIsPolishAdultFemalePredicate() {
    return (person) -> person.getAge() >= 18 && person.getFirstName().equals("a");
  }

  public Function<Person, String> getPersonToStringFunction() {
    return (person) -> person.getFirstName() + " " + person.getLastName() + " is " + person.getAge() + " years old";
  }

  public Consumer<Person> getPersonPrintingConsumer() {
    return (person) -> System.out.println(person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName());
  }
}
