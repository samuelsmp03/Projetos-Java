public class Interfaces {
    public static void interfacePrincipal(){
        System.out.println("\n-=-=-=-=-=-=-==-=-==-=-=-=-==-=-=-====--=-=-");
        System.out.println("MENU\n" +
                "O que você deseja fazer?\n" +
                "\t1. Login Gerente\n" +
                "\t2. Login Cliente\n" +
                "\t3. Sair\n");
        System.out.print("Digite: ");
    }

    public static void interfaceGerente(){
        System.out.println("\n-=-=-=-=-=-=-==-=-==-=-=-=-==-=-=-====--=-=-");
        System.out.println("MENU GERENTE\n" +
                "O que você deseja fazer?\n" +
                "\t1:Cadastrar Cliente\n" +
                "\t2:Excluir Cliente\n" +
                "\t3:Gerar Relatório\n" +
                "\t4:Retornar ao menu");
        System.out.print("Digite: ");
    }

    public static void interfaceCliente(String nome){
        System.out.println("\n-=-=-=-=-=-=-==-=-==-=-=-=-==-=-=-====--=-=-");
        System.out.println("MENU\n" +
                "Olá, "+nome+
                ". O que você deseja fazer?\n" +
                "\t1. Sacar\n" +
                "\t2. Depositar\n" +
                "\t3. Verificar Saldo\n" +
                "\t4. Sair\n");
        System.out.print("Digite: ");
    }
}
