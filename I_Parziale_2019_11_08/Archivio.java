package I_Parziale_2019_11_08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Si implementi, infine, la classe Archivio come lista di automobili, fornendo almeno le
 * seguenti funzionalità:
 * 1. Creazione di un archivio inizialmente vuoto;
 * 2. Inserimento nell’archivio attuale di una nuova automobile, dati la targa
 * dell’automobile e un riferimento al proprietario della classe Cliente: se l’automobile è
 * già presente in archivio si aggiorni l’informazione relativa al proprietario;
 * 3. Cancellazione dall’archivio attuale di un’automobile, data la sua targa;
 * 4. Creazione di un nuovo archivio contenente le automobili selezionate dall’archivio
 * principale aventi il proprietario residente in una data città (“unknown” se città
 * sconosciuta);
 * 5. Ordinamento dell’archivio in modo lessicografico crescente rispetto alla targa delle
 * automobili;
 * 6. Ordinamento dell’archivio in modo lessicografico crescente rispetto al codice fiscale
 * dei clienti;
 * 7. Stampa su video dell’archivio attuale.
 */
class AutomobiliByCF implements Comparator<Automobile> {
    @Override
    public int compare(Automobile a, Automobile b) {
        if (a.getCliente() == null) return -1;
        if (b.getCliente() == null) return +1;
        return (a.getCliente().compareTo(b.getCliente()));
    }
}

public class Archivio {
    private final ArrayList<Automobile> automobili;

    public Archivio() {
        automobili = new ArrayList<>();
    }

    public void insert(String targa, Cliente cliente) {
        insert(new Automobile(targa, cliente));
    }

    public void insert(Automobile automobile) {
        for (Automobile cur : automobili) {
            if (automobile.equals(cur)) cur.setCliente(automobile.getCliente());
            return;
        }
        automobili.add(automobile);
    }

    public boolean remove(String targa) {
        return automobili.remove(new Automobile(targa));
    }

    public Archivio archivioPerCitta(String citta) {
        Archivio archivioCitta = new Archivio();
        for (Automobile cur : automobili) {
            if (cur.getCliente().getCitta().equals(citta)) archivioCitta.insert(cur);
        }
        return archivioCitta;
    }

    public void sort() {
        Collections.sort(automobili);
    }

    public void sortByCF() {
        automobili.sort(new AutomobiliByCF());
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Automobile a : automobili) {
            s.append(a.toString()).append("\n");
        }
        return s.toString();
    }
}
