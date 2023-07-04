package I_Parziale_2016_11_08;

public class Ex1 {
    private static int valore = 10;
    private String word;
    int id;
    static int c;

    public Ex1(String word) {
        this.word = word;
        System.out.println(this);
    }

    public String toString() {
        return id + " di " + c + ") " + valore + ", " + word;
    }

    {
        id = ++c;
    }

    static {
        valore = 50;
        c = 0;
    }

    public static void main(String args[]) {
        Ex1 a = new Ex1("oggi"), b = new Ex1("domani");
        b.valore = 100;
        System.out.println(a);
        System.out.println(b);
    }
}

/*
 * OUTPUT
 * 1 di 1) 50, oggi
 * 2 di 2) 50, domani
 * 1 di 2) 100, oggi
 * 2 di 2) 100, domani
 */