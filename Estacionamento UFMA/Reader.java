import java.util.*;
public class Reader {
    static Scanner input = new Scanner(System.in);

    public static long lerLong() {
        long aux;
        try {
            aux = input.nextLong();
        } catch (InputMismatchException exception) {
            System.err.println ("valor invalido, digite um inteiro");
            input.nextLine();
            return lerLong();
        }
        return aux;
    }

    public static float lerFloat() {
        float aux;
        try {
            aux = input.nextFloat();
        } catch (InputMismatchException exception) {
            System.err.println ("valor invalido, digite um numero");
            input.nextLine();
            return lerFloat();
        }
        return aux;
    }

    public static String lerString() {
        String aux;
        aux = input.next();
        return aux;
    }
}