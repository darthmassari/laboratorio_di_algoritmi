package V_Appello_2022_07_05;

import java.util.*;

class LibriByPrezzo implements Comparator<Libro> {
    @Override
    public int compare(Libro a, Libro b) {
        return a.getPrezzo().compareTo(b.getPrezzo());
    }
}

public class Biblioteca {
    private final Map<Libro, Integer> copie = new TreeMap<>();

    public void add(Libro libro, Integer quantita) {
        copie.put(libro, quantita);
    }

    public boolean remove(String codice, Integer quantita) {
        for (Map.Entry<Libro, Integer> entry : copie.entrySet()) {
            if (entry.getKey().getCodice().equals(codice)) {
                if (entry.getValue() >= quantita) {
                    copie.put(entry.getKey(), entry.getValue() - quantita);
                    return true;
                }
            }
        }
        return false;
    }

    public Set<Libro> ordinaPerCodice() {
        return copie.keySet();
    }

    public Set<Libro> ordinaPerPrezzo() {
        List<Libro> libriPerPrezzo = new ArrayList<>(copie.keySet());
        libriPerPrezzo.sort(new LibriByPrezzo());
        return new TreeSet<>(libriPerPrezzo);
    }

    public Set<Libro> trovaLibri(int soglia) {
        Set<Libro> libriSoglia = new TreeSet<>();

        for (Map.Entry<Libro, Integer> entry : copie.entrySet()) {
            if (entry.getValue() > soglia) libriSoglia.add(entry.getKey());
        }
        return libriSoglia;
    }

    public int getNumeroCopie() {
        int numeroCopie = 0;
        for (Map.Entry<Libro, Integer> entry : copie.entrySet())
            numeroCopie += entry.getValue();
        return numeroCopie;
    }

}
