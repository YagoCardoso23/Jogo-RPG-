import java.util.Random;

public class MonstroAleatorio implements Personagem {
    private String nome = "Monstro Aleatório";
    private int vida = 80;
    private int forca = 8;
    private int agilidade = 3;

    @Override
    public String getNome() {
        return nome;
    }
 

    @Override
    public int calcularIniciativa() {
        Random random = new Random();
        return random.nextInt(11) + agilidade;
    }

    @Override
    public int calcularAtaque() {
        Random random = new Random();
        return random.nextInt(11) + agilidade + forca;
    }

    @Override
    public int calcularDefesa() {
        Random random = new Random();
        return random.nextInt(11) + agilidade;
    }

    @Override
    public int calcularDano(int ataque, int defesa) {
        if (ataque > defesa) {
            Random random = new Random();
            return random.nextInt(11) + forca;
        } else {
            return 0;
        }
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    @Override
    public void atacar(Personagem alvo) {
        int ataque = calcularAtaque();
        int defesa = alvo.calcularDefesa();
        int dano = calcularDano(ataque, defesa);
        alvo.levarDano(dano);
        System.out.println(nome + " atacou " + alvo.getNome() + " causando " + dano + " de dano.");
    }

    @Override
    public void levarDano(int dano) {
        vida -= dano;
        if (vida < 0) {
            vida = 0; // Certifique-se de que a vida não seja negativa
        }
    }
}
