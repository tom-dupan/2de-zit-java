package Bedrijf;

import Database.GebruikersDao;

public class Gebruiker implements Comparable<Gebruiker>  {
   protected String naam;
   protected String paswoord;
    private int klantennummer;
    private String adres;

    public Gebruiker(int anInt, String string, String string1) {
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    public int getKlantennummer() {
        return klantennummer;
    }

    public void setKlantennummer(int klantennummer) {
        this.klantennummer = klantennummer;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Gebruiker(String naam, String paswoord, int klantennummer, String adres) {
        this.naam = naam;
        this.paswoord = paswoord;
        this.klantennummer = klantennummer;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Gebruiker{" +
                "naam='" + naam + '\'' +
                ", paswoord='" + paswoord + '\'' +
                ", klantennummer=" + klantennummer +
                ", adres='" + adres + '\'' +
                '}';
    }

    @Override
        public int compareTo (Gebruiker gebruiker){
           return this.getPaswoord().compareTo(gebruiker.getPaswoord());
        }
}

