import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class Veiculo implements Taxa {
    protected int minutos;
    protected float valor;
    protected String status;
    private ScheduledExecutorService scheduler;

    public Veiculo(int segundos, float valor, String status){
        this.minutos = segundos;
        this.valor = valor;
        this.status = status;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public int getSegundos() {
        return minutos;
    }
    public void setSegundos(int minutos) {
        this.minutos = minutos;
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

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}