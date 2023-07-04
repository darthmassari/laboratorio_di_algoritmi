package I_Parziale_2016_11_08;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 2) tutti i metodi associati alla classe Soccorso così definita:
 * public class Soccorso {
 * private ArrayList<Paziente> attesa;
 * public Soccorso();
 * public void ingresso(String codice, int priorita);
 * public Paziente dimissione();
 * public void cambio(String unCodice, int nuovaPriorita);
 * }
 * Le tre priorità utilizzate per i pazienti sono: 2 ("rosso", priorità maggiore), 1 ("giallo") e 0 ("verde", priorità
 * minore), e devono essere servite e ordinate all'interno della lista di attesa nell'ordine specificato. A parità di
 * priorità, i pazienti sono serviti/ordinati con la politica primo arrivato, primo servito.
 *  Il metodo “ingresso” aggiunge un nuovo paziente;
 *  il metodo “dimissione” serve/elimina il prossimo paziente in attesa;
 *  il metodo “cambio” aggiorna la priorità del paziente avente il codice specificato come parametro
 * esplicito, riposizionandolo all'interno della coda di attesa;
 * Se opportuno, sviluppare metodi ausiliari che vi facilitino la scrittura del codice dei metodi richiesti.
 */
public class Soccorso {
    private final ArrayList<Paziente> attesa;

    public Soccorso() {
        attesa = new ArrayList<>();
    }

    public void ingresso (String codice, int priorita) {
        this.ingresso(new Paziente(codice, priorita));
    }

    public void ingresso (Paziente paziente) {
        int pos = 0;
        for (Paziente cur : attesa) {
            if (cur.compareTo(paziente) < 0) pos++;
            else break;
        }
        attesa.add(pos, paziente);
    }

    public Paziente dimissione() {
        return attesa.remove(0);
    }

    public void cambio(String unCodice, int nuovaPriorita) {
        Paziente p = new Paziente(unCodice, nuovaPriorita);
        Paziente cur = null;
        // cancella il paziente dalla lista, salvando in cur l'oggetto
        Iterator<Paziente> iter = attesa.iterator();
        while(iter.hasNext()) {
            cur = iter.next();
            if(cur.equals(p)) {
                iter.remove();
                break;
            }
        }
        if (cur == null) this.ingresso(p);
        else  {cur.setPriorita(nuovaPriorita); this.ingresso(cur);}

    }

}
