public class Moto extends Veiculo {
    private String marca;
    private int cilindradas;
    private Vagas vaga;

    public Moto(int segundos, float valor, String status, String marca, int cilindradas) {
        super(segundos, valor, status);
        this.marca = marca;
        this.cilindradas = cilindradas;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getCilindradas() {
        return cilindradas;
    }
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;

    }
    @Override
    public boolean estacionar() {
        //0 ->Estacionado , 1-> Reservado
        vaga = new Vagas(0, this);
        Sistema.addVaga(vaga);
        super.setStatus("estacionado");
        startTimer();
        return true;
    }

    @Override
    public boolean pagar() {
        if(this.getStatus().equals("estacionado")) {
            this.setStatus("pago");
            return true;
        } else {
            System.out.println("o veiculo não está estacionado");
            return false;
        }
    }

}