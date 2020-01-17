import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Instruktor extends Uzytkownik {
    protected int godzStartuPracy;
    protected int godzKoncaPracy;
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();
    private ArrayList<Kategoria> kategorieInstruktora = new ArrayList<Kategoria>();


    public Instruktor(String haslo, String email, String imie, String nazwisko, String nrTelefonu, int godzStartuPracy, int godzKoncaPracy) {
        super(haslo, email, imie, nazwisko, nrTelefonu);
        this.godzStartuPracy = godzStartuPracy;
        this.godzKoncaPracy = godzKoncaPracy;
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

    public boolean czyMaPrawa(Kategoria kategoria) {
        for (Kategoria k : kategorieInstruktora)
            if (kategoria.equals(k))
                return true;
        return false;

    }

    public int getGodzStartuPracy() {
        return godzStartuPracy;
    }

    public void setGodzStartuPracy(int godzStartuPracy) {
        this.godzStartuPracy = godzStartuPracy;
    }

    public int getGodzKoncaPracy() {
        return godzKoncaPracy;
    }

    public void setGodzKoncaPracy(int godzKoncaPracy) {
        this.godzKoncaPracy = godzKoncaPracy;
    }


    public ArrayList<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }


    public void setRezerwacje(ArrayList<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }

    public ArrayList<Kategoria> getKategorieInstruktora() {
        return kategorieInstruktora;
    }

    public void setKategorieInstruktora(ArrayList<Kategoria> kategorieInstruktora) {
        this.kategorieInstruktora = kategorieInstruktora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Instruktor that = (Instruktor) o;
        return godzStartuPracy == that.godzStartuPracy &&
                godzKoncaPracy == that.godzKoncaPracy &&
                Objects.equals(rezerwacje, that.rezerwacje) &&
                Objects.equals(kategorieInstruktora, that.kategorieInstruktora);
    }

    @Override
    public String toString() {
        return "Instruktor{" +
                " imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                ", godzStartuPracy=" + godzStartuPracy +
                ", godzKoncaPracy=" + godzKoncaPracy +
                ", email='" + email + '\'' +
                '}';
    }
}
