package pl.sdacademy.prog.zad;

//FlatMap i Reduce: Piszemy system dla firmy.
// Mamy następujące klasy: Firma, Oddział, Zespół, Pracownik.
// Firma posiada listę oddziałów, oddział posiada listę zespołów
// a każdy zespół listę pracowników. W Main utwórzcie firmę,
// która ma conajmniej 2 oddziały, z czego każdy ma 2 zespoły
//z niepustą liczbą pracowników. Do pliku zapiszcie:
//1 : Nazwę i liczebość każdego z oddziałów.
//2 : Listę imion i nazwisk pracowników posortowaną alfabetycznie
//3 : Za pomocą reduce utworzyć zespół stworzony z wszystkich pracowników firmy

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFirma {
  public static void main(String[] args) {
    Pracownik pracownik1 = new Pracownik("Adam", "Nowak");
    Pracownik pracownik2 = new Pracownik("Bogdan", "Zalewski");
    Pracownik pracownik3 = new Pracownik("Bartosz", "Wiśniewski");
    Pracownik pracownik4 = new Pracownik("Cyprian", "Kowalski");
    Pracownik pracownik5 = new Pracownik("Daniel", "Mądry");
    Pracownik pracownik6 = new Pracownik("Piotr", "Brodzki");
    Pracownik pracownik7 = new Pracownik("Paweł", "Kmicic");
    Pracownik pracownik8 = new Pracownik("Zdzisław", "Schmitt");

    List<Pracownik> pracownicyZespolu1 = List.of(pracownik1);
    Zespol zespol1 = new Zespol("Zespół nr.1", pracownicyZespolu1);
    List<Pracownik> pracownicyZespolu2 = List.of(pracownik2, pracownik3);
    Zespol zespol2 = new Zespol("Zespół nr.2", pracownicyZespolu2);
    List<Pracownik> pracownicyZespolu3 = List.of(pracownik4, pracownik5, pracownik6);
    Zespol zespol3 = new Zespol("Zespół nr.3", pracownicyZespolu3);
    List<Pracownik> pracownicyZespolu4 = List.of(pracownik7, pracownik8);
    Zespol zespol4 = new Zespol("Zespół nr.4", pracownicyZespolu4);

    List<Zespol> zespolyOddzialu1 = List.of(zespol1, zespol2, zespol3);
    Oddzial oddzial1 = new Oddzial("Warszawa", zespolyOddzialu1);
    List<Zespol> zespolyOddzialu2 = List.of(zespol4);
    Oddzial oddzial2 = new Oddzial("Londyn", zespolyOddzialu2);

    List<Oddzial> oddzialyFirmy = List.of(oddzial1, oddzial2);
    Firma firma = new Firma("PHU", oddzialyFirmy);

    //1 : Nazwę i liczebość każdego z oddziałów.
    oddzialyFirmy.stream()
        .map(o -> o.toString())
        .forEach(o -> System.out.println(o));

    long count = zespolyOddzialu1.stream()
        .count();
    System.out.println("Liczebność: " + count);
    long count1 = zespolyOddzialu2.stream()
        .count();
    System.out.println("Liczebność: " + count1);

    // liczbnosc
    firma.getListaOddzialow().stream()
        .flatMap(oddzial -> oddzial.getListaZespolow().stream())
        .flatMap(zespol -> zespol.getListaPracownikow().stream())
        .count();


    //2 : Listę imion i nazwisk pracowników posortowaną alfabetycznie

    firma.getListaOddzialow().stream()
        .flatMap(oddzial -> oddzial.getListaZespolow().stream())
        .flatMap(zespol -> zespol.getListaPracownikow().stream())
        .sorted(Comparator.comparing(Pracownik::getNazwisko))
        .collect(Collectors.toList());

    //3 : Za pomocą reduce utworzyć zespół stworzony z wszystkich pracowników firmy
    final List<Pracownik> pracownicy = firma.getListaOddzialow().stream()
        .flatMap(oddzial -> oddzial.getListaZespolow().stream())
        .flatMap(zespol -> zespol.getListaPracownikow().stream())
        .collect(Collectors.toList());

//    Zespol zespol = new Zespol("asd", new ArrayList<>());
//    Stream.of(zespol)
//        .reduce(new Zespol("asd", new ArrayList<>()), )
  }
}

