import java.util.ArrayList;

public class Instruktor extends Uzytkownik {
  protected int godzStartuPracy;
  protected int godzKoncaPracy;

    public Instruktor(int id, String haslo, String email, String imie, String nazwisko, String nrTelefonu, int godzStartuPracy, int godzKoncaPracy) {
        super(id, haslo, email, imie, nazwisko, nrTelefonu);
        this.godzStartuPracy = godzStartuPracy;
        this.godzKoncaPracy = godzKoncaPracy;
    }

    public int getGodzStartuPracy() {
        return godzStartuPracy;
    }

    public void setGodzStartuPracy(int godzStartuPracy) {
        this.godzStartuPracy = godzStartuPracy;
    }

    public int getGodzKoncaPracy() {
        return godzKoncaPracy;
    }

    public void setGodzKoncaPracy(int godzKoncaPracy) {
        this.godzKoncaPracy = godzKoncaPracy;
    }
}
