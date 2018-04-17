package Alvos;

public class Alvo {
    private int pontosDeVida;

    public Alvo(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public void receberAtaque(int poderDeAtaqueRecebido){
        pontosDeVida -= poderDeAtaqueRecebido;
    }

    public boolean destruido(){
        return pontosDeVida <= 0 ? true : false;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }
}
