public class Caminhao extends Veiculo {
    private int cargaMax;
    private float comprimento;
    private ClasseReserva reserva;

    public Caminhao(int minutos, float valor, String status, int cargaMax, float comprimento) {
        super(minutos, valor, status);
        this.cargaMax = cargaMax;
        this.comprimento = comprimento;
        this.reserva = new ClasseReserva("livre");
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
        if (this.getStatus().equals("reservado") || this.getStatus().equals("estacionado")) {
            this.setStatus("pago");
            stopTimer();
            return true;
        }
        return false;
    }

    public boolean reservar(int[][] matrizVagas) {
        long[] horario = new long[6];
        /*
        for (int i = 0; i < horario.length; i++) {
            horario[i] = Reader.lerLong();
        }
        */

        for (int i = 0; i < matrizVagas.length; i++) {
            for (int j = 0; j < matrizVagas[i].length; j++) {
                if (matrizVagas[i][j] == 0) {
                    matrizVagas[i][j] = 1;
                    startTimer();
                    this.setStatus("reservado");
                    reserva.setStatus("reservada");
                    //reserva.setHorario(horario);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean estacionar(int[][] matrizVagas) {
        if(super.estacionar(matrizVagas)){
            reserva = null;
            return true;
        }else{
            return false;
        }
    }

    public void verificarReserva() {
        reserva.passouDaHora();
        if (reserva.getStatus().equals("livre")) {
            this.setStatus("livre");
        }
    }
}