package Personagens;

public class Pesronagem {

    private int poderDeAtaque;
    private String nome;

    public Pesronagem(int poderDeAtaque, String nome) {
        this.poderDeAtaque = poderDeAtaque;
        this.nome = nome;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }

    public String getNome(){
        return nome;
    }

}
