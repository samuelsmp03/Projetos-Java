import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class Veiculo implements Taxa {
    protected int minutos;
    protected float valor;
    protected String status;
    private ScheduledExecutorService scheduler;

    public Veiculo(int minutos, float valor, String status){
        this.minutos = minutos;
        this.valor = valor;
        this.status = status;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
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

    public void startTimer() {
        scheduler.scheduleAtFixedRate(() -> {
            this.minutos++;
            this.valor = this.minutos * 0.3f;
        }, 1, 1, TimeUnit.MINUTES);
    }

    public void stopTimer() {
        scheduler.shutdown();
    }

    public boolean estacionar(int[][] matrizVagas) {
        for (int i = 0; i < matrizVagas.length; i++) {
            for (int j = 0; j < matrizVagas[i].length; j++) {
                if (matrizVagas[i][j] == 0) {
                    matrizVagas[i][j] = 1;
                    startTimer();
                    this.setStatus("estacionado");
                    return true;
                }
            }
        }
        return false;
    }
}
