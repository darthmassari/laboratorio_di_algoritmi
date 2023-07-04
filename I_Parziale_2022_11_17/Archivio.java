package Primo_Parziale_2022_11_17;

import java.util.*;

/**
 * Realizzare una classe Archivio come lista di oggetti (non nulli) di tipo Paziente, fornendo almeno
 * le seguenti funzionalità:
 * 1) Inserimento nell’archivio attuale di un nuovo paziente ricoverato, dati il suo codice fiscale, età e
 * reparto di riferimento: se il paziente è già presente in archivio l’operazione deve fallire;
 * 2) Cancellazione dall’archivio attuale di un paziente, data il suo codice fiscale;
 * 3) Creazione di un nuovo archivio contenente i pazienti selezionati dall’archivio principale che sono
 * ricoverati in un dato reparto;
 * 4) Ordinamento dell’archivio in modo lessicografico crescente rispetto al codice fiscale dei pazienti;
 * 5) Ordinamento dell’archivio in modo crescente all’età dei pazienti;
 * 6) Calcolo del numero di pazienti ricoverati in ciascun reparto (usare la struttura dati più
 * appropriata per restituire in output le informazioni aggregate).
 **/
class Cmp_byEta implements Comparator<Paziente> {
    public int compare(Paziente p1, Paziente p2) {
        return (p1.getEta() - p2.getEta());
    }
}

public class Archivio {

    List<Paziente> pazienti = new LinkedList<>();

    public boolean insert(String cf, int eta, int reparto) {
        if (cf != null && eta >= 0 && reparto >= 0 && reparto <= 10) return insert(new Paziente(cf, eta, reparto));
        else return false;
    }

    public boolean insert(Paziente p) {
        for (Paziente paziente : pazienti)
            if (p.equals(paziente)) return false;
        pazienti.add(p);
        return true;
    }

    public boolean delete(String cf) {
        return pazienti.remove(new Paziente(cf));
    }

    public Archivio ArchivioReparto(int r) {
        Archivio nuovo = new Archivio();
        for (Paziente paziente : pazienti)
            if (paziente.getReparto() == r) nuovo.insert(paziente);
        return nuovo;
    }

    public void sort_byCF() {
        Collections.sort(pazienti);
    }

    public void sort_byEta() {
        pazienti.sort(new Cmp_byEta());
    }

    public int[] PazientiPerReparto() {
        int[] occ = new int[11];
        for (int i = 0; i < 11; i++) occ[i] = 0;
        for (Paziente paziente : pazienti) occ[paziente.getReparto()]++;
        return occ;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Paziente paziente : pazienti) s.append(paziente.toString()).append("\n");
        return s.toString();
    }
}
