package FitnesseTests;

import SzkolaJazdy.*;
import fit.ColumnFixture;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class TestAplikacja extends ColumnFixture {
    String haslo;
    String email;
    String imie;
    String nazwisko;
    String nrTelefonu;
    String pesel;
    String PKK;
    int godzStartuPracy;
    int godzKoncaPracy;
    int saldo;

    public int TestDodajKursanta(){
        Kursant kursant = new Kursant(haslo,email,imie,nazwisko,nrTelefonu,pesel,PKK);
        SetUp.aplikacja.rejestracja(kursant);
        return SetUp.aplikacja.getKursanci().size();
    }

    public boolean TestCzyDodanoPrawidlowoKursanta(){
        Kursant nowyKursant = new Kursant(haslo,email,imie,nazwisko,nrTelefonu,pesel,PKK);
        SetUp.aplikacja.rejestracja(nowyKursant);
        Kursant kursant = SetUp.aplikacja.getKursanci().get(SetUp.aplikacja.getKursanci().size()-1);
        if(nowyKursant.equals(kursant))
            return true;
        return false;
}

public boolean TestCzyPrawidlowyTestDodaniaKursanta(){
        int iloscKursantow = TestDodajKursanta();
        Kursant kursant = SetUp.aplikacja.getKursanci().get(iloscKursantow-1);
        if(kursant.getPesel().equals(pesel))
            return true;
        return false;

}

    public int TestDodajInstruktora(){
        Instruktor instruktor  = new Instruktor(haslo,email,imie,nazwisko,nrTelefonu,godzStartuPracy,godzKoncaPracy);
        SetUp.aplikacja.rejestracja(instruktor);
        return SetUp.aplikacja.getInstruktorzy().size();
    }


public boolean TestCzyPrawidlowyTestDodaniaInstruktora(){
        int iloscInstruktorow = TestDodajInstruktora();
        Instruktor instruktor = SetUp.aplikacja.getInstruktorzy().get(iloscInstruktorow-1);
        if(instruktor.getNazwisko().equals(nazwisko))
            return true;
        return false;
}

public boolean TestCzyDodanoPrawdilowoInstruktora(){
    Instruktor nowyInstruktor = new Instruktor(haslo,email,imie,nazwisko,nrTelefonu,godzStartuPracy,godzKoncaPracy);
    SetUp.aplikacja.rejestracja(nowyInstruktor);
    Instruktor instruktor = SetUp.aplikacja.getInstruktorzy().get(SetUp.aplikacja.getInstruktorzy().size()-1);
    if(nowyInstruktor.equals(instruktor))
        return true;
    return false;
}

public int TestDodawanieRezerwacji(){
    Kursant kursant = new Kursant(haslo,email,imie,nazwisko,nrTelefonu,pesel,PKK);
    Instruktor instruktor = new Instruktor("test123","ins@instruktor.pl","Adam","Slodowy","555667677",10,12);
    kursant.getPlatnosci().add(new Platnosc(new Date(),kursant,saldo));
    Kategoria kategoria = new Kategoria("B");
    Usluga usluga = new Usluga("Praktyka kat B",100,kategoria);
    instruktor.getKategorieInstruktora().add(kategoria);
    Rezerwacja rezerwacja = new Rezerwacja(1,new Date(),instruktor,kursant,usluga);
    SetUp.aplikacja.dodajRezerwacje(rezerwacja);
    return kursant.getSaldo();
}

}
