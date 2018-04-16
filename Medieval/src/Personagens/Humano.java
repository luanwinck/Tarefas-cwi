package Personagens;

public class Humano extends Pesronagem{
    public Humano(int poderDeAtaque, String nome, boolean possuiArco) {
        super(possuiArco ? poderDeAtaque*2 : poderDeAtaque, nome);
        this.possuiArco = possuiArco;
    }

    private boolean possuiArco;
}
