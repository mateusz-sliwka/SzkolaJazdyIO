public class Usluga {
    protected int id;
    protected String nazwa;
    protected int cena;
    private Kategoria kategoria;

    public Usluga(int id, String nazwa, int cena, Kategoria kategoria) {
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return null;
    }

}
