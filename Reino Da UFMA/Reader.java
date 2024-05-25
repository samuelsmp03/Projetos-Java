import java.util.InputMismatchException;
import java.util.Scanner;
public class Reader {
    //Classe de leitura que evita possíveis erros!!!

    static Scanner input = new Scanner(System.in); //Usando o Scanner padrão de Java
    public static int lerInt() {
        int aux;
        try {
            aux = input.nextInt();
        }catch(InputMismatchException exception){
            System.err.println("Número inválido, digite um inteiro!");
            input.nextLine();
            return lerInt();
        }
        return aux;
    }
}