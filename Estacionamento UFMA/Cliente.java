import java.util.*;
public class Cliente {
    private long celular;
    private String email;
    private ArrayList<Veiculo> veiculos;

    public Cliente(long celular, String email) {
        this.celular = celular;
        this.email = email;
    }

    public long getCelular() {
        return celular;
    }
    public void setCelular(long celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    /*
    @Override
    public boolean reservar(int[][] matrizVagas) {
    }
    */

}