import SzkolaJazdy.Data;
import SzkolaJazdy.Kursant;
import SzkolaJazdy.Platnosc;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Date;

@Category(KursantTest.class)
public class KursantTest {
    Kursant kursant;
    Data data;

    @BeforeEach
    public void setUp(){
        data = new Data();
        kursant = data.getKursant();
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2})
   public void testGetSaldo(int kolejnosc){ //dodawanie platnosci, sprawdzenie poprawnego dodawania do listy platnosci
        kursant.getPlatnosci().add(new Platnosc(new Date(),kursant,kolejnosc*100));
        int[] wynik={0,100,200};
        assertEquals(wynik[kolejnosc],kursant.getSaldo());
    }

    @ParameterizedTest 
    @ValueSource(ints={0,1,2})
    public void testGetSaldoWithTwoOperation(int kolejnosc){ //dodanie dwoch platnosci (uznania i obciazenia) i sprawdzenia czy poprawnie sumuje platnosci o warotsci roznego znaku
        kursant.getPlatnosci().add(new Platnosc(new Date(),kursant,2*(kolejnosc+1)*100));
        kursant.getPlatnosci().add(new Platnosc(new Date(),kursant,-(kolejnosc+1)*100));
        int[] wynik={100,200,300};
        assertEquals(wynik[kolejnosc],kursant.getSaldo());
    }

    @Test
    public void testCzyDostepny(){ //metoda testujaca sprawdzanie dostepnosci kursanta, dodanie rezerwacji i po dodaniu sprawdzenie czy kursant jest dostepny
        kursant.getRezerwacje().add(data.getRezerwacja());
        assertFalse(kursant.czyDostepny(new Date(),1));
    }
}
