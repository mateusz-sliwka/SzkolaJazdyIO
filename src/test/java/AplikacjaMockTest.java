import org.junit.jupiter.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Moc;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Category(AplikacjaMockTest.class)
@RunWith(MockitoJUnitRunner.class)
public class AplikacjaMockTest {

    @Mock
    Aplikacja aplikacja;
    Rezerwacja rezerwacjaMock;
    Usluga uslugaMock;
    ArrayList<Rezerwacja> rezerwacjeList;
    ArrayList<Usluga> uslugaList;

    @Test
    public void testOdwolajRezerwacje(){
        rezerwacjeList.add(rezerwacjaMock);
        aplikacja.setRezerwacje(rezerwacjeList);
        aplikacja.odwolajRezerwacje(rezerwacjaMock);
        Assertions.assertEquals(0, aplikacja.getRezerwacje().size());
    }

    @Test
    public void testUsunUsluge(){
        uslugaList.add(uslugaMock);
        aplikacja.setUslugi(uslugaList);
        aplikacja.usunUsluge(uslugaMock);
        Assertions.assertEquals(0,aplikacja.getUslugi().size());

    }

}

