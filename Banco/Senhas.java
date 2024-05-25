public class Senhas {
    static int aux;


    public static int lerSenhaGerente() {
        while (true) {
            aux = Reader.lerInt();
            if (aux >= 100000 && aux <= 999999){
                return aux;
            } else {
                System.err.println("Senha de gerente inválida!!! Insira uma senha de 6 dígitos inteiros!");
            }
        }
    }
}
