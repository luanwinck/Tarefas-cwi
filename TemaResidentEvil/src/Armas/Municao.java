package Armas;

import Inventario.Maleta;

public class Municao extends ItemDaMaleta{
    private int quantidadeDeMunicaoRestante;

    public Municao(double peso, int quantidadeDeMunicaoRestante, int larguraOcupada, int alturaOcupada) {
        super(peso, larguraOcupada, alturaOcupada);
        this.quantidadeDeMunicaoRestante = quantidadeDeMunicaoRestante;
    }
}
