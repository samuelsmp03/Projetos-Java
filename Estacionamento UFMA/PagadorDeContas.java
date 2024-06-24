public class PagadorDeContas {
    private double caminhaoTax = 0.5;
    private double carroTax = 0.3;
    private double motoTax = 0.2;
    private double valor= 0.0;

    public double taxar(Veiculo veiculo){
        if( veiculo instanceof Caminhao){
            valor = veiculo.getMinutos() *caminhaoTax;
        }
        else if(veiculo instanceof Carro){
            valor = veiculo.getMinutos() *carroTax;
        }
        else if(veiculo instanceof Moto){
            valor = veiculo.getMinutos() * motoTax;
        }
        return valor;
    }
}
