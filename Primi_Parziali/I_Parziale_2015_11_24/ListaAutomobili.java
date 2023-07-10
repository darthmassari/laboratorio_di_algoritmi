package Primi_Parziali.I_Parziale_2015_11_24;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Il programma deve fornire (oltre agli usuali metodi pubblici per gestire i dati di un oggetto)
 * almeno le seguenti funzionalità:
 * - inserimento di un nuovo autoveicolo nella lista;
 * - cancellazione di un autoveicolo dalla lista, data la targa;
 * - stampa a video della lista;
 * - ordinamento della lista in ordine crescente rispetto alla targa dell’autoveicolo;
 * - ordinamento della lista in ordine non decrescente rispetto all’anno di immatricolazione.
 */
class AutoByDate implements Comparator<Automobile> {
    @Override
    public int compare(Automobile a, Automobile b) {
        return a.getAnno() - b.getAnno();
    }
}

public class ListaAutomobili {
    List<Automobile> lista = new LinkedList<>();

    public void insert(Automobile automobile) {
        if (!lista.contains(automobile)) lista.add(automobile);
    }

    public boolean remove(String targa) {
        return lista.remove(new Automobile(targa));
    }

    public String toString() {
        return lista.toString();
    }

    public void PrintLista() {
        System.out.println(lista);
    }

    public void sort() {
        Collections.sort(lista);
    }

    public void sortByDate() {
        lista.sort(new AutoByDate());
    }

    /**
     * Esercizio 2
     * a) definire un metodo che restituisca in output un oggetto contenente il numero di
     * immatricolazioni annue effettuate per ogni singolo anno dal 2000 al 2015;
     * b) descrivere un metodo main di test che popoli la lista di autoveicoli leggendo i dati dal file
     * “auto.txt” contenuto nella cartella corrente. Ogni linea del file contiene i dati strutturati
     * come illustrato dal seguente esempio:
     * Fiat Punto, DJ244TC, 2008, DLGGNN77P58C632R
     */

    public int[] immatricolazioniPerAnno(int annoIn, int annoFin) {
        int size = annoFin - annoIn + 1;
        int[] occ = new int[size];
        for (Automobile cur : lista) {
            int diff = cur.getAnno() - annoIn;
            if (diff >= 0 && diff < size) occ[diff]++;
        }
        return occ;
    }
}
