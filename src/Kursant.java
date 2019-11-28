public class Kursant extends Uzytkownik {
    protected String pesel;
    protected String PKK;

    public Kursant(int id, String haslo, String email, String imie, String nazwisko, String nrTelefonu, String pesel, String PKK) {
        super(id, haslo, email, imie, nazwisko, nrTelefonu);
        this.pesel = pesel;
        this.PKK = PKK;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPKK() {
        return PKK;
    }

    public void setPKK(String PKK) {
        this.PKK = PKK;
    }
}
