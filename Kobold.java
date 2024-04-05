import java.util.Random;

public class Kobold implements Personagem {
    private String nome = "Kobold";
    private int vida = 20;
    private int forca = 4;
    private int defesa = 2;
    private int agilidade = 4;
    private Random random = new Random();

     @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int calcularIniciativa() {
        return random.nextInt(11) + agilidade;
    }

    @Override
    public int calcularAtaque() {
        return random.nextInt(7) + agilidade + forca;
    }

    @Override
    public int calcularDefesa() {
        return random.nextInt(3) + defesa;
    }

    @Override
    public int calcularDano(int ataque, int defesa) {
        if (ataque > defesa) {
            return random.nextInt(3) + 2;
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
            vida = 0;
        }
    }

}