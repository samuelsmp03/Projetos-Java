public abstract class Veiculo implements Taxa {
    protected int segundos;
    protected float valor;
    protected String status;

    public Veiculo(int segundos, float valor, String status){
        this.segundos = segundos;
        this.valor = valor;
        this.status = status;
    }

    public int getSegundos() {
        return segundos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}