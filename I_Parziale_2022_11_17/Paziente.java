package Primo_Parziale_2022_11_17;

/**
 * Si consideri un Ospedale costituito da 10 reparti univocamente
 * identificati da un intero tra 1 e 10. L'Ospedale gestisce un archivio
 * elettronico per raccogliere informazioni  sui pazienti ricoverati.
 * Implementare una classe Paziente che rappresenta un paziente ricoverato.
 * Di ogni paziente vengono archiviate le seguenti informazioni:
 * codice fiscale, età, reparto.
 **/

public class Paziente implements Comparable<Paziente> {

    private String cf;
    private int eta, reparto;

    public Paziente(String cf) {
        this(cf.toUpperCase(), 0, 0);
    }

    public Paziente(String cf, int eta, int reparto) {
        this.cf = cf.toUpperCase();
        this.eta = eta;
        this.reparto = reparto;
    }

    public String getCf() {
        return cf;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getReparto() {
        return reparto;
    }

    public void setReparto(int reparto) {
        this.reparto = reparto;
    }

    @Override
    public int compareTo(Paziente p) {
        return this.cf.compareTo(p.cf);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Paziente)) return false;
        return this.cf.equals(((Paziente) obj).cf);
    }

    @Override
    public String toString() {
        return "CF: " + cf + ", età: " + eta + ", reparto:" + reparto;
    }
}
