package Personagens;

public class Orc extends Pesronagem {
    private boolean possuiGarra;

    public Orc(int poderDeAtaque, String nome, boolean possuiGarra) {
        super(possuiGarra ? poderDeAtaque*5 : poderDeAtaque, nome);
        this.possuiGarra = possuiGarra;
    }

}
