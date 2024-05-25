public class Mago extends Personagem {
    private int habMagica;
    private int esquiva;

    public Mago(String nome, int nivel, int forca, int hp, int habMagica, int esquiva) {
        super(nome, nivel, forca, hp);
        this.habMagica = habMagica;
        this.esquiva = esquiva;
    }

    public int getHabMagica() {
        return habMagica;
    }

    public void setHabMagica(int habMagica) {
        this.habMagica = habMagica;
    }

    public int getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(int esquiva) {
        this.esquiva = esquiva;
    }

    @Override

    public int atacar() {
        return super.forca * habMagica;
    }

    public boolean receber_dano(int dano) {
        if (dano > 0) {
            int chanceNaoEsquiva = (int) (Math.random() * 100 + 1);

            if (esquiva == 0 || chanceNaoEsquiva >= esquiva) {
                super.hp -= dano;
                verificaVida();
                return true;

            }
        }
        return false;
    }

    public void mostrar_detalhes() {
        super.mostrar_detalhes();
        System.out.println("Habilidade Mágica: " + habMagica +
                "\nEsquiva: " + esquiva);
    }
}