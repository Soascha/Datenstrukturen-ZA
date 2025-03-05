public class Kunde{

    private String name;
    private boolean getraenkErhalten;
    private int geld;
    private String wunschGetraenk;
    private Getraenk getraenk;
    private Rechnung rechnung;

    // Standard-Konstruktor
    public Kunde() {
        name = "";
        getraenkErhalten = false;
        geld = 0;
        wunschGetraenk = "";
    }

    // Konstruktor mit Parametern
    public Kunde(String pName, String pWunschGetraenk) {
        name = pName;
        wunschGetraenk = pWunschGetraenk;
        getraenkErhalten = false;
        geld = 0;
    }

    // Getter und Setter
    public void setName(String pName) {
        name = pName;
    }

    public String getName() {
        return name;
    }

    public Getraenk getGetraenk() {
        return getraenk;
    }

    public Rechnung getRechnung() {
        return rechnung;
    }

    public void setGetraenk(Getraenk pGetraenk) {
        getraenk = pGetraenk;
    }

    public void setRechnung(Rechnung pRechnung) {
        rechnung = pRechnung;
    }

    public void setGetraenkErhalten(boolean pErhalten) {
        getraenkErhalten = pErhalten;
    }

    public boolean getGetraenkErhalten() {
        return getraenkErhalten;
    }

    public void setGeld(int pGeld) {
        geld = pGeld;
    }

    public int getGeld() {
        return geld;
    }

    public String getWunschGetraenk() {
        return wunschGetraenk;
    }
}