package Altri_Esercizi_I_Parziale;

/**
 * − Scrivere un metodo generico statico che accetti un array di elementi e
 * restituisca l’elemento più grande contenuto in esso. Quindi utilizzare il
 * metodo sul tipo Integer.
 * − Scrivere un metodo generico statico che accetti un array di elementi e
 * restituisca l'elemento più piccolo contenuto in esso. Quindi utilizzare il
 * metodo sul tipo String.
 */

public class Esercizio1 {

    public static <T extends Comparable<? super T>> T findMax(T[] a) {
        T max = a[0];

        for (int i = 0; i < a.length - 1; i++)
            if (a[i].compareTo(max) < 0) max = a[i];
        return max;
    }

    public static <T extends Comparable<? super T>> T findMin(T[] a) {
        T min = a[0];

        for (int i = 0; i < a.length - 1; i++)
            if (a[i].compareTo(min) < 0) min = a[i];
        return min;
    }

    public static void main(String[] args) {
        Integer[] arrayOfInt = {13, 15, 2, 100, 45, 245, 24, 2};
        Integer x = Esercizio1.<Integer>findMax(arrayOfInt);
        System.out.println("Max: " + x);

        String[] arrayOfString = {"Exam", "Algorithm", "Laboratory", "Class"};
        String s = Esercizio1.findMin(arrayOfString);
        System.out.println("Min: " + s);

    }
}