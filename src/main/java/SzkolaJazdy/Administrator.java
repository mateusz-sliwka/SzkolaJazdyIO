package SzkolaJazdy;

public class Administrator extends Uzytkownik {

    public Administrator(String haslo, String email, String imie, String nazwisko, String nrTelefonu) {
        super(haslo, email, imie, nazwisko, nrTelefonu);

    }

    @Override
    public String toString() {
        return "SzkolaJazdy.Administrator{" +
                "email='" + email + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                '}';
    }

}
