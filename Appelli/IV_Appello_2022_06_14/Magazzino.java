package Appelli.IV_Appello_2022_06_14;

import java.util.*;


class ProdottiByPrezzo implements Comparator<Prodotto> {
    @Override
    public int compare(Prodotto a, Prodotto b) {
        return a.getPrezzo().compareTo(b.getPrezzo());
    }
}

public class Magazzino {

    Map<Prodotto, Integer> giacenza = new TreeMap<>();

    public void insert(Prodotto prodotto, Integer quantita) {
        giacenza.put(prodotto, quantita);
    }

    public boolean remove(String codice, Integer quantita) {
        for (Map.Entry<Prodotto, Integer> entry : giacenza.entrySet()) {
            if (entry.getKey().getCodice().equals(codice)) {
                if (entry.getValue() >= quantita) {
                    giacenza.put(entry.getKey(), entry.getValue() - quantita);
                    return true;
                }
            }
        }
        return false;
    }

    public Set<Prodotto> ordinaPerCodice() {
        return giacenza.keySet();
    }

    public Set<Prodotto> ordinaPerPrezzo() {
        List<Prodotto> prodottiPerPrezzo = new ArrayList<>(giacenza.keySet());

        prodottiPerPrezzo.sort(new ProdottiByPrezzo());
        return new TreeSet<>(prodottiPerPrezzo);
    }

    public Set<Prodotto> trovaProdottiSottoSoglia(int soglia) {
        Set<Prodotto> prodottiSoglia = new TreeSet<>();

        for (Map.Entry<Prodotto, Integer> entry : giacenza.entrySet()) {
            if (entry.getValue() < soglia) prodottiSoglia.add(entry.getKey());
        }
        return prodottiSoglia;
    }

    public Double getValoreMagazzino() {
        double rimanenze = 0.0;

        for (Map.Entry<Prodotto, Integer> entry : giacenza.entrySet()) {
            Prodotto p = entry.getKey();
            rimanenze += ((p.getPrezzo() - (p.getPrezzo() * p.getSconto() / 100)) * entry.getValue());
        }
        return rimanenze;
    }
}
