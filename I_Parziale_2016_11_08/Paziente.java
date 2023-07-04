package I_Parziale_2016_11_08;

/**
 * Scrivere un programma che simuli il servizio di pronto soccorso di un’azienda ospedaliera. Sviluppare:
 * 1) una classe Paziente, avente le variabili d'istanza codice (stringa univoca) e priorità (intero);
 */
public class Paziente implements Comparable<Paziente> {
    private String codice;
    private int priorita;
    private int id = 0;
    static private int count = 0;


    public Paziente(String codice) {
        this.codice = codice;
        this.priorita = 0;
        this.id = ++c;
    }

    public Paziente(String codice, int priorita) {
        this.codice = codice;
        this.priorita = priorita;
        this.id = ++c;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getPriorita() {
        return priorita;
    }

    public void setPriorita(int priorita) {
        this.priorita = priorita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Paziente paziente) {
        if (this.codice.equals(paziente.codice)) return 0;
        if (this.priorita != paziente.priorita) return paziente.priorita - this.priorita;
        else return this.id - paziente.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Paziente)) return false;
        else return ((Paziente) obj).codice.equals(codice);
    }

    @Override
    public String toString() {
        return "Codice: " + codice + ", priorità: " + priorita + ", id: " + id;
    }
}
