import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AplikacjaTest {
    Aplikacja aplikacja;

    @BeforeAll
    void setUp() {
        aplikacja = new Aplikacja();
        Kursant igor = new Kursant("igor123","igor@test.pl","Igor","Klepuszewski","444555666","98101099876","AKS3332222323");
        aplikacja.rejestracja(igor);
    }

    @Test
    void testLogowanieWithIncorrectPassword() {
        Assertions.assertFalse(aplikacja.logowanie("igor@test.pl","igorek"));
    }

    @Test
    void testLogowanieWithCorrectPassword() {
        Assertions.assertTrue(aplikacja.logowanie("igor@test.pl","igor123"));
    }
}