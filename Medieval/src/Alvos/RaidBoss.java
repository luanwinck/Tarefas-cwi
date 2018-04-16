package Alvos;

public class RaidBoss extends Alvo {
    private String nome;
    private int pontosDeDefesa;

    public RaidBoss(int pontosDeVida, String nome, int pontosDeDefesa) {
        super(pontosDeVida);
        this.nome = nome;
        this.pontosDeDefesa = pontosDeDefesa;
    }

    @Override
    public void receberAtaque(int poderDeAtaqueRecebido) {
        if (pontosDeDefesa > 0){
            pontosDeDefesa -= poderDeAtaqueRecebido;
        }
        else{
            setPontosDeVida(getPontosDeVida() - poderDeAtaqueRecebido);
        }
    }
}
