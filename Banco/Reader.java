import java.util.Scanner;
public class Reader {
    static Scanner input = new Scanner(System.in);
    public static int lerInt(){
        while(!input.hasNextInt()){
            System.err.println("Inteiro inválido!!!" + input.nextLine());
        }
        return input.nextInt();
    }
    public static String lerString(){
        while(!input.hasNextLine()){
            System.err.println("String inválida!!!"+ input.nextLine());
        }
        input.nextLine();
        return input.nextLine();
    }
    public static long lerLong(){
        while(!input.hasNextLong()){
            System.err.println("Long inválido!!!"+ input.nextLine());
        }
        return input.nextLong();
    }
    public static float lerFloat(){
        while (!input.hasNextFloat()){
            System.err.println("Float inválido!!!"+ input.nextLine());
        }
        return input.nextFloat();
    }

}
