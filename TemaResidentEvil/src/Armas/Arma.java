package Armas;

public class Arma extends ItemDaMaleta {
    private int quantidadeDeMunicaoQueCabe;
    private int quantidadeDeTirosPorVez;
    private int quantidadeDeMunicaoNaArma;

    public Arma(double peso, int quantidadeDeMunicaoQueCabe, int quantidadeDeTirosPorVez, int larguraOcupada, int alturaOcupada) {
        super(peso, larguraOcupada, alturaOcupada);
        this.quantidadeDeMunicaoQueCabe = quantidadeDeMunicaoQueCabe;
        this.quantidadeDeTirosPorVez = quantidadeDeTirosPorVez;
        this.quantidadeDeMunicaoNaArma = quantidadeDeMunicaoQueCabe;
    }

    public void atirar(){
        quantidadeDeMunicaoNaArma = quantidadeDeMunicaoQueCabe - quantidadeDeTirosPorVez;
        if (quantidadeDeMunicaoNaArma < 0){
            quantidadeDeMunicaoNaArma = 0;
        }
    }

    public void recarregar(Municao municao){
        municao.setQuantidadeDeMunicaoRestante(quantidadeDeMunicaoQueCabe - quantidadeDeMunicaoNaArma);
        quantidadeDeMunicaoNaArma = quantidadeDeMunicaoQueCabe;
    }

}
