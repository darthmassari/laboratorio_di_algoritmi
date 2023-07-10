package Appelli.III_Appello_2022_02_22;

import java.util.*;

class LibriByPrezzoDecr implements Comparator<Libro> {
    @Override
    public int compare(Libro a, Libro b) {
        return b.getPrezzo().compareTo(a.getPrezzo());
    }
}

public class Libreria {

    private final List<Libro> libri = new ArrayList<>();

    public void ordinaPerAutore() {
        Collections.sort(libri);
    }

    public void ordinaPerPrezzoDecr() {
        libri.sort(new LibriByPrezzoDecr());
    }

    public Set<Libro> trovaLibriByAuthor(String cognome, String nome) {
        ArrayList<Libro> libriAutore = new ArrayList<>();

        for (Libro l : libri) {
            if (l.getCognome().equals(cognome) && l.getNome().equals(nome)) libriAutore.add(l);
        }
        libriAutore.sort(new LibriByPrezzoDecr());
        return new TreeSet<>(libriAutore);
    }

    public Map<Libro, Integer> libriInMagazzino() {
        Map<Libro, Integer> magazzino = new HashMap<>();
        for (Libro l : libri) {
            magazzino.put(l, 0);
        }
        for (Libro l : libri) {
            magazzino.put(l, magazzino.get(l) + 1);
        }
        return magazzino;
    }


}
