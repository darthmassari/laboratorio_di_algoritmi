package I_Parziale_2019_11_08;

/**
 * •una classe Automobile avente come variabili d’istanza (i) la targa della vettura e (ii)
 * un riferimento al proprietario della classe Cliente.
 */
public class Automobile implements Comparable<Automobile> {
    private String targa;
    private Cliente cliente;

    public Automobile(String targa) {
        this(targa.toUpperCase(), null);
    }

    public Automobile(String targa, Cliente cliente) {
        this.targa = targa.toUpperCase();
        this.cliente = cliente;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa.toUpperCase();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int compareTo(Automobile automobile) {
        return this.targa.compareTo(automobile.targa);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Automobile)) return false;
        return ((Automobile) obj).targa.equals(this.targa);
    }

    @Override
    public String toString() {
        return "targa: " + targa + ", cliente: " + cliente.toString();
    }
}
