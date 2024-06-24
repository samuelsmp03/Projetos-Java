public class Vagas {
    private String localizacao;
    private int status;
    private Veiculo tipo;

    public Vagas(String localizacao, int status, Veiculo tipo) {
        this.localizacao = localizacao;
        this.status = status;
        this.tipo = tipo;
    }



    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Veiculo getTipo() {
        return tipo;
    }
    public void setTipo(Veiculo tipo) {
        this.tipo = tipo;
    }
}