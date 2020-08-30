package pl.sdacademy.prog.zad;

import java.util.*;

public class Zespol {
  private String nazwaZespolu;
  private List<Pracownik> listaPracownikow;

  public Zespol(String nazwaZespolu, List<Pracownik> listaPracownikow) {
    this.nazwaZespolu = nazwaZespolu;
    this.listaPracownikow = listaPracownikow;
  }

  public String getNazwaZespolu() {
    return nazwaZespolu;
  }

  public List<Pracownik> getListaPracownikow() {
    return listaPracownikow;
  }

  public void addPracownik(Pracownik pracownik) {
    listaPracownikow.add(pracownik);
  }

  @Override
  public String toString() {
    return "Zespol {" +
        "nazwaZespolu='" + nazwaZespolu + '\'' +
        ", listaPracownikow=" + listaPracownikow +
        '}';
  }
}

