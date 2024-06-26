public class Carro extends Veiculo {
    private String cor;
    private String marca;
    private String modelo;
    private ClasseReserva reserva;
    private Vagas vaga;
    private Carro carro;

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

    public boolean reservar(Carro carroNv) {
        long[] horario = new long[6];
        /*
        for (int i = 0; i < horario.length; i++) {
            horario[i] = Reader.lerLong();
        }
        */
        reserva = new ClasseReserva("reservado");
        //reserva.setHorario(horario);

        super.setStatus("reservado");
        Vagas vaga = new Vagas(1,carroNv);
        carro = carroNv;
        System.out.println("DENTRO DE CARRO RESERVAR  "+vaga.getStatus()+"  "+carro.getModelo());
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
            carro = ((Carro)vaga.getVeiculo());
            System.out.println("DENTRO DE CARRO ESTACIONAR IF "+vaga.getStatus()+"  "+carro.getModelo());
            System.out.println("DENTRO DE CARRO ESTACIONAR IF "+this.modelo+"  "+this.marca);
            startTimer();
            return true;
        }else{
            for(Vagas vaga: Sistema.getVagas()){
                if(vaga.getVeiculo() == this){
                    vaga.setStatus(0);
                    super.setStatus("estacionado");
                    startTimer();
                    carro = ((Carro)vaga.getVeiculo());
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