package Armas;

public class MunicaoCalibre12 extends Municao {
    public MunicaoCalibre12() {
        super(0.4, 8,2,1);
    }

    @Override
    public void removerMunicaoDaMaleta(){
        this.getMaletaDeItensAQuePertence().removerItem(this);
    }
}
