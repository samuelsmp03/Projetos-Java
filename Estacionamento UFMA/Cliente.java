import java.util.*;

public class Cliente implements Reserva {
    private long celular;
    private String email;
    private ArrayList<Veiculo> veiculos;

    public Cliente(long celular, String email) {
        this.celular = celular;
        this.email = email;
        this.veiculos = new ArrayList<Veiculo>();
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

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    @Override
    public boolean reservar(){
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Carro) {
                Carro carro = (Carro) veiculo;
                if (carro.reservar(carro)) {
                    return true;
                }
            } else if (veiculo instanceof Caminhao) {
                Caminhao caminhao = (Caminhao) veiculo;
                if (caminhao.reservar(caminhao)) {
                    return true;
                }
            }
        }
        return false;
    }
}