import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
