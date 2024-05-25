public class Main {
    public static void main(String[] args) {
        Guerreiro p1 = new Guerreiro("Aragorn", 1, 10, 100, 5, 20);
        Mago p2 = new Mago("Gandalf", 1, 10, 20, 5, 10);
        Arqueiro p3 = new Arqueiro("Legolas", 1, 3, 20, 5, 5);
        boolean work = true;
        int opc;
        String clss1 = retornaClasse(p1), clss2 = retornaClasse(p2),clss3 = retornaClasse(p3);
        while (work == true) {
            System.out.println("\nDigite uma opção" +
                    "\n1: Ver detalhes p1" +
                    "\n2: Ver detalhes p2" +
                    "\n3: Ver detalhes p3" +
                    "\n4: Realizar combate entre p1 e p2" +
                    "\n5: Realizar combate entre p1 e p3" +
                    "\n6: Realizar combate entre p2 e p3" +
                    "\n7: Fechar o programa");
            System.out.printf("\tdigite:");
            opc = Reader.lerInt();

            switch (opc) {
                case 1:
                    System.out.println("-=-==-=-==-=-=-=-==-=-=-=---=-=-=-=-=-=-=-=-");
                    System.out.println(clss1);
                    p1.mostrar_detalhes();
                    break;

                case 2:
                    System.out.println("-=-==-=-==-=-=-=-==-=-=-=---=-=-=-=-=-=-=-=-");
                    System.out.println(clss2);
                    p2.mostrar_detalhes();
                    break;

                case 3:
                    System.out.println("-=-==-=-==-=-=-=-==-=-=-=---=-=-=-=-=-=-=-=-");
                    System.out.println(clss3);
                    p3.mostrar_detalhes();
                    break;

                case 4:
                    Combate(p1, p2);
                    break;

                case 5:
                    Combate(p1, p3);
                    break;

                case 6:
                    Combate(p2, p3);
                    break;

                case 7:
                    System.out.println("Até mais!");
                    work = false;
                    break;

                default:
                    System.err.println("Digite uma opção válida!");
                    break;
            }
        }

    }

    public static void Combate(Personagem p1, Personagem p2) {
        String clss1 = retornaClasse(p1);
        String clss2 = retornaClasse(p2);
        if (p1.hp <= 0) {
            System.out.println("-=-==-=-==-=-=-=-==-=-=-=---=-=-=-=-=-=-=-=-");
            System.out.println("O personagem "+clss1+ " " +p1.getNome()+ " já morreu");
        }
        else if(p2.hp <= 0){
            System.out.println("-=-==-=-==-=-=-=-==-=-=-=---=-=-=-=-=-=-=-=-");
            System.out.println("O personagem "+ clss2+ " "+p2.getNome()+ " já morreu");
        }
        else {
            int dano1 = p1.atacar();
            int dano2 = p2.atacar();

            if (dano1 >= 0 && dano2 >= 0) {
                System.out.println("-=-==-=-==-=-=-=-==-=-=-=---=-=-=-=-=-=-=-=-");
                System.out.println("\nCOMBATE: " + clss1+" "+p1.getNome() + " X " + clss2+" "+p2.getNome());
                if (p1.getNivel() > p2.getNivel()) { // P1 ATACA
                    if (p2.receber_dano(dano1)) { // Verifica se o personagem recebeu dano
                        System.out.println("O personagem " +clss2+" "+ p2.getNome() + " tomou " + dano1 + " de dano!");
                    } else {
                        System.out.println("O personagem " + p2.getNome() + " esquivou!!!");
                    }
                    p1.nivel += 1;
                } else if (p1.getNivel() < p2.getNivel()) {// P2 ATACA

                    if (p1.receber_dano(dano2)) {
                        System.out.println("O personagem " +clss1+" "+ p1.getNome() + " tomou " + dano2 + " de dano!");
                    } else {
                        System.out.println("O personagem " + p1.getNome() + " esquivou!!!");
                    }
                    p2.nivel += 1;

                } else {// SORTEIO

                    float sorteio = (float)Math.random();

                    if (sorteio <= 0.5) {// P1 ATACA
                        if (p2.receber_dano(dano1)) {
                            System.out.println("O personagem " +clss2+" " + p2.getNome() + " tomou " + dano1 + " de dano!");
                        } else {
                            System.out.println("O personagem " + p2.getNome() + " esquivou!!!");
                        }
                        p1.nivel += 1;
                    } else {// P2 ATACA
                        if (p1.receber_dano(dano2)) {
                            System.out.println("O personagem " +clss1+" "+ p1.getNome() + " tomou " + dano2 + " de dano!");
                        } else {
                            System.out.println("O personagem " + p1.getNome() + " esquivou!!!");
                        }
                        p2.nivel += 1;
                    }
                }
                // Mostra resultado da luta
            }else{
                System.err.println("Digite atributos positivos!!!");
            }
        }
        System.out.println("-=-==-=-==-=-=-=-==-=-=-=---=-=-=-=-=-=-=-=-");
        System.out.println(clss1);
        p1.mostrar_detalhes();
        System.out.println("-=-==-=-==-=-=-=-==-=-=-=---=-=-=-=-=-=-=-=-");
        System.out.println(clss2);
        p2.mostrar_detalhes();
        System.out.println("-=-==-=-==-=-=-=-==-=-=-=---=-=-=-=-=-=-=-=-");
    }
    public static String retornaClasse(Personagem p1){
        if(p1 instanceof Guerreiro){
            return "Guerreiro";
        }
        else if(p1 instanceof Mago){
            return "Mago";
        }
        else{
            return "Arqueiro";
        }
    }
}