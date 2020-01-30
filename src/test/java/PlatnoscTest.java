import SzkolaJazdy.Data;
import SzkolaJazdy.Kursant;
import SzkolaJazdy.Platnosc;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Date;

import static org.junit.Assert.*;


@Category(PlatnoscTest.class)
public class PlatnoscTest {
    Data data;
   Kursant k;
   Date date;
   @Before
   public void setUp(){
       data=new Data();
       k=data.getKursant();
       date = new Date();
   }
    @Test
    public void testEquals(){ //sprawdzenie porownania dwoch platnosci o tych samych parametrach
        Platnosc p = new Platnosc(date,k,200);
        Platnosc p1 = new Platnosc (date,k,200);
        assertTrue(p.equals(p1));
    }

    @Test
    public void testEqualsWithDifferentValue(){ //sprawdzenie porwnania dwoch prawie takich samych platnosci - roznica w znaku wartosci
        Platnosc p = new Platnosc(date,k,200);
        Platnosc p1 = new Platnosc (date,k,-200);
        assertFalse(p.equals(p1));
    }

    @Test
    public void testConstructor(){ //sprawdzenie poprawnosci przypisania uzytkownika do platnosci
        Platnosc p = new Platnosc(date,k,200);
        assertEquals(p.getKursant().getPesel(),k.getPesel());
    }
}
