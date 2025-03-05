import java.util.Scanner;
import utils.*;

public class Verwaltung {
    private Scanner scanner;
    private Queue<Kunde> queue;
    private List<Getraenk> getraenkeListe;
    private List<Rechnung> rechnungsListe;

    public static void main(String[] args) {
        new Verwaltung();
    }

    public Verwaltung() {
        scanner = new Scanner(System.in);
        queue = new Queue<>();
        getraenkeListe = new List<>();
        rechnungsListe = new List<>();
        fuelleKaffeeListeAuf();

        while (true) {
            System.out.println("== HAUPTMENÜ ==");
            System.out.println("[1] Kunde hinzufügen");
            System.out.println("[2] Bestellung bearbeiten");
            System.out.println("[3] Warteschlange anzeigen");
            System.out.println("[4] Beenden");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                kundeHinzufuegen();
            } else if (option == 2) {
                bearbeiteBestellung();
            } else if (option == 3) {
                zeigeWarteschlange();
            } else if (option == 4) {
                System.out.println("Programm wird beendet. Auf Wiedersehen!");
                break;
            } else {
                System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }
        }
        scanner.close();
    }

    private void kundeHinzufuegen() {
        System.out.print("Name des Kunden: ");
        String name = scanner.nextLine();
        System.out.print("Gewünschtes Getränk (Cappuccino, Kaffee, FlatWhite, ColdBrew): ");
        String wunschGetraenk = scanner.nextLine();
        Kunde neuerKunde = new Kunde(name, wunschGetraenk);
        queue.append(neuerKunde);

        System.out.println("Kunde " + name + " wurde zur Warteschlange hinzugefügt.");
    }

    private void bearbeiteBestellung() {
        if (!queue.isEmpty() && !getraenkeListe.isEmpty()) {
            queue.toFirst();
            Kunde kunde = queue.getContent();
            Getraenk bestelltesGetraenk = null;

            getraenkeListe.toFirst();
            while (getraenkeListe.hasAccess()) {
                if (getraenkeListe.getContent().getName().equals(kunde.getWunschGetraenk())) {
                    bestelltesGetraenk = getraenkeListe.getContent();
                    break;
                }
                getraenkeListe.next();
            }

            if (bestelltesGetraenk != null) {
                getraenkeListe.remove();
                Rechnung rechnung = new Rechnung("20.02.2025", rechnungsListe.isEmpty() ? 1 : rechnungsListe.getContent().getrechnungsnr() + 1, 5);
                kunde.setRechnung(rechnung);
                rechnungsListe.append(rechnung);
                kunde.setGetraenkErhalten(true);
                System.out.println("Bestellung für " + kunde.getName() + " wurde bearbeitet.");
                queue.dequeue();
            } else {
                System.out.println("Gewünschtes Getränk nicht verfügbar. Bitte füllen Sie die Liste auf.");
            }
        } else {
            System.out.println("Keine Kunden oder keine Getränke verfügbar.");
        }
    }

    private void zeigeWarteschlange() {

        // Gesamte Warteschlange anzeigen
        //
        if (!queue.isEmpty()) {
            System.out.println("Inhalt der Warteschlange:");
            queue.toFirst(); // Gehe zum ersten Element

            while (queue.hasAccess()) { // Solange ein Element vorhanden ist
                Kunde aktuellerKunde = queue.getContent(); // Holt das aktuelle Element
                if (aktuellerKunde != null) {
                    System.out.println("- " + aktuellerKunde.getName() + " (Bestellt: " + aktuellerKunde.getWunschGetraenk() + ")");
                }
                queue.getNext(); // Springe zum nächsten Kunden
            } System.out.println(this.queue.getContent());
        }

        else {
            System.out.println("Die Warteschlange ist leer.");
        }
    }
    private void fuelleKaffeeListeAuf() {
        getraenkeListe.append(new Getraenk("Cappuccino",3));
        getraenkeListe.append(new Getraenk("Kaffee",2));
        getraenkeListe.append(new Getraenk("FlatWhite",4));
        getraenkeListe.append(new Getraenk("ColdBrew",2));
    }


}