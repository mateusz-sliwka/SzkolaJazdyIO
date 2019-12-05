import java.util.ArrayList;

public class Kategoria {
    protected String symbol;
    private ArrayList<Instruktor> instruktorzy = new ArrayList<Instruktor>();
    private ArrayList<Usluga> uslugi = new ArrayList<Usluga>();

    public Kategoria(String nazwa) {
        this.symbol = nazwa;
    }

    public ArrayList<Instruktor> getInstruktorzy() {
        return instruktorzy;
    }

    public void setInstruktorzy(ArrayList<Instruktor> instruktorzy) {
        this.instruktorzy = instruktorzy;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public ArrayList<Usluga> getUslugi() {
        return uslugi;
    }

    public void setUslugi(ArrayList<Usluga> uslugi) {
        this.uslugi = uslugi;
    }

    @Override
    public boolean equals(Object o) {
        return ((Kategoria) o).getSymbol() == this.symbol;
    }

    @Override
    public String toString() {
        return "Kategoria{" +
                "nazwa='" + symbol + '\'' +
                ", instruktorzy=" + instruktorzy +
                '}';
    }
}
