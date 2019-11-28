import java.util.Date;

public class Platnosc {
    protected int id;
    protected Date dataPlatnosci;
    private Kursant kursant;
    protected int wartosc;

    public Platnosc(int id, Date dataPlatnosci, Kursant kursant, int wartosc) {
        this.id = id;
        this.dataPlatnosci = dataPlatnosci;
        this.kursant = kursant;
        this.wartosc = wartosc;
    }

    public int getId() {
        return id;
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
}
