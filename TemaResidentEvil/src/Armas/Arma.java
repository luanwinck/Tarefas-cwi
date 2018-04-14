package Armas;

import Inventario.Maleta;

public class Arma extends ItemDaMaleta {
    private int quantidadeDeMunicaoQueCabe;
    private int quantidadeDeTirosPorVez;

    public Arma(double peso, int quantidadeDeMunicaoQueCabe, int quantidadeDeTirosPorVez, int larguraOcupada, int alturaOcupada) {
        super(peso, larguraOcupada, alturaOcupada);
        this.quantidadeDeMunicaoQueCabe = quantidadeDeMunicaoQueCabe;
        this.quantidadeDeTirosPorVez = quantidadeDeTirosPorVez;
    }

}
