import java.util.Date;

public class Rezerwacja {
    private int id;
    private int ilosc;
    private Date dataStart;
    protected Instruktor instruktor;
    protected Kursant kursant;
    protected Usluga usluga;

    public int getId(){
        return id;
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

    public Rezerwacja(int id, int ilosc, Date dataStart, Instruktor instruktor, Kursant kursant, Usluga usluga) {
        this.id = id;
        this.ilosc = ilosc;
        this.dataStart = dataStart;
        this.instruktor = instruktor;
        this.kursant = kursant;
        this.usluga = usluga;
    }
}
