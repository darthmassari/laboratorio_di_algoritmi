package Primi_Parziali.I_Parziale_2019_11_08;

/**
 * Un’Assicurazione gestisce un archivio elettronico per raccogliere
 * informazioni sulle automobili assicurate e sui loro clienti (proprietari di automobili).
 * Implementare:
 * •una classe Cliente, avente (i) nominativo (“unknown” se sconosciuto), (ii) codice
 * fiscale e (iii) città di residenza (“unknown” se sconosciuta) come variabili d’istanza;
 */
public class Cliente implements Comparable<Cliente> {
    private String nominativo;
    private String cf;
    private String citta;

    public Cliente(String cf) {
        this.nominativo = "unknown";
        this.cf = cf.toUpperCase();
        this.citta = "unknown";
    }

    public Cliente(String nominativo, String cf, String citta) {
        this.nominativo = nominativo;
        this.cf = cf.toUpperCase();
        this.citta = citta;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf.toUpperCase();
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public int compareTo(Cliente cliente) {
        return this.cf.compareTo(cliente.cf);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cliente)) return false;
        return ((Cliente) obj).cf.equals(this.cf);
    }

    @Override
    public String toString() {
        return "nominativo: " + nominativo + ", cf: " + cf + ", città: " + citta;
    }
}
