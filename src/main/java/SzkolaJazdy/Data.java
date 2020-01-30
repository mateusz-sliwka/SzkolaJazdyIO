package SzkolaJazdy;

import java.util.Date;

public class Data {

    public Kategoria getKategoria() {
        return new Kategoria("B");
    }

    public Usluga getUsluga(){
        return new Usluga("Szkolenie praktyczne",100,getKategoria());
    }

    public Kursant getKursant(){
    return new Kursant("test123","mateosl@wp.pl","Testowe","Testowe","5655556556","9807065454","PK1212");
    }

    public Instruktor getInstruktor(){
    return new Instruktor("ins11","instruktor@test.pl","SzkolaJazdy.Instruktor","Trstowy","444354434",11,12);
    }

    public Rezerwacja getRezerwacja() {
        return new Rezerwacja(1, new Date(), getInstruktor(), getKursant(), getUsluga());
    }
}
