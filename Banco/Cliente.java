public class Cliente {
    private String nome;
    private long CPF;
    private Conta conta;


    public Cliente(String nome,long CPF,Conta conta){
        this.nome = nome;
        this.CPF = CPF;
        this.conta = conta;
    }

    public String getNome(){
        return nome;
    }
    public long getCPF(){
        return CPF;
    }

    public Conta getConta(){
        return conta;
    }
}
