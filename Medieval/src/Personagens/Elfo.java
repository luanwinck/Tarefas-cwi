package Personagens;

public class Elfo extends Pesronagem {
    public Elfo(int poderDeAtaque, String nome, int poderMagico) {
        super(poderDeAtaque + poderMagico, nome);
        this.poderMagico = poderMagico;
    }

    private int poderMagico;

}
