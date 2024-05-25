public class Arqueiro extends Personagem{
    private int habArco, dest;

    public Arqueiro(String nome, int nivel, int forca, int hp, int habArco, int dest){
        super(nome, nivel, forca, hp);
        this.habArco=habArco;
        this.dest=dest;
    }

    public int getHabArco() {
        return habArco;
    }

    public void setHabArco(int habArco) {
        this.habArco = habArco;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    @Override
    public int atacar() {
        return super.forca * habArco * dest;
    }

    public boolean receber_dano(int dano) {
        if (dano > 0) {
            super.hp -= dano;
            verificaVida();
            return true;
        }
        return false;
    }

    public void mostrar_detalhes() {
        super.mostrar_detalhes();
        System.out.println("Habilidade com Arco: " + habArco +
                "\nDestreza: " + dest);
    }
}