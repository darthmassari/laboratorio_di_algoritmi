package Primo_Parziale_2014_12_02;

/**
 * Realizzare una classe Moneta, i cui esemplari hanno un nome (nome della moneta, es: “Due
 * euro”) ed un valore (valore della moneta: es: 2). Fornire uno o più costruttori ed i metodi
 * getNome e GetValore, per ispezionare rispettivamente il nome ed il valore della moneta
 * corrente.
 * Lo studente estenda la classe con altri metodi, se lo ritiene opportuno, motivando la scelta.
 * NB: Si pensi ad una moneta fissata, ad es. EURO.
 */
public class Moneta implements Comparable<Moneta> {

    private String nome;
    private float valore;

    public Moneta() {
        nome = "";
        valore = 0;
    }

    public Moneta(String nome, float valore) {
        this.nome = nome;
        this.valore = valore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValore() {
        return valore;
    }

    public void setValore(float valore) {
        this.valore = valore;
    }

    @Override
    public int compareTo(Moneta m) {
        return Float.compare(this.valore, m.valore);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Moneta m)) return false;
        return m.valore == this.valore;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", valore: " + valore;
    }
}
