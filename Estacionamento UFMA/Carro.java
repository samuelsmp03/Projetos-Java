public class Carro extends Veiculo {
    private String cor;
    private String marca;
    private String modelo;

    public Carro(int minutos, float valor, String status, String cor, String marca, String modelo) {
        super(minutos, valor, status);
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean pagar() {
        if (this.getStatus().equals("reservado") || this.getStatus().equals("estacionado")) {
            this.setStatus("pago");
            stopTimer();
            return true;
        }
        return false;
    }

    public boolean reservar(int[][] matrizVagas) {
        for (int i = 0; i < matrizVagas.length; i++) {
            for (int j = 0; j < matrizVagas[i].length; j++) {
                if (matrizVagas[i][j] == 0) {
                    matrizVagas[i][j] = 1;
                    startTimer();
                    this.setStatus("reservado");
                    return true;
                }
            }
        }
        return false;
    }

    public void estacionar() {
        super.estacionar();
    }
}