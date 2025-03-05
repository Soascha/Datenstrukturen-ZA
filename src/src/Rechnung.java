public class Rechnung {
    private int rechnungsnr, betrag;
    private String datum;

    public Rechnung(String pDatum, int pRechnungsnr, int pBetrag){
        datum= pDatum= "";
        rechnungsnr= pRechnungsnr = 0;
        betrag= pBetrag=0;
    }

    public int getrechnungsnr(){
        return rechnungsnr;
    }

    public int getbetrag(){
        return betrag;
    }

    public String getdatum(){
        return datum;
    }





}