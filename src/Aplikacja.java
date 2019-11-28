import java.util.ArrayList;

public class Aplikacja {
    private ArrayList<Kursant> kursanci;
    private ArrayList<Rezerwacja> rezerwacje;
    private ArrayList<Administrator> administratorzy;
    private ArrayList<Instruktor> instruktorzy;
    private ArrayList<Kategoria> kategorie;
    private ArrayList<KategoriaInstruktora> kategorieInstruktora;
    private ArrayList<Usluga> uslugi;
    private ArrayList<Uzytkownik> uzytkownicy;
    private ArrayList<Platnosc> platnosci;

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

    public ArrayList<KategoriaInstruktora> getKategorieInstruktora() {
        return kategorieInstruktora;
    }

    public void setKategorieInstruktora(ArrayList<KategoriaInstruktora> kategorieInstruktora) {
        this.kategorieInstruktora = kategorieInstruktora;
    }

    public ArrayList<Usluga> getUslugi() {
        return uslugi;
    }

    public void setUslugi(ArrayList<Usluga> uslugi) {
        this.uslugi = uslugi;
    }

    public ArrayList<Uzytkownik> getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(ArrayList<Uzytkownik> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

    public ArrayList<Platnosc> getPlatnosci() {
        return platnosci;
    }

    public void setPlatnosci(ArrayList<Platnosc> platnosci) {
        this.platnosci = platnosci;
    }

    public void logowanie(String email, String haslo) {
    }

    public void rejestracja(Uzytkownik uzytkownik) {
    }

    public void sesjaUzytkownika(Uzytkownik uzytkownik) {
    }

    public void wylogowanie(Uzytkownik uzytkownik) {
    }

    public Uzytkownik znajdzUzytkownika(int id) {
        return null;
    }

    public void usunUzytkownika(Uzytkownik uzytkownik) {
    }

    public Platnosc znajdzPlatnosc(int id) {
        return null;
    }

    public void dodajPlatnosc(Platnosc platnosc) {
    }

    public void usunPlatnosc(Platnosc platnosc) {
    }

    public ArrayList<Platnosc> platnosciUzytkownika(int id) {
        return null;
    }

    public Rezerwacja znajdzRezerwacje(int id) {
        return null;
    }

    public void usunRezerwacje(Rezerwacja rezerwacja) {
    }

    public void dodajRezerwacje(Rezerwacja rezerwacja) {
    }

    public ArrayList<Rezerwacja> rezerwacjeUzytkownika(Uzytkownik uzytkownik) {
        return null;
    }

    public Usluga znajdzUsluge(int id) {
        return null;
    }

    public void usunUsluge(Usluga usluga) {
    }

    public void dodajUsluge(Usluga usluga) {
    }

    public void dodajKategorieInstruktora(KategoriaInstruktora kategoriaInstruktora) {
    }

    public void usunKategorieInstruktora(KategoriaInstruktora kategoriaInstruktora) {
    }

    public ArrayList<KategoriaInstruktora> kategorieInstruktora(Instruktor instruktor) {
        return null;
    }

}
