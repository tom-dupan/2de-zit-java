package Bedrijf;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Random;

public class Bestelling implements Comparable<Bestelling> {
    private int bestelnummer;
    private int klantennummer;
    private int postcode;
    private int grootte;
    private LocalDate besteldatum;
    private Boolean prior;
    private Status status;



    public int getKlantennummer() {
        return klantennummer;
    }
    public int getPostcode() {
        return postcode;
    }
    public int getGrootte() {
        return grootte;
    }
    public LocalDate getBesteldatum() {
        return besteldatum;
    }
    public Status getStatus() {
        return status;
    }

    public Boolean getPrior() {
        return prior;
    }

    // nieuwe bestelling
    public Bestelling(int klantennummer, int postcode, Boolean prior, Status status) {
        this.klantennummer = klantennummer;
        this.postcode = postcode;
        this.grootte = new Random().nextInt(99)+1;
        this.besteldatum = LocalDate.now();
        this.prior = prior;
        this.status = status;
    }

    // bestelling inladen
    public Bestelling(int bestelnummer, int klantennummer, int postcode, int grootte, Status status, Boolean prior, LocalDate besteldatum) {
        this.bestelnummer = bestelnummer;
        this.klantennummer = klantennummer;
        this.postcode = postcode;
        this.grootte = grootte;
        this.status = status;
        this.prior = prior;
        this.besteldatum = besteldatum;
    }

    @Override
    public String toString() {
        return "Bestelling{" +
                "bestelnummer=" + bestelnummer +
                ", klantennummer=" + klantennummer +
                ", postcode=" + postcode +
                ", grootte=" + grootte +
                ", besteldatum=" + besteldatum +
                ", prior=" + prior +
                ", status=" + status +
                '}';
    }

    @Override
    public int compareTo(Bestelling bestelling) {
        return Integer.compare(this.getPostcode(), bestelling.getPostcode());
    }

}

