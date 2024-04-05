import java.util.Random;
import java.util.Scanner;

public class MedievalBattle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        System.out.print("Digite seu nickname: ");
        String nickname = scanner.nextLine();
        System.out.print("Escolha sua classe (Guerreiro, Barbaro, Paladino): ");
        String heroClass = scanner.nextLine();

        
        Personagem heroi = criarHeroi(heroClass);

       
        Personagem monstro = escolherMonstro(scanner, random);

        int rodadas = 0;

        while (heroi.estaVivo() && monstro.estaVivo()) {
            rodadas++;
            System.out.println("Rodada " + rodadas);
            int iniciativaHeroi = heroi.calcularIniciativa();
            int iniciativaMonstro = monstro.calcularIniciativa();

            if (iniciativaHeroi > iniciativaMonstro) {
                heroi.atacar(monstro);
            } else if (iniciativaMonstro > iniciativaHeroi) {
                monstro.atacar(heroi);
            } else {
                System.out.println("Empate na iniciativa, ninguém ataca.");
            }
        }

        String resultado = heroi.estaVivo() ? "GANHOU" : "PERDEU";

       
        String logFileName = "temp/" + nickname + ".csv";
        
        System.out.println("Fim da batalha! Você " + resultado + " a batalha contra o " + monstro.getNome() + " em "
                + rodadas + " rodadas.");
    }

    
    private static Personagem criarHeroi(String heroClass) {
        switch (heroClass) {
            case "Guerreiro":
                return new Guerreiro();
            case "Barbaro":
                return new Barbaros();
            case "Paladino":
                return new Paladino();
            default:
                System.out.println("Classe de herói inválida. Escolha Guerreiro, Barbaro ou Paladino.");
                System.exit(1);
                return null;
        }
    }

    
    private static Personagem escolherMonstro(Scanner scanner, Random random) {
        System.out.println("Escolha um monstro para enfrentar (MortoVivo, Orc, Kobold): ");
        String escolha = scanner.nextLine();
        switch (escolha) {
            case "MortoVivo":
                return new MortoVivo();
            case "Orc":
                return new Orc();
            case "Kobold":
                return new Kobold();
            default:
                System.out.println("Monstro inválido. Escolha MortoVivo, Orc ou Kobold.");
                System.exit(1);
                return null;
        }
    }
}
