package Appelli.I_Appello_2022_01_25;

public class Docente implements Comparable<Docente> {

    private String nome;
    private String cognome;
    private final String codice;
    private Integer eta;

    public Docente(String codice) {
        this.nome = null;
        this.cognome = null;
        this.codice = codice.toUpperCase();
    }

    public Docente(String nome, String cognome, String codice, Integer eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice.toUpperCase();
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodice() {
        return codice;
    }

    /*
    public void setCodice(String codice) {

        this.codice = codice;
    }
    */

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Docente d)) return false;
        return this.codice.equals(d.codice);
    }

    @Override
    public int compareTo(Docente d) {
        if (this.eta < d.getEta()) return -1;
        if (this.eta > d.getEta()) return +1;
        String nomeCognome = this.nome + this.cognome;
        String otherNomeCognome = d.nome + d.cognome;
        return nomeCognome.compareTo(otherNomeCognome);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", codice: " + codice + ", Eta: " + eta;
    }
}
