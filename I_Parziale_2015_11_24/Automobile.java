package I_Parziale_2015_11_24;

/**
 * Scrivere un programma che definisca ed utilizzi le classi ed i metodi necessari per gestire una
 * lista di autoveicoli registrati presso un ufficio di motorizzazione Civile. Per ogni automobile
 * registrata, l’ufficio memorizza: modello, targa, anno di immatricolazione e codice fiscale del
 * proprietario. Esempio: “Fiat Punto”, “DJ244TC”, 2008, “DLGGNN77P58C632R”.
 */
public class Automobile implements Comparable<Automobile> {

    private String modello;
    private String targa;
    private int anno;
    private String cf;

    public Automobile(String targa) {
        this.modello = "";
        this.targa = targa.toUpperCase();
        this.anno = 0;
        this.cf = "";
    }

    public Automobile(String modello, String targa, int anno, String cf) {
        this.modello = modello;
        this.targa = targa.toUpperCase();
        this.anno = anno;
        this.cf = cf.toUpperCase();
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa.toUpperCase();
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf.toUpperCase();
    }

    @Override
    public int compareTo(Automobile a) {
        return targa.compareTo(a.targa);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Automobile)) return false;
        return this.targa.equals(((Automobile) obj).targa);
    }

    @Override
    public String toString() {
        return "Modello: " + modello + ", targa: " + targa + ", anno: " + anno + ", CF: " + cf;
    }
}
