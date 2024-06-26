public class ArrayPraNumero {
    public long converteArrayPraNumero(long[] numeros) {
        long numero = 0;
        for (long digito : numeros) {
            numero = numero * 10 + digito;
        }
        return numero;
    }
}