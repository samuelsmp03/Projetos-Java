public class Print {
    public static void verificaBool(boolean type){
        if(type){
            System.out.println("Operação realizada com sucesso!");
        }else{
            System.err.println("Operação mal sucedida!!!");
        }
    }
    public static void verificaInt(int num){
        if (num > -1){
            System.out.println(num);
        }else{
            System.err.println("Senha Incorreta!!!");
        }
    }
    public static void verificaFloat(float num){
        if (num > -1.0){
            System.out.println(num);
        }else{
            System.err.println("Senha incorreta!!!");
        }
    }
}
