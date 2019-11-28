public class KategoriaInstruktora {
    private int id;
    protected Kategoria kategoria;
    protected Instruktor instruktor;

    public KategoriaInstruktora(int id, Kategoria kategoria, Instruktor instruktor) {
        this.id = id;
        this.kategoria = kategoria;
        this.instruktor = instruktor;
    }

    public int getId(){
        return id;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }
}
