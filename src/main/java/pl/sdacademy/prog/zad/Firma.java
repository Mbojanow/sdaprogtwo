package pl.sdacademy.prog.zad;


import java.util.List;

public class Firma {
  private String nazwaFirmy;
  private List<Oddzial> listaOddzialow;

  public Firma(String nazwaFirmy, List<Oddzial> listaOddzialow) {
    this.nazwaFirmy = nazwaFirmy;
    this.listaOddzialow = listaOddzialow;
  }

  public String getNazwaFirmy() {
    return nazwaFirmy;
  }

  public List<Oddzial> getListaOddzialow() {

    return listaOddzialow;
  }

  @Override
  public String toString() {
    return "Firma {" +
        "nazwaFirmy='" + nazwaFirmy + '\'' +
        ", listaOddzialow=" + listaOddzialow +
        '}';
  }
}

