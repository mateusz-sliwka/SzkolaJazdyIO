import org.junit.Test;

import static org.junit.Assert.*;

public class InstruktorTest {
    Instruktor i = new Instruktor("igor123","igor@test.pl","Igor","Klepuszewski","444555666",11,15);

    @Test
    public void testCzyMaPrawaNaPoczatku() //test sprawdzajacy poczatkowe prawa insturktora
    {
        assertFalse(i.czyMaPrawa(new Kategoria("B")));
    }

    @Test
    public void testCzyMaPrawaPoDodaniu() //test sprawdzajacy dzialanie nadanie praw instruktorowi
    {
        i.getKategorieInstruktora().add(new Kategoria("B"));
        assertTrue(i.czyMaPrawa(new Kategoria("B")));
    }
}
