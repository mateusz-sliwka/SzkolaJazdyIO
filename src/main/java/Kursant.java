import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Kursant extends Uzytkownik {
    protected String pesel;
    protected String PKK;
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();
    private ArrayList<Platnosc> platnosci = new ArrayList<Platnosc>();

    public int getSaldo() {
        int saldo = 0;
        for (Platnosc p : platnosci)
            saldo += p.getWartosc();
        return saldo;
    }
    public Kursant(String haslo, String email, String imie, String nazwisko, String nrTelefonu, String pesel, String PKK) {
        super(haslo, email, imie, nazwisko, nrTelefonu);
        this.pesel = pesel;
        this.PKK = PKK;
    }

    public boolean czyDostepny(Date dataStart, int ilosc) {
        Calendar c = Calendar.getInstance();
        c.setTime(dataStart);
        c.add(Calendar.HOUR, ilosc);
        Date dataEnd = c.getTime();
        for (Rezerwacja r : rezerwacje) {
            Calendar c2 = Calendar.getInstance();
            c2.setTime(r.getDataStart());
            c2.add(Calendar.HOUR, r.getIlosc());
            Date dataEnd2 = c2.getTime();
            if (r.getDataStart().after(dataStart) && r.getDataStart().before(dataEnd) || dataEnd2.after(dataStart) && dataEnd2.before(dataEnd))
                return false;
        }
        return true;
    }


    public ArrayList<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(ArrayList<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }

    public ArrayList<Platnosc> getPlatnosci() {
        return platnosci;
    }

    public void setPlatnosci(ArrayList<Platnosc> platnosci) {
        this.platnosci = platnosci;
    }




    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPKK() {
        return PKK;
    }

    public void setPKK(String PKK) {
        this.PKK = PKK;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Kursant kursant = (Kursant) o;
        return Objects.equals(pesel, kursant.pesel) &&
                Objects.equals(PKK, kursant.PKK);
    }

    @Override
    public String toString() {
        return "Kursant{" +
                "pesel='" + pesel + '\'' +
                ", PKK='" + PKK + '\'' +
                ", email='" + email + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                '}';
    }
}
