
public class Conta {
    private int numero;
    private float saldo = 0.0f;
    private int senha;

    public boolean depositar(float valor){
        if(valor > 0){
            saldo += valor;
            return true;
        }
        return false;
    }
    public boolean sacar(float valor, int senha){
        if(senha == this.senha){
            if(saldo >= valor ){
                saldo -= valor;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public float verificarSaldo(int senha){
        if(senha == this.senha){
            return saldo;
        }else{
            return -1.0f;
        }
    }

    public int getNumero(){
        return numero;
    }
    public int getSenha() {
        return senha;
    }
    public float getSaldo(){
        return saldo;
    }

    public Conta(int num,int senha) {
        this.numero = num;
        this.saldo = 0.0f;
        this.senha = senha;
    }
}
