package pl.sdacademy.prog.jsondemo;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMain {
  public static void main(String[] args) throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();

//    • Stwórz obiekt javowy zawierający pojedyczne pole typu String. Wyświetl obiekt jako String w formacie JSON
    final ObjectA objectA = new ObjectA("andrzej");
    final String strA = objectMapper.writeValueAsString(objectA);
    System.out.println(strA);
    final ObjectA objectA1 = objectMapper.readValue(strA, ObjectA.class);

//• Stwórz obiekt javowy zawierający pole typu int i Integer. Wyświelt obiekt jako String w formacie JSON. Raz wypełnij oba pola, raz jedno niech będzie nullem. Jaka jest różnica w formatowaniu int vs Integer?
    final ObjectB objectB1 = new ObjectB(2, 3);
    final ObjectB objectB2 = new ObjectB(3, null);
    System.out.println(objectMapper.writeValueAsString(objectB1));
    System.out.println(objectMapper.writeValueAsString(objectB2));

//• Stwórz obiekt javowy zawierający pole typu Double, pole typu double i listę obiektów typu String. Wyświetl obiekt jako String w formacie JSON.
    final ObjectC objectC = new ObjectC(2D, 2.3, List.of("stra", "strb", "strc"));
    final String strC = objectMapper.writeValueAsString(objectC);
    System.out.println(strC);
    final ObjectC objectC1 = objectMapper.readValue(strC, ObjectC.class);

//• Stwórz obiekt javowy zawierający pole typu Float i array intów. Wyświetl obiekt jako String.
    final ObjectD objectD = new ObjectD(2.3F);
    System.out.println(objectMapper.writeValueAsString(objectD));

//• Stwórz obiekt javowy zawierający pole typu String i pole typu Map<String, String>. Wyświetl
//obiekt jako String
    final ObjectE objectE = new ObjectE("someValue",
        Map.of("key1", "value1", "key2", "value2"));
    System.out.println(objectMapper.writeValueAsString(objectE));

//• Stwórz obiekt javowy zawierający pole Set, LinkedList i wyświetl obiekt jako String w formacie JSON
//• Stwórz obiekt javowy mający kilka pól i oprócz tego kilka innych innych obiektów javowych i ... takjako String w formacie JSON
    final ObjectF objectF = ObjectF.builder()
        .fieldA("someA")
        .fieldB(2.3)
        .setValues(Set.of("sv1", "sv2"))
        .linkedList(new LinkedList<>(Arrays.asList("ll1", "ll2")))
        .objectA(objectA)
        .objectE(objectE)
        .build();
    final String strF = objectMapper.writeValueAsString(objectF);
    System.out.println(strF);
    final ObjectF objectF1 = objectMapper.readValue(strF, ObjectF.class);
    System.out.println();
  }
}
