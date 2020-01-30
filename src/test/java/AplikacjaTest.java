import SzkolaJazdy.*;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Category(AplikacjaTest.class)
public class AplikacjaTest {
    Data data;
    Aplikacja aplikacja;
    @Mock
    Kursant kursant=mock(Kursant.class);
    @Mock
    Instruktor instruktor=mock(Instruktor.class);
    @Mock
    Kategoria kategoria = mock(Kategoria.class);

    public  AplikacjaTest(){

    }
    @Before
   public void setUp() {
        MockitoAnnotations.initMocks(this);
        aplikacja = new Aplikacja();
        data = new Data();
        aplikacja.rejestracja(kursant);
        when(kursant.getHaslo()).thenReturn("igor123");
        when(kursant.getEmail()).thenReturn("igor@test.pl");
    }


    @Test
    public void testLogowanieWithIncorrectPassword() { //test logowania przy nieprawidlowym hasle
        Assertions.assertFalse(aplikacja.logowanie("igor@test.pl","igorek"));
    }

    @Test
   public void testLogowanieWithCorrectPassword() { //testo logowania przy podaniu prawidlowego hasla
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

    @Category(MockedTestSuite.class)
    @Test
    public void testDodajRezerwacje(){ //sprawdzenie dodawania rezerwacji w przypadku dostepnosci instrukt i kursanta i wystarczajacych praw i salda
        when(kursant.czyDostepny(any(Date.class),anyInt())).thenReturn(true);
        when(instruktor.czyDostepny(any(Date.class),anyInt())).thenReturn(true);
        when(kursant.getSaldo()).thenReturn(1000);
        when(instruktor.czyMaPrawa(any(Kategoria.class))).thenReturn(true);
        Rezerwacja r = new Rezerwacja(1,new Date(),instruktor,kursant,new Usluga("test",100,kategoria));
        assertTrue(aplikacja.dodajRezerwacje(r));
    }
    @Category(MockedTestSuite.class)
    @Test
    public void testDodajRezerwacjeZaMaleSaldo(){ //sprawdzenie dodawania rezerwacji w przypadku za malego salda kursanta
        when(kursant.czyDostepny(any(Date.class),anyInt())).thenReturn(true);
        when(instruktor.czyDostepny(any(Date.class),anyInt())).thenReturn(true);
        when(kursant.getSaldo()).thenReturn(80);
        when(instruktor.czyMaPrawa(any(Kategoria.class))).thenReturn(true);
        Rezerwacja r = new Rezerwacja(1,new Date(),instruktor,kursant,new Usluga("test",100,kategoria));
        assertFalse(aplikacja.dodajRezerwacje(r));
    }

    @Category(MockedTestSuite.class)
    @Test
    public void testDodajRezerwacjeInstruktorNiedostepny(){ //sprawdzenie dodawania rezerwacji w przypadku niedostepnosci instruktora
        when(kursant.czyDostepny(any(Date.class),anyInt())).thenReturn(true);
        when(instruktor.czyDostepny(any(Date.class),anyInt())).thenReturn(false);
        when(kursant.getSaldo()).thenReturn(1000);
        when(instruktor.czyMaPrawa(any(Kategoria.class))).thenReturn(true);
        Rezerwacja r = new Rezerwacja(1,new Date(),instruktor,kursant,new Usluga("test",100,kategoria));
        assertFalse(aplikacja.dodajRezerwacje(r));
    }


    @Test
    public void testOdwolajRezerwacjeWTerminie(){ //sprawdzenie faktu dodania zwrotu przy odwolaniu w terminie
        Date datePlus = DateUtils.addDays(new Date(),10);
        Rezerwacja r = data.getRezerwacja();
        r.setDataStart(datePlus);
        int before = aplikacja.getPlatnosci().size();
        aplikacja.odwolajRezerwacje(r);
        int after = aplikacja.getPlatnosci().size();
        assertEquals(1,after-before);
    }
    @Test
    public void testOdwolajRezerwacjePoTerminie(){ //sprawdzenie faktur braku dodania zwortu przy odwolaniu po terminie
        data.getRezerwacja().setDataStart(new Date());
        int before = aplikacja.getPlatnosci().size();
        aplikacja.odwolajRezerwacje(data.getRezerwacja());
        int after = aplikacja.getPlatnosci().size();
        assertEquals(0,after-before);
    }
}