package SzkolaJazdy;

import java.util.Date;
import java.util.Objects;

public class Platnosc {

    protected Date dataPlatnosci;
    protected int wartosc;
    private Kursant kursant;

    public Platnosc(Date dataPlatnosci, Kursant kursant, int wartosc) {
        this.dataPlatnosci = dataPlatnosci;
        this.kursant = kursant;
        this.wartosc = wartosc;
    }

    public Date getDataPlatnosci() {
        return dataPlatnosci;
    }

    public void setDataPlatnosci(Date dataPlatnosci) {
        this.dataPlatnosci = dataPlatnosci;
    }

    public Kursant getKursant() {
        return kursant;
    }

    public void setKursant(Kursant kursant) {
        this.kursant = kursant;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platnosc platnosc = (Platnosc) o;
        return wartosc == platnosc.wartosc &&
                Objects.equals(dataPlatnosci, platnosc.dataPlatnosci) &&
                Objects.equals(kursant, platnosc.kursant);
    }

    @Override
    public String toString() {
        return "SzkolaJazdy.Platnosc{" +
                "dataPlatnosci=" + dataPlatnosci +
                ", kursant=" + kursant +
                ", wartosc=" + wartosc +
                '}';
    }
}
