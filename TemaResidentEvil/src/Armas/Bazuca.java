package Armas;

public class Bazuca extends Arma {
    public Bazuca() {
        super(15, 1, 1,4,10);
    }

    public void atirar(Municao municao){
        this.getMaletaDeItensAQuePertence().removerItem(municao);
    }
}
