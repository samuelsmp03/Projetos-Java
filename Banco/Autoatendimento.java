import java.util.*;

public class Autoatendimento {

    public static void main(String[] args) {

        boolean funcionando = true;

        int agenciaDaVez,senhaDaVez;
        int numero, senha;
        int opc; //Ler o switch

        System.out.print("Digite a senha do gerente: ");
        senhaDaVez = Senhas.lerSenhaGerente();
        System.out.print("Digite a agência do gerente: ");
        agenciaDaVez = Reader.lerInt();

        Banco banco = new Banco(agenciaDaVez,senhaDaVez);
        System.out.println("\n-=-=-=-=-=-=-==-=-==-=-=-=-==-=-=-====--=-=-");
        System.out.println("Bem vindo ao " + banco.getNome());
        while (funcionando) {
            Interfaces.interfacePrincipal();
            opc = Reader.lerInt();
            switch (opc) {
                case 1: // Login gerente
                    System.out.print("Digite a senha do gerente: ");
                    senhaDaVez = Reader.lerInt();
                    System.out.print("Digite a agência do gerente: ");
                    agenciaDaVez = Reader.lerInt();
                    loginGerente(agenciaDaVez,senhaDaVez,banco);
                    break;

                case 2: // Login Cliente
                    System.out.print("Digite o número da sua conta: ");
                    numero = Reader.lerInt();
                    System.out.print("Digite a sua senha: ");
                    senha = Reader.lerInt();
                    loginCliente(numero,senha,banco);
                    break;

                case 3: // Sair
                    System.out.println("Até a próxima!");
                    funcionando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }


    public static void loginGerente(int agencia, int senha ,Banco banco){
        if(banco.login(agencia,senha)) {
            boolean funcionando = true;
            int opc;
            String nome;
            long CPF;
            int senhaDaVez;
            System.out.println("\n-=-=-=-=-=-=-==-=-==-=-=-=-==-=-=-====--=-=-");
            System.out.println("Bem vindo gerente!");
            while (funcionando) {
                Interfaces.interfaceGerente();
                opc = Reader.lerInt();
                switch (opc) {
                    case 1:  //Cadastrar
                        int numClientes = banco.getNumClientes();
                        System.out.print("Informe o CPF: ");
                        CPF = Reader.lerLong();
                        for (int i = 0; i < numClientes; i++) {
                            while (CPF == banco.getCliente(i).getCPF()) {
                                System.err.println("Este CPF já existe!!!");
                                CPF = Reader.lerLong();
                            }
                        }
                        System.out.print("Informe o nome do cliente: ");
                        nome = Reader.lerString();
                        System.out.print("Informe a senha do usuário " + nome + ": ");
                        senhaDaVez = Reader.lerInt();
                        System.out.printf("\n");
                        Conta conta = new Conta(banco.getNumClientes() + 1, senhaDaVez);
                        Cliente novo = new Cliente(nome, CPF, conta);
                        gerenteCadastrarCliente(novo, banco);
                        break;

                    case 2: //Excluir
                        System.out.print("Digite o número do CPF do cliente a ser excluído: ");
                        CPF = Reader.lerLong();
                        gerenteExcluirCliente(CPF, banco);
                        break;

                    case 3: // Relatório
                        gerenteGerarRelatorio(banco);
                        break;

                    case 4:
                        funcionando = false;
                        break;

                    default:
                        System.err.println("Opção inválida!!!");
                        break;
                }
            }
        }else{
            System.err.println("Dados incorretos!!!");
        }
    }

    public static void gerenteCadastrarCliente(Cliente novo,Banco banco){
        String nome = novo.getNome();
        Conta conta = novo.getConta();

        System.out.println(nome+" sua conta foi registrada com o número; "+conta.getNumero());
        Print.verificaBool(banco.cadastrarCliente(novo));
    }

    public static void gerenteExcluirCliente(long CPF,Banco banco){
        Print.verificaBool(banco.excluirCliente(CPF));
    }

    public static void gerenteGerarRelatorio(Banco banco){
        int numClientes = banco.getNumClientes();
        System.out.println("\n-=-=-=-=-=-=-==-=-==-=-=-=-==-=-=-====--=-=-");
        System.out.println("Relatório da Agência "+banco.getAgencia()+ " do "+ banco.getNome()+"\n");
        for(int i = 0; i < numClientes;i++){
            Cliente cliente = banco.getCliente(i);
            System.out.println(cliente.getNome() + "\t" + "R$ "+cliente.getConta().getSaldo());
        }
        System.out.println("\nTotal de Clientes: "+banco.getNumClientes());
        System.out.println("Saldo total:R$ "+ banco.getDinheiroTotal());
    }

    public static void loginCliente(int numCliente,int senhaCliente,Banco banco){

        if(banco.loginCliente(numCliente,senhaCliente)) {
            Interfaces menu = new Interfaces();
            int senha;
            float valor;
            boolean funcionando = true;
            Cliente cliente = banco.achaCliente(numCliente, senhaCliente);
            String nome = cliente.getNome();

            while (funcionando) {
                float saldo = cliente.getConta().getSaldo();
                menu.interfaceCliente(nome);
                int opc = Reader.lerInt();
                switch (opc) {

                    case 1: // SACAR
                        System.out.print("Digite sua senha: ");
                        senha = Reader.lerInt();
                        System.out.print("Digite a quantia que deseja sacar: ");
                        valor = Reader.lerFloat();
                        clienteSacar(valor, senha, cliente);
                        break;

                    case 2: // DEPOSITAR

                        System.out.print("Digite a quantia que gostaria de depositar: ");
                        valor = Reader.lerFloat();
                        clienteDepositar(valor, cliente);
                        break;

                    case 3: //VERIFICAR SALDO

                        System.out.print("Digite sua senha: ");
                        senha = Reader.lerInt();
                        clienteVerificarSaldo(senha, cliente);
                        break;

                    case 4: //SAIR
                        funcionando = false;
                        break;

                    default:
                        System.out.println("Opção inválida!!!");
                        break;
                }
            }
        }else{
            System.err.println("Dados incorretos!!!");
        }
    }

    public static void clienteSacar(float valor, int senha,Cliente cliente) {
        Print.verificaBool(cliente.getConta().sacar(valor, senha));
    }

    public static void clienteDepositar(float valor,Cliente cliente){
        Print.verificaBool(cliente.getConta().depositar(valor));
    }

    public static void clienteVerificarSaldo(int senha,Cliente cliente){
        System.out.printf("Você possui: R$");
        Print.verificaFloat(cliente.getConta().verificarSaldo(senha));
    }
}

