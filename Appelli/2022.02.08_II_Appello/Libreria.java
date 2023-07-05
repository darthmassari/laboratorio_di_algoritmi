package Appelli.II_Appello_2022_02_08;

import java.util.*;

public class Libreria {

    private List<Libro> libri;

    public Libreria() {
        libri = new ArrayList<>();
    }

    public void insert(String ISBN, String cognome, String nome, Integer anno) {
        insert(new Libro(ISBN, cognome, nome, anno));
    }

    public void insert(Libro libro) {
        if (!libri.contains(libro)) libri.add(libro);
    }

    public boolean delete(String ISBN) {
        for (Libro l : libri) {
            if (l.getISBN().equals(ISBN)) return libri.remove(l);
        }
        return false;
    }

    public Integer annoMinimo() {
        int min = libri.get(0).getAnno();
        for (Libro l : libri) {
            if (l.getAnno() < min) min = l.getAnno();
        }
        return min;
    }

    public List<Libro> trovaLibriByAnno(int anno) {
        List<Libro> libriByAnno = new ArrayList<>();
        Collections.sort(libri);
        for (Libro l : libri) {
            if (l.getAnno() > anno) break;
            if (l.getAnno() == anno) libriByAnno.add(l);
        }
        return libriByAnno;
    }

    public Map<Integer, Integer> libriPerAnno() {
        Map<Integer, Integer> libriAnno = new HashMap<>();
        Collections.sort(libri);
        for (Libro l : libri) {
            libriAnno.put(l.getAnno(), 0);
        }
        for (Libro l : libri) {
            libriAnno.put(l.getAnno(), libriAnno.get(l.getAnno()) + 1);
        }
        return libriAnno;
    }
}
