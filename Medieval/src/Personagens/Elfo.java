package Personagens;

public class Elfo extends Pesronagem {
    private int poderMagico;

    public Elfo(int poderDeAtaque, String nome, int poderMagico) {
        super(poderDeAtaque + poderMagico, nome);
        this.poderMagico = poderMagico;
    }
}
