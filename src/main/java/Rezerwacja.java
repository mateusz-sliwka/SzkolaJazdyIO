import java.util.Date;
import java.util.Objects;

public class Rezerwacja {
    protected Instruktor instruktor;
    protected Kursant kursant;
    protected Usluga usluga;
    private int ilosc;
    private Date dataStart;

    public Rezerwacja(int ilosc, Date dataStart, Instruktor instruktor, Kursant kursant, Usluga usluga) {
        this.ilosc = ilosc;
        this.dataStart = dataStart;
        this.instruktor = instruktor;
        this.kursant = kursant;
        this.usluga = usluga;
    }

    public Rezerwacja(int ilosc, Date dataStart,  Kursant kursant) {
        this.ilosc = ilosc;
        this.dataStart = dataStart;
        this.kursant = kursant;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Date getDataStart() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public Kursant getKursant() {
        return kursant;
    }

    public void setKursant(Kursant kursant) {
        this.kursant = kursant;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rezerwacja that = (Rezerwacja) o;
        return ilosc == that.ilosc &&
                Objects.equals(dataStart, that.dataStart) &&
                Objects.equals(instruktor, that.instruktor) &&
                Objects.equals(kursant, that.kursant) &&
                Objects.equals(usluga, that.usluga);
    }

    @Override
    public String toString() {
        return "Rezerwacja{" +
                "ilosc=" + ilosc +
                ", dataStart=" + dataStart +
                ", instruktor=" + instruktor +
                ", kursant=" + kursant +
                ", usluga=" + usluga +
                '}';
    }
}
