package Primi_Parziali.Altri_Esercizi_I_Parziale;

/*
  Scrivere un metodo generico statico che accetti due array di elementi e
  restituisca una lista di tutti gli elementi comuni a entrambi gli array. Quindi
  utilizzare il metodo sul tipo Integer. L'output deve essere privo di elementi
  duplicati e ordinato in ordine decrescente.
 */

import java.util.*;

public class Esercizio2 {
    public static <E extends Comparable<? super E>> LinkedList<E> createIntersectionList(E[] a, E[] b) {
        LinkedList<E> list = new LinkedList<>();
        int i = 0, j = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) < 0) i++;
            else if (a[i].compareTo(b[j]) > 0) j++;
            else {
                if (list.isEmpty() || !(a[i].equals(list.getFirst()))) list.addFirst(a[i]);
                i++;
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 15, 1, 10, 15, 12, 3};
        Integer[] b = {2, 25, 1, 12, 11, 15, 3};
        LinkedList<Integer> list = Esercizio2.createIntersectionList(a, b);
        for (Integer integer : a) System.out.print(integer + " ");
        System.out.println();
        for (Integer integer : b) System.out.print(integer + " ");
        System.out.println();
        System.out.println(list);
    }
}
