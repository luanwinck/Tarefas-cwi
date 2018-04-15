package Armas;

import Inventario.Maleta;

public class ItemDaMaleta {

    private int[][] espacoOcupadoNaMaleta;
    private double peso;
    private int larguraOcupada;
    private int alturaOcupada;
    private int tamanhoOcupado;

    private Maleta MaletaAQuePerntece;




    public ItemDaMaleta(double peso, int larguraOcupada, int alturaOcupada) {

        this.peso = peso;
        this.espacoOcupadoNaMaleta = new int[larguraOcupada][alturaOcupada];
        this.tamanhoOcupado = larguraOcupada * alturaOcupada;
        this.alturaOcupada = alturaOcupada;
        this.larguraOcupada = larguraOcupada;

    }

    public int getLarguraOcupada() { return larguraOcupada; }

    public int getAlturaOcupada() { return alturaOcupada; }

    public int getTamanhoOcupado(){
        return tamanhoOcupado;
    }

    public double getPeso(){ return peso; }

    public void virarItem(){
        int aux = larguraOcupada;
        larguraOcupada = alturaOcupada;
        alturaOcupada = aux;
    }




    public void vincularAMaleta(Maleta maleta) {
        this.MaletaAQuePerntece = maleta;
    }

    public Maleta getMaletaDeItensAQuePertence() {
        return MaletaAQuePerntece;
    }
}
