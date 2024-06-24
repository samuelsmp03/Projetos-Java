public class Carro extends Veiculo {
    private String cor;
    private String marca;
    private String modelo;

    public Carro(int segundos, float valor, String status, String cor, String marca, String modelo) {
        super(segundos, valor, status);
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
        if(this.getStatus().equals("estacionado")) {
            this.setStatus("livre");
            return true;
        } else {
            //System.out.println("o veiculo não está estacionado");
            return false;
        }
    }

    public boolean reservar(int[][] matrizVagas) {
        for (int i = 0; i < matrizVagas.length; i++) {
            for (int j = 0; j < matrizVagas[i].length; j++) {
                if (matrizVagas[i][j] == 0) {
                    matrizVagas[i][j] = 1;
                    this.setStatus("reservado");
                    return true;
                }
            }
        }
        //System.out.println("não há vagas disponiveis");
        return false;
    }
}