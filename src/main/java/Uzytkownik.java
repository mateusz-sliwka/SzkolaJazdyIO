import java.util.Objects;

public class Uzytkownik {
    protected String haslo;
    protected String email;
    protected String imie;
    protected String nazwisko;
    protected String nrTelefonu;


    public Uzytkownik(String haslo, String email, String imie, String nazwisko, String nrTelefonu) {
        this.haslo=haslo;
        this.email=email;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.nrTelefonu=nrTelefonu;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uzytkownik that = (Uzytkownik) o;
        return Objects.equals(haslo, that.haslo) &&
                Objects.equals(email, that.email) &&
                Objects.equals(imie, that.imie) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(nrTelefonu, that.nrTelefonu);
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "email='" + email + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                '}';
    }
}
