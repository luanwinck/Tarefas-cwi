package Armas;

public class Municao extends ItemDaMaleta{
    private int quantidadeDeMunicaoRestante;

    public Municao(double peso, int quantidadeDeMunicaoRestante, int larguraOcupada, int alturaOcupada) {
        super(peso, larguraOcupada, alturaOcupada);
        this.quantidadeDeMunicaoRestante = quantidadeDeMunicaoRestante;
    }

    public void setQuantidadeDeMunicaoRestante(int quantidadeDeMunicaoUsada){
        this.quantidadeDeMunicaoRestante -= quantidadeDeMunicaoUsada;
        if (quantidadeDeMunicaoRestante <= 0){
            this.removerMunicaoDaMaleta();
        }
    }

    public void removerMunicaoDaMaleta(){
        this.getMaletaDeItensAQuePertence().removerItem(this);
    }
}
