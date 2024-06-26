public class Vagas {
    private static final String localizacao = "Piso";
    private int status;
    //0 -> Estacionada , 1-> Reservada , 2-> Pago, 3-> Reserva CANCELADA
    private Veiculo veiculo;

    public Vagas(int status, Veiculo veiculo) {
        this.status = status;
        this.veiculo = veiculo;
    }


    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo tipo) {
        this.veiculo = tipo;
    }
}