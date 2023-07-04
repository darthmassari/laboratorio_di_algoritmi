package Primo_Parziale_2022_11_17;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 1) Scrivere un metodo static ArrayList <String> differenzaSimmetrica
 * (ArrayList<String> lista1, ArrayList<String> lista2) che riceve come
 * argomenti due liste di oggetti di tipo String prive di elementi duplicati e restituisce una nuova
 * lista contenente gli oggetti presenti solo in una delle due liste.
 * 2) Come cambia la soluzione se il suddetto metodo differenzaSimmetrica diventa
 * generico?
 */
public class ex2 {

    public static ArrayList<String> differenzaSimmetrica(ArrayList<String> lista1, ArrayList<String> lista2) {
        ArrayList<String> diffSimmetrica = new ArrayList<>();
        if (lista1.isEmpty()) {
            diffSimmetrica.addAll(lista2);
            return diffSimmetrica;
        }
        if (lista2.isEmpty()) {
            diffSimmetrica.addAll(lista1);
            return diffSimmetrica;
        }
        diffSimmetrica.addAll(lista1);
        diffSimmetrica.addAll(lista2);
        Collections.sort(diffSimmetrica);
        for (int i = 0; i < diffSimmetrica.size() - 1; i++) {
            if (diffSimmetrica.get(i).equals(diffSimmetrica.get(i + 1))) {
                diffSimmetrica.remove(i);
                diffSimmetrica.remove(i + 1);
                i--;
            }
        }
        return diffSimmetrica;
    }

    public static <T extends Comparable<? super T>> ArrayList<T> differenzaSimmetricaGen(ArrayList<T> lista1, ArrayList<T> lista2) {
        ArrayList<T> diffSimmetrica = new ArrayList<>();
        if (lista1.isEmpty()) {
            diffSimmetrica.addAll(lista2);
            return diffSimmetrica;
        }
        if (lista2.isEmpty()) {
            diffSimmetrica.addAll(lista1);
            return diffSimmetrica;
        }
        diffSimmetrica.addAll(lista1);
        diffSimmetrica.addAll(lista2);
        Collections.sort(diffSimmetrica);
        for (int i = 0; i < diffSimmetrica.size() - 1; i++) {
            if (diffSimmetrica.get(i).equals(diffSimmetrica.get(i + 1))) {
                diffSimmetrica.remove(i);
                diffSimmetrica.remove(i + 1);
                i--;
            }
        }
        return diffSimmetrica;
    }
}
