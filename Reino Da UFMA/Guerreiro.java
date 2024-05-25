public class Guerreiro extends Personagem {
    private int hab_combate;
    private int escudo;
    public Guerreiro(String nome, int nivel, int forca, int hp , int hab_combate,int escudo){
        super(nome,nivel,forca,hp);//Criando um guerreiro com o construtor de personagem
        this.hab_combate = hab_combate;
        this.escudo = escudo;
    }

    @Override //Definindo os métodos que Guerreiro herdou de Personagem

    public int atacar(){
        int dano = super.forca*hab_combate;
        return dano;
    }

    public boolean receber_dano(int dano){
        if(dano>0) { //Não passa dano negativo
            if (dano > escudo) {
                //Verifica se o escudo quebrou
                dano -= escudo;
                escudo = 0;
            } else {
                escudo -= dano;
                dano = 0;
            }
            super.hp -= dano;
            verificaVida();//Uso da função que faz o player não ficar com vida negativa
            return true;
        }
        return false;
    }
    public void mostrar_detalhes(){
        super.mostrar_detalhes();
        System.out.println("Habilidade de Combate: "+hab_combate+
                "\nEscudo: "+escudo);
    }

    //Setters e Getters

    public int getHab_combate() {
        return hab_combate;
    }

    public void setHab_combate(int hab_combate) {
        this.hab_combate = hab_combate;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }
}
