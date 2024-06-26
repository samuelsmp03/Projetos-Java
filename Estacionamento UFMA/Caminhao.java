public class Caminhao extends Veiculo {
    private int cargaMax;
    private float comprimento;
    private ClasseReserva reserva;
    private Vagas vaga;

    public Caminhao(int minutos, float valor, String status, int cargaMax, float comprimento) {
        super(minutos, valor, status);
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
        if (this.getStatus().equals("reservado") || this.getStatus().equals("estacionado")) {
            this.setStatus("pago");
            stopTimer();
            return true;
        }
        return false;
    }

    public boolean reservar(Caminhao caminhao) {
        long[] horario = new long[6];
        /*
        for (int i = 0; i < horario.length; i++) {
            horario[i] = Reader.lerLong();
        }
        */
        reserva = new ClasseReserva("reservado");
        //reserva.setHorario(horario);

        super.setStatus("reservado");
        Vagas vaga = new Vagas(1,caminhao);
        Sistema.addVaga(vaga);
        return true;
    }

    @Override
    public boolean estacionar() {
        //0 -> Estacionado ; 1 -> Reservado;
        if(reserva == null) {
            vaga = new Vagas(0, this);
            Sistema.addVaga(vaga);
            super.setStatus("estacionado");
            startTimer();
            return true;
        }else{
            for(Vagas vaga: Sistema.getVagas()){
                if(vaga.getVeiculo() == this){
                    vaga.setStatus(0);
                    super.setStatus("estacionado");
                    startTimer();
                    return true;
                }
            }
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