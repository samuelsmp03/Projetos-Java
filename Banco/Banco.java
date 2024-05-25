import java.util.ArrayList;

public class Banco {
    private static final String nome = "UFMA Bank";
    private int agencia;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private int senhaGerente;
    private float aux=0;

    public String getNome(){
        return nome;
    }
    public int getAgencia(){
        return agencia;
    }

    public Cliente getCliente(int i){
        return clientes.get(i);
    }

    public Cliente achaCliente(int num,int senha){
        for(Cliente cliente : clientes){
            if(num == cliente.getConta().getNumero() && senha ==cliente.getConta().getSenha()){
                return cliente;
            }

        }
        return null;
    }
    public int getNumClientes(){
        return clientes.size();
    }

    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public boolean cadastrarCliente(Cliente novo){
        for(Cliente cliente : clientes){
            if(cliente.getCPF() == novo.getCPF()){
                return false;
            }
        }
        clientes.add(novo);
        return true;
    }
    public boolean excluirCliente(long CPF){
        for(Cliente cliente : clientes){
            if(cliente.getCPF() == CPF){
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    public float getDinheiroTotal(){
            for(Cliente cliente : clientes){
                aux += cliente.getConta().getSaldo();
            }
            return aux;
    }

    public boolean loginCliente(int numero,int senha){
        for(Cliente cliente : clientes ){
            if(cliente.getConta().getNumero() == numero && cliente.getConta().getSenha() == senha){
                return true;
            }
        }
        return false;
    }
    public Banco(int agencia, int senha){
        senhaGerente = senha;
        this.agencia = agencia;
    }
    public boolean login(int agencia,int senha){
        if(agencia == this.agencia && senha == senhaGerente  ){
            return true;
        }
        return false;
    }

}
