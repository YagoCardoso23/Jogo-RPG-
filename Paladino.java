import java.util.Random;

public class Paladino implements Personagem {
    private String nome = "Paladino";
    private int vida = 15;
    private int forca = 2;
    private int defesa = 5;
    private int agilidade = 1;
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
        return random.nextInt(3) + agilidade + forca;
    }

    @Override
    public int calcularDefesa() {
        return random.nextInt(7) + defesa;
    }

    @Override
    public int calcularDano(int ataque, int defesa) {
        if (ataque > defesa) {
            return random.nextInt(4) + 1;
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
