import java.util.*;
public class Sistema {
    private float horario;

    private static final int senha = 12345;
    static private ArrayList<Cliente> clientes;
    private int[][] vagasTerreo;

    public Sistema(float horario,ArrayList<Cliente> clientes,int[][] vagas) {
        this.horario = horario;
        this.clientes = clientes;
        this.vagasTerreo = vagas;
    }
    public static boolean verificaSenha(int teste){
        if(teste == senha){
            return true;
        }
        return false;
    }
    public static Cliente procuraCliente(String email,long numero){
        for (Cliente cliente : clientes){
            if(cliente.getEmail() == email && cliente.getCelular() == numero){
                return cliente;
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
}