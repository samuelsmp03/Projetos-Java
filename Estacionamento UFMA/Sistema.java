import java.util.*;
public class Sistema {
    private float horario = 0.0f;

    private static final int senha = 12345;
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static int[][] vagasTerreo = {{0,0,0}, {0,0,0}};

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
                if (cliente.getEmail() == email && cliente.getCelular() == numero) {
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

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Sistema.clientes = clientes;
    }

    public static int[][] getVagas() {
        return vagasTerreo;
    }

    public void setVagasTerreo(int[][] vagasTerreo) {
        this.vagasTerreo = vagasTerreo;
    }
}