import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClasseReserva {
    private String status;
    private long[] horaAtualA = new long[6];
    private long[] horaMarcadaA = new long[6];
    private long horaAtual;
    private long horaMarcada;

    public ClasseReserva(String status) {
        this.status = status;
        this.horaMarcadaA = new long[6];
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHorario() {
        String horario = Reader.lerString();
        for (int i = 0; i < 6; i++) {
            horaMarcadaA[i] = Character.getNumericValue(horario.charAt(i));
        }
    }

    private long[] getHoraAtual() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String formattedNow = now.format(formatter);
        long[] currentTimeArray = new long[formattedNow.length()];
        for (int i = 0; i < formattedNow.length(); i++) {
            currentTimeArray[i] = Long.parseLong(String.valueOf(formattedNow.charAt(i)));
        }
        return currentTimeArray;
    }

    public void passouDaHora() {
        ArrayPraNumero converter = new ArrayPraNumero();
        horaAtualA = getHoraAtual();
        horaAtual = converter.converteArrayPraNumero(horaAtualA);
        horaMarcada = converter.converteArrayPraNumero(horaMarcadaA);
        if (status.equals("reservada") && horaMarcada > horaAtual + 1500) { // 15 min de tolerancia
            status = "livre";
        }
    }
}