package I_Parziale_2014_12_02;

import java.util.LinkedList;
import java.util.List;

/**
 * Fare riferimento all’interfaccia List del JCF e scegliere un’opportuna implementazione
 * (motivando la scelta), per realizzare una classe Portamonete come collezione di monete
 * ordinata in modo non decrescente rispetto al valore delle monete. Fornire uno o più costruttori
 * ed i seguenti metodi:
 * • addMoneta(Moneta moneta): inserisce in modo ordinato la moneta nel portamonete;
 * • conteggio(Moneta moneta): conta il numero di esemplari della moneta;
 * • getTotale(): restituisce il valore totale delle monete presenti nel portamonete;
 * • remove(Moneta moneta): rimuove la prima occorrenza della moneta specificata, se
 * presente nel portamonete;
 * • print(): stampa il contenuto del portamonete in un formato leggibile.
 * Lo studente estenda la classe Portamonete (ed eventualmente, alla luce di questa specifica, la
 * classe Moneta) con altri metodi, se lo ritiene opportuno, motivando la scelta.
 */
public class Portamonete {
    List<Moneta> monete;
    int size;
    float valore;

    public Portamonete() {
        monete = new LinkedList<>();
        size = 0;
        valore = 0;
    }

    public void addMoneta(Moneta moneta) {
        int pos = 0;
        for (Moneta cur : monete) {
            if (moneta.compareTo(cur) > 0) pos++;
            else break;
        }
        monete.add(pos, moneta);
        size++;
        valore += moneta.getValore();
    }

    public int conteggio(Moneta moneta) {
        int count = 0;
        for (Moneta cur : monete) {
            if (moneta.compareTo(cur) < 0) break;
            if (moneta.equals(cur)) count++;
        }
        return count;
    }

    public float getTotale() {
        return valore;
    }

    public boolean remove(Moneta moneta) {
        boolean isRemoved = monete.remove(moneta);
        if (isRemoved) {
            size--;
            valore -= moneta.getValore();
        }
        return isRemoved;
    }

    public String print() {
        StringBuilder s = new StringBuilder();
        for (Moneta cur : monete) s.append(cur.toString()).append("\n");
        return s.toString();
    }
}
