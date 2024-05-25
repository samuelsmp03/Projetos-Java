public abstract class Personagem implements MecanicaDano{
//A interface "MecanicaDano" possui os métodos abstratos usados

    protected String nome;
    protected int nivel;
    protected int forca;
    protected int hp;

    public Personagem(String nome, int nivel, int forca, int hp){ //Construtor
        this.nome = nome;
        this.nivel = nivel;
        this.forca = forca;
        this.hp = hp;
    }


    public void mostrar_detalhes(){ //Será utilizada nas sub-classes
        System.out.println("Nome: "+ nome +
                "\nNível: "+ nivel+
                "\nForça: " +forca+
                "\nHP: "+hp);
    }

    public void verificaVida(){ //Função para o player não ficar com vida negativa
        if(this.hp<0){
            this.hp = 0;
        }
    }

    //Setters e Getters

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public int getNivel(){
        return this.nivel;
    }

    public void setForca(int forca){
        this.forca = forca;
    }

    public int getForca(){
        return this.forca;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public int getHP(){
        return hp;
    }

}
