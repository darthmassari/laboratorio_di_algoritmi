package Appelli.II_Appello_2022_02_08;

public class Libro implements Comparable<Libro> {

    private String ISBN;
    private String cognome;
    private String nome;
    private Integer anno;

    public Libro() {
    }

    public Libro(String ISBN, String cognome, String nome, Integer anno) {
        this.ISBN = ISBN;
        this.cognome = cognome;
        this.nome = nome;
        this.anno = anno;
    }

    public String getISBN() {
        return ISBN;
    }

    /*
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    */

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Libro l)) return false;
        return this.ISBN.equals(l.ISBN);
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Cognome autore: " + cognome + ", Nome autore: " + nome + ", Anno pubblicazione: " + anno;
    }

    @Override
    public int compareTo(Libro libro) {
        if (this.anno < libro.getAnno()) return -1;
        if (this.anno > libro.getAnno()) return +1;
        return this.cognome.compareTo(libro.getCognome());
    }
}
