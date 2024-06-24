public class Gerenciador {
    public int gerarConta(Veiculo veiculo){
        if (veiculo.getStatus().equals("estacionado")) {
            veiculo.setValor(veiculo.getSegundos() * 0.005f);
            return Math.round(veiculo.getValor());
        }
        return 0;
    }
    public boolean pagarConta(Veiculo veiculo, String metodo) {
        if (veiculo.getStatus().equals("estacionado")) {
            veiculo.setStatus("pago");
            return true;
        } else {
            System.out.println("conta não pode ser paga porque o veiculo não está estacionado");
            return false;
        }
    }

    //public arquivo emitirRecibo(){}
}