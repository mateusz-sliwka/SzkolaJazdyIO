import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Aplikacja {
    enum RodzajKonta {Kursant, Instruktor, Administrator}

    ;
    private ArrayList<Kursant> kursanci = new ArrayList<>();
    private ArrayList<Instruktor> instruktorzy = new ArrayList<>();
    private ArrayList<Usluga> uslugi = new ArrayList<>();
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList<>();
    private ArrayList<Administrator> administratorzy = new ArrayList<>();
    private ArrayList<Kategoria> kategorie = new ArrayList<>();
    private ArrayList<Platnosc> platnosci = new ArrayList<>();


    /**
     * SETTERY I GETTERY
     **/

    public ArrayList<Kursant> getKursanci() {
        return kursanci;
    }

    public void setKursanci(ArrayList<Kursant> kursanci) {
        this.kursanci = kursanci;
    }

    public ArrayList<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(ArrayList<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }

    public ArrayList<Administrator> getAdministratorzy() {
        return administratorzy;
    }

    public void setAdministratorzy(ArrayList<Administrator> administratorzy) {
        this.administratorzy = administratorzy;
    }

    public ArrayList<Instruktor> getInstruktorzy() {
        return instruktorzy;
    }

    public void setInstruktorzy(ArrayList<Instruktor> instruktorzy) {
        this.instruktorzy = instruktorzy;
    }

    public ArrayList<Kategoria> getKategorie() {
        return kategorie;
    }

    public void setKategorie(ArrayList<Kategoria> kategorie) {
        this.kategorie = kategorie;
    }

    public ArrayList<Usluga> getUslugi() {
        return uslugi;
    }

    public void setUslugi(ArrayList<Usluga> uslugi) {
        this.uslugi = uslugi;
    }


    public ArrayList<Platnosc> getPlatnosci() {
        return platnosci;
    }

    public void setPlatnosci(ArrayList<Platnosc> platnosci) {
        this.platnosci = platnosci;
    }

    /**
     * KONIEC GETTEROW I SETTEROW
     **/


//    public boolean logowanie(String email, String haslo, RodzajKonta rodzajKonta) {
//        if(rodzajKonta==RodzajKonta.Administrator)
//            administratorzy.
//            else if(rodzajKonta==RodzajKonta.Kursant)
//                else if(rodzajKonta==RodzajKonta.Instruktor)
//    }
    public void rejestracja(Uzytkownik uzytkownik) {
    }

    public void sesjaUzytkownika(Uzytkownik uzytkownik) {
    }

    public void wylogowanie(Uzytkownik uzytkownik) {
    }


    public void usunPlatnosc(Platnosc platnosc) {
        //iterowanie po liscie platnosci i usuniecie podanej z listy, equals porownuje date,kursanta i wartosc
        for (Platnosc p : platnosci)
            if (p.equals(platnosc))
                platnosci.remove(p);
    }

    public void odwolajRezerwacje(Rezerwacja rezerwacja) {
        //uznajemy ze odwolac rezerwacje mozna max 1 dzien przed, wtedy oddajemy kase, jesli nie to kasa przepada i usuwamy rezerwacje
        Calendar c = Calendar.getInstance();
        c.setTime(rezerwacja.getDataStart());
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date regulaminowaData = c.getTime();
        for (Rezerwacja r : rezerwacje)
            if (new Date().before(regulaminowaData)) {
                Platnosc zwrot = new Platnosc(new Date(), rezerwacja.getKursant(), rezerwacja.getIlosc() * rezerwacja.getUsluga().getCena());
                platnosci.add(zwrot);
            }
        rezerwacje.remove(rezerwacja);
            rezerwacja.getInstruktor().getRezerwacje().remove(rezerwacja);
        rezerwacja.getKursant().getRezerwacje().remove(rezerwacja);

    }

    public void dodajRezerwacje(Rezerwacja rezerwacja) {
        //dodawanie rezerwacji, sprawdzamy dostepnosc instruktora, kursanta, prawa instruktora i to czy kursanta stac
        if (rezerwacja.getInstruktor().czyDostepny(rezerwacja.getDataStart(), rezerwacja.getIlosc()))
            if (rezerwacja.getKursant().czyDostepny(rezerwacja.getDataStart(), rezerwacja.getIlosc()))
                if (rezerwacja.getInstruktor().czyMaPrawa(rezerwacja.getUsluga().getKategoria()))
                    if (rezerwacja.getKursant().getSaldo() >= rezerwacja.getIlosc() * rezerwacja.getUsluga().cena)
                        rezerwacje.add(rezerwacja);
                    rezerwacja.getInstruktor().getRezerwacje().add(rezerwacja);
                    rezerwacja.getKursant().getRezerwacje().add(rezerwacja);
    }

    public void usunUsluge(Usluga usluga) {
        //usuwamy usluge z listy uslug
        for (Rezerwacja r : rezerwacje) //przeiterowanie
            if (r.getUsluga().equals(usluga))
                r.setUsluga(null);
        for (Kategoria k : kategorie)
            k.getUslugi().remove(usluga);
        uslugi.remove(usluga);
    }

    public void dodajUsluge(Usluga usluga) {
        //sprawdzamy czy podana usluga juz nie istnieje, equals porownuje cene, usluge i nazwe
        if (!uslugi.contains(usluga))
            uslugi.add(usluga);
        for (Kategoria k : kategorie)
            if (k == usluga.getKategoria())
                k.getUslugi().add(usluga);
    }

    public void przypiszKategorie(Kategoria kategoria, Instruktor instruktor) {
        //dodajemy instruktora do instruktorow danej kategorii i kategorie do kategorii danego instruktora
        kategoria.getInstruktorzy().add(instruktor);
        instruktor.getKategorieInstruktora().add(kategoria);
    }

    public void dodajKategorie(Kategoria kategoria) {
        //sprawdzamy czy nie ma juz takiej kategorii na podstawie equalsa porownujacego nazwy
        boolean czyDuplikat = false;
        for (Kategoria k : kategorie)
            if (k.equals(kategoria))
                czyDuplikat = true;
        if (!czyDuplikat)
            kategorie.add(kategoria);
    }

    public void usunKategorie(Kategoria kategoria) {
        for (Usluga u : uslugi)
            if (u.getKategoria().equals(kategoria))
                u.setKategoria(null);


        for (Instruktor i : instruktorzy)
            i.getKategorieInstruktora().remove(kategoria);

        kategorie.remove(kategoria);

    }

    public ArrayList<Rezerwacja> kartaPracyInstruktora(Instruktor instruktor) {
        return instruktor.getRezerwacje();
    }

    public static void main(String[] args) {
        Aplikacja aplikacja = new Aplikacja();
        Kategoria kategoria = new Kategoria("B");
        aplikacja.kategorie.add(kategoria);
        Usluga usluga = new Usluga("Jazda", 10, kategoria);
        aplikacja.uslugi.add(usluga);
        System.out.println(usluga.getKategoria());
        aplikacja.usunKategorie(kategoria);
        System.out.println(usluga);

    }
}
