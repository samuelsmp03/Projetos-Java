public class Caminhao extends Veiculo {
    private int cargaMax;
    private float comprimento;

    public Caminhao(int segundos, float valor, String status,int cargaMax, float comprimento) {
        super(segundos, valor, status);
        this.cargaMax = cargaMax;
        this.comprimento = comprimento;
    }

    public int getCargaMax() {
        return cargaMax;
    }
    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }
    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
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
        System.out.println("não há vagas disponiveis");
        return false;
    }
}