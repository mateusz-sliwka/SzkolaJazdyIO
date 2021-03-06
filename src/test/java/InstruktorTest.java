import SzkolaJazdy.Data;
import SzkolaJazdy.Instruktor;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;
@Category(InstruktorTest.class)
public class InstruktorTest {
    Instruktor i;
    Data data;

    @Before
    public void init(){
        data=new Data();
        i=data.getInstruktor();
    }
    @Test
    public void testCzyMaPrawaNaPoczatku() //test sprawdzajacy poczatkowe prawa insturktora
    {
        assertFalse(i.czyMaPrawa(data.getKategoria()));
    }

    @Test
    public void testCzyMaPrawaPoDodaniu() //test sprawdzajacy dzialanie nadanie praw instruktorowi
    {
        i.getKategorieInstruktora().add(data.getKategoria());
        assertTrue(i.czyMaPrawa(data.getKategoria()));
    }
}
