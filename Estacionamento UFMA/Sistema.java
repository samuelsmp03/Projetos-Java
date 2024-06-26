import java.util.*;
public class Sistema {
    private float horario = 0.0f;

    private static final int senha = 12345;
    private static float receita = 0f;
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Veiculo> veiculosSoltos = new ArrayList<>();
    private static ArrayList<Vagas> vagasTerreo = new ArrayList<>();

    public Sistema(float horario) {
        this.horario = horario;
    }

    public static void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static boolean verificaSenha(int teste){
        if(teste == senha){
            return true;
        }
        return false;
    }
    public static Cliente procuraCliente(String email,long numero){
        if(clientes != null) {
            for (Cliente cliente : clientes) {
                //System.out.println(cliente.getEmail() +" " +cliente.getCelular());
                //System.out.println("cliente == email"+ cliente.getEmail().equals(email)+ "cliente == celular" +(cliente.getCelular() == numero));
                if (cliente.getEmail().equals(email) && cliente.getCelular() == numero) {
                    return cliente;
                }
            }
        }
        return null;
    }

    public float getHorario() {
        return horario;
    }
    public void setHorario(float horario) {
        this.horario = horario;
    }
    public int getSenha(){
        return senha;
    }
    public static void addVeiculoSolto(Veiculo veiculo){
        veiculosSoltos.add(veiculo);
    }
    public static ArrayList<Veiculo> getVeiculosSoltos(){
        return veiculosSoltos;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Sistema.clientes = clientes;
    }

    public static ArrayList <Vagas> getVagas() {
        return vagasTerreo;
    }
    public static void addVaga(Vagas vaga){
        vagasTerreo.add(vaga);
    }
    public boolean removeVaga(Vagas vaga){
        for(Vagas vagaDaVez : vagasTerreo){
            if(vagaDaVez == vaga){
                vagasTerreo.remove(vagaDaVez);
                return true;
            }
        }
        return false;
    }

    public void setVagasTerreo(ArrayList <Vagas> vagasTerreo) {
        this.vagasTerreo = vagasTerreo;
    }

    public static void verificaReserva(){
        for(Cliente cliente : clientes){
            for(Veiculo veiculo:cliente.getVeiculos()){
                if(veiculo instanceof Moto){
                    continue;
                }
                else if(veiculo instanceof Carro){
                    ((Carro)veiculo).verificarReserva();
                }
                else if(veiculo instanceof Caminhao){
                    ((Caminhao)veiculo).verificarReserva();
                }
            }
        }
    }

    public static float getReceita() {
        return receita;
    }

    public static void setReceita(float receita) {
        Sistema.receita = receita;
    }

    public static void setVeiculosSoltos(ArrayList<Veiculo> veiculosSoltos) {
        Sistema.veiculosSoltos = veiculosSoltos;
    }
}