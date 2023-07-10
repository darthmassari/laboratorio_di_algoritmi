package Appelli.V_Appello_2022_07_05;

public class Libro implements Comparable<Libro> {
    private String codice;
    private String titolo;
    private Integer pagine;
    private Double prezzo;

    public String getCodice() {
        return codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public Integer getPagine() {
        return pagine;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Libro l)) return false;
        return this.codice.equals(l.codice);
    }

    @Override
    public int compareTo(Libro o) {
        return this.codice.compareTo(o.codice);
    }
}
