public class Getraenk {

    private String name;
    private int preis;


    // Konstruktor mit zwei Parametern
    public Getraenk(String pName, int pPreis) {
        name = pName;
        preis = pPreis;
    }

    public String getName() {
        return name;
    }
    public void setName(){

    }

    public int getPreis() {
        return preis;
    }
}