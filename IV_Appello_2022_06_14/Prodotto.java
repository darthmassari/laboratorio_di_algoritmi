package IV_Appello_2022_06_14;

public class Prodotto implements Comparable<Prodotto> {

    private String codice;
    private String descrizione;
    private Double prezzo;
    private Integer sconto;

    public String getCodice() {
        return codice;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public Integer getSconto() {
        return sconto;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Prodotto p)) return false;
        return this.codice.equals(p.codice);
    }

    @Override
    public int compareTo(Prodotto o) {
        return this.codice.compareTo(o.codice);
    }
}
