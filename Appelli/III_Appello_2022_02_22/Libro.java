package Appelli.III_Appello_2022_02_22;

public class Libro implements Comparable<Libro> {

    private String ISBN;
    private String cognome;
    private String nome;
    private Double prezzo;

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Libro l)) return false;
        return this.ISBN.equals(l.ISBN);
    }

    @Override
    public int compareTo(Libro l) {
        String autoreLibro = this.cognome + this.nome;
        String otherAutoreLibro = l.cognome + l.nome;
        return autoreLibro.compareTo(otherAutoreLibro);
    }
}
