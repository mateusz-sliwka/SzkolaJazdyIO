package SzkolaJazdy;

import java.util.Objects;

public class Usluga {
    protected String nazwa;
    protected int cena;
    private Kategoria kategoria;

    public Usluga(String nazwa, int cena, Kategoria kategoria) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.kategoria = kategoria;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usluga usluga = (Usluga) o;
        return cena == usluga.cena &&
                Objects.equals(nazwa, usluga.nazwa) &&
                Objects.equals(kategoria, usluga.kategoria);
    }

    @Override
    public String toString() {
        return "SzkolaJazdy.Usluga{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", kategoria=" + kategoria +
                '}';
    }
}
