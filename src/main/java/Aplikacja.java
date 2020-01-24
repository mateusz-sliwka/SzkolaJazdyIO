import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Aplikacja {

    private boolean zalogowany=false;
    private ArrayList<Kursant> kursanci = new ArrayList<>();
    private ArrayList<Instruktor> instruktorzy = new ArrayList<>();
    private ArrayList<Usluga> uslugi = new ArrayList<>();
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList<>();
    private ArrayList<Administrator> administratorzy = new ArrayList<>();
    private ArrayList<Kategoria> kategorie = new ArrayList<>();
    private ArrayList<Platnosc> platnosci = new ArrayList<>();
    private ArrayList <Uzytkownik> uzytkownicy = new ArrayList<>();
    private ArrayList<Uzytkownik> sesjaUzytkownikow = new ArrayList<Uzytkownik>();

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


    public boolean logowanie (String email, String haslo){
           for(Uzytkownik u : uzytkownicy){
               if(u.getEmail()==email&&u.getHaslo()==haslo)
               {
                   sesjaUzytkownikow.add(u);
                   return true;
                  }}
                return false;
    }
    public void rejestracja(Object uzytkownik) {

            if(uzytkownik instanceof Instruktor)
            {
                Instruktor instruktor = (Instruktor) uzytkownik;
                instruktorzy.add(instruktor);
            }
            else if(uzytkownik instanceof Kursant){
                Kursant kursant = (Kursant) uzytkownik;
                kursanci.add(kursant);
            }
            else if(uzytkownik instanceof Administrator){
                Administrator administrator = (Administrator) uzytkownik;
                administratorzy.add(administrator);
            }
            uzytkownicy.add((Uzytkownik)uzytkownik);
        uzytkownicy.get(0).getEmail();
    }


    public void wylogowanie(Uzytkownik uzytkownik) {
        sesjaUzytkownikow.remove(uzytkownik);
    }


    public void usunPlatnosc(Platnosc platnosc) {
        platnosc.getKursant().getPlatnosci().remove(platnosc);
        platnosci.remove(platnosc);
    }

    public void odwolajRezerwacje(Rezerwacja rezerwacja) {
        Calendar c = Calendar.getInstance();
        c.setTime(rezerwacja.getDataStart());
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date regulaminowaData = c.getTime();

            if (new Date().before(regulaminowaData)) {
                Platnosc zwrot = new Platnosc(new Date(), rezerwacja.getKursant(), rezerwacja.getIlosc() * rezerwacja.getUsluga().getCena());
                platnosci.add(zwrot);

            }
   rezerwacja.getInstruktor().getRezerwacje().remove(rezerwacja);
     rezerwacja.getKursant().getRezerwacje().remove(rezerwacja);
        rezerwacje.remove(rezerwacja);
    }

    public boolean dodajRezerwacje(Rezerwacja rezerwacja) {


        if (rezerwacja.getInstruktor().czyDostepny(rezerwacja.getDataStart(), rezerwacja.getIlosc()))
            if (rezerwacja.getKursant().czyDostepny(rezerwacja.getDataStart(), rezerwacja.getIlosc()))
                if (rezerwacja.getInstruktor().czyMaPrawa(rezerwacja.getUsluga().getKategoria()))
                    if (rezerwacja.getKursant().getSaldo() >= rezerwacja.getIlosc() * rezerwacja.getUsluga().cena) {
                        rezerwacje.add(rezerwacja);
                        rezerwacja.getInstruktor().getRezerwacje().add(rezerwacja);
                        rezerwacja.getKursant().getRezerwacje().add(rezerwacja);
                        Platnosc p = new Platnosc(new Date(),rezerwacja.kursant,(-1)*rezerwacja.getUsluga().getCena());
                        rezerwacja.getKursant().getPlatnosci().add(p);
                        platnosci.add(p);
                        return true;
                    }
        return false;
    }

    public void usunUsluge(Usluga usluga) {
        for (Rezerwacja r : rezerwacje)
            if (r.getUsluga().equals(usluga))
                r.setUsluga(null);
        for (Kategoria k : kategorie)
            k.getUslugi().remove(usluga);
        uslugi.remove(usluga);
    }

    public void dodajUsluge(Usluga usluga) {
        if (!uslugi.contains(usluga))
            uslugi.add(usluga);
        for (Kategoria k : kategorie)
            if (k == usluga.getKategoria())
                k.getUslugi().add(usluga);
    }

    public void przypiszKategorie(Kategoria kategoria, Instruktor instruktor) {
        kategoria.getInstruktorzy().add(instruktor);
        instruktor.getKategorieInstruktora().add(kategoria);
    }

    public void dodajKategorie(Kategoria kategoria) {
        if (!kategorie.contains(kategoria))
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

        System.out.println(usluga);
        Kursant igor = new Kursant("igor123","igor@test.pl","Igor","Klepuszewski","444555666","98101099876","AKS3332222323");
        Instruktor krzysiu = new Instruktor("krzychu123","krzychu@test.pl","Krzychu","Gajda","567765567",11,18);

        aplikacja.rejestracja(igor);
        aplikacja.rejestracja(krzysiu);



        aplikacja.przypiszKategorie(kategoria,krzysiu);

        System.out.println(aplikacja.logowanie("test@test.pl","212121"));
        System.out.println(aplikacja.logowanie("igor@test.pl","igor123"));

        Rezerwacja rezerwacja = new Rezerwacja(10,new Date(),krzysiu,igor,usluga);
        aplikacja.dodajRezerwacje(rezerwacja);
        System.out.println(igor.getRezerwacje());
        System.out.println(krzysiu.getRezerwacje());

        System.out.println(igor.getPlatnosci());
        System.out.println(aplikacja.kartaPracyInstruktora(krzysiu));
        aplikacja.odwolajRezerwacje(rezerwacja);
        System.out.println(igor.getPlatnosci());



    }
}
