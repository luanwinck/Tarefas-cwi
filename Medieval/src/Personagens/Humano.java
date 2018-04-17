package Personagens;

public class Humano extends Pesronagem{
    private boolean possuiArco;

    public Humano(int poderDeAtaque, String nome, boolean possuiArco) {
        super(possuiArco ? poderDeAtaque*2 : poderDeAtaque, nome);
        this.possuiArco = possuiArco;
    }
}
