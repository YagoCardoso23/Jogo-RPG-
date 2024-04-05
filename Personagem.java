
public interface Personagem {
    String getNome();
    int calcularIniciativa();
    int calcularAtaque();
    int calcularDefesa();
    int calcularDano(int ataque, int defesa);
    boolean estaVivo();
    void atacar(Personagem alvo);
    void levarDano(int dano);
   
}
