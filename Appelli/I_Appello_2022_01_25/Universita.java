package Appelli.I_Appello_2022_01_25;

import java.util.*;

public class Universita {

    private final List<Docente> docenti;

    public Universita() {
        docenti = new ArrayList<>();
    }

    public void insert(String nome, String cognome, String codice, Integer eta) {
        insert(new Docente(nome, cognome, codice, eta));
    }

    public void insert(Docente d) {
        if (!docenti.contains(d)) docenti.add(d);
    }

    public boolean delete(String codice) {
        for (Docente d : docenti)
            if (d.getCodice().equals(codice)) return docenti.remove(d);
        return false;
    }

    public Integer etaMinima() {
        int min = docenti.get(0).getEta();
        for (Docente d : docenti) {
            if (d.getEta() < min) min = d.getEta();
        }
        return min;
    }

    // Prova con HashMap
    public Integer etaPiuRappresentata() {
        HashMap<Integer, Integer> numEta = new HashMap<>();
        Map.Entry<Integer, Integer> maxEntry = null;

        for (Docente d : docenti) numEta.put(d.getEta(), 0);
        for (Docente d : docenti) numEta.put(d.getEta(), numEta.get(d.getEta()) + 1);
        for (Map.Entry<Integer, Integer> entry : numEta.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) maxEntry = entry;
        }
        if (maxEntry != null) return maxEntry.getValue();
        return null;
    }

    public void sort() {
        Collections.sort(docenti);
    }

    public List<Docente> estraiGiovani() {
        List<Docente> giovani = new ArrayList<>();
        Collections.sort(docenti);
        int etaMin = docenti.get(0).getEta();
        for (Docente d : docenti) {
            if (d.getEta() != etaMin) return giovani;
            giovani.add(d);
        }
        return giovani;
    }

}
