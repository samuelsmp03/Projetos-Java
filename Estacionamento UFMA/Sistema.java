import java.util.*;
public class Sistema {
    private float horario;
    private ArrayList<Cliente> clientes;
    private int[][] vagasTerreo;

    public Sistema(float horario,ArrayList<Cliente>) {
        this.horario = horario;
    }

    public float getHorario() {
        return horario;
    }
    public void setHorario(float horario) {
        this.horario = horario;
    }
}