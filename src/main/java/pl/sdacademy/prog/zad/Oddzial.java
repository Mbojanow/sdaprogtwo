package pl.sdacademy.prog.zad;

import java.util.*;

public class Oddzial {
  private String nazwaOddzialu;
  List<Zespol> listaZespolow;

  public Oddzial(String nazwaMiasta, List<Zespol> listaZespolow) {
    this.nazwaOddzialu = nazwaMiasta;
    this.listaZespolow = listaZespolow;
  }

  public String getNazwaOddzialu() {
    return nazwaOddzialu;
  }

  public List<Zespol> getListaZespolow() {

    return listaZespolow;
  }

  @Override
  public String toString() {
    return "Oddzial {" +
        "nazwaOddzialu='" + nazwaOddzialu + '\'' +
        ", listaZespolow=" + listaZespolow +
        '}';
  }
}

