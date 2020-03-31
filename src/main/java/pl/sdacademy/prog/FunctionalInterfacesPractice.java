package pl.sdacademy.prog;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesPractice {

  // na podstawie obiektu Person -> Person będzie argumentem wejściowym()
  public Predicate<Person> getIsAdultPredicate() {
    return (person) -> isPersonAdult(person);
  }

  /* stwórz metodę getIsPolishAdultFemalePredicate,
     która będzie zwracała predykat,
     który na podstawie obiektu Person powie czy osoba jest dorosłą Polką*/

  public Predicate<Person> getIsPolishAdultFemalePredicate() {
    return (person) -> isPersonAdult(person) && person.getFirstName().endsWith("a");
  }

  private boolean isPersonAdult(final Person person) {
    return person.getAge() >= 18;
  }


  /* stwórz metodę getPersonToStringFunction, która będzie zwracała Function,
   która na podstawie obiektu Person, zwróci String mówiący ile osoba ma lat (np. Ala Nowak ma 5 lat)
   */
  public Function<Person, String> getPersonToStringFunction() {
    return (person) -> person.getFirstName() + " " + person.getLastName() + " ma " + person.getAge();
  }

  /*stwórz metodę getPersonPrintingConsumer, która będzie zwracała Consumer,
  który na podstawie obiektu Person, wypisze na ekran informacje o osobie w formacie
   pierwszeImie drugieImie nazwisko*/

  public Consumer<Person> getPersonPrintingConsumer() {
    return (person) -> System.out.println(person.getFirstName() + " "
        + person.getMiddleName() + " " + person.getLastName());
  }



}
