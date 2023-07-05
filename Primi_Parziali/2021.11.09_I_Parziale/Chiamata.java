package Primi_Parziali.I_Parziale_2021_11_09;

import java.util.Date;

public class Chiamata implements Comparable<Chiamata> {
    private final double minutiDurata; // durata della telefonata in minuti
    private final String numTel;
    // numero di telefono chiamato
    private final Date InizioDataOra; // timestamp d'inizio chiamata

    public Chiamata(String numTel, Date InizioDataOra, double minutiDurata) {
        this.minutiDurata = minutiDurata;
        this.numTel = numTel;
        this.InizioDataOra = InizioDataOra;
    }

    public double getDurata() {
        return minutiDurata;
    }

    public String getNumTel() {
        return numTel;
    }

    public Date getDataOra() {
        return InizioDataOra;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Chiamata c2)) return false;
        return (minutiDurata == c2.minutiDurata && numTel.equals(c2.numTel) && InizioDataOra.equals(c2.InizioDataOra));
    }

    public String toString() {
        return numTel + ", " + InizioDataOra + ", " + minutiDurata;
    }

    public int compareTo(Chiamata c) {
        return InizioDataOra.compareTo(c.InizioDataOra);
    }
}