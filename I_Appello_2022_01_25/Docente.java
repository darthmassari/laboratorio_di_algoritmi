package I_Appello_2022_01_25;

public class Docente implements Comparable<Docente> {

    private String nome;
    private String cognome;
    private String codice;
    private Integer eta;

    public Docente() {
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
        return this.codice.compareTo(d.codice);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", codice: " + codice + ", Eta: " + eta;
    }
}
