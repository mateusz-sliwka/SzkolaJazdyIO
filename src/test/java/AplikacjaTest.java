
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Category(AplikacjaTest.class)
public class AplikacjaTest {
    Aplikacja aplikacja;
    Kursant kursant;
    public  AplikacjaTest(){

    }


    @Before
   public void setUp() {
        aplikacja = new Aplikacja();
        kursant = new Kursant("igor123","igor@test.pl","Igor","Klepuszewski","444555666","98101099876","AKS3332222323");
        aplikacja.rejestracja(kursant);
    }

    @Category(DrivingSchoolSuiteTest.class)
    @Test
    public void testLogowanieWithIncorrectPassword() { //test logowania przy nieprawidlowym hasle
        System.out.println("LogowanieWithIncorrectPassword");
        Assertions.assertFalse(aplikacja.logowanie("igor@test.pl","igorek"));
    }

    @Category(DrivingSchoolSuite.class)
    @Test
   public void testLogowanieWithCorrectPassword() { //testo logowania przy podaniu prawidlowego hasla
        System.out.println("LogowanieWithCorrextPassowrd");
        Assertions.assertTrue(aplikacja.logowanie("igor@test.pl","igor123"));
    }

    @Test
    public void testRejestracja(){ //test rejestracji uzytkownika
        System.out.println("rejestracja");
        int before = aplikacja.getKursanci().size();
        aplikacja.rejestracja(kursant);
        int after = aplikacja.getKursanci().size();
        assertEquals(before+1,after);
    }

    @Test
    public void testDodajRezerwacje(){ //sprawdzenie dodawania rezerwacji dla instruktora i kursanta jednoczesnie
        Instruktor i = new Instruktor("igor123","igor@test.pl","Igor","Klepuszewski","444555666",11,15);
        Kategoria k = new Kategoria("B");
        Rezerwacja r = new Rezerwacja(1,new Date(),i,kursant,new Usluga("test",100,k));
        i.getKategorieInstruktora().add(k);
        kursant.getPlatnosci().add(new Platnosc(new Date(),kursant,1000));
        aplikacja.dodajRezerwacje(r);
        assertTrue(i.getRezerwacje().size()==1&&kursant.getRezerwacje().size()==1);
    }
}