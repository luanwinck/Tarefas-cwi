package Armas;

public class MunicaoTresOitao extends Municao{
    public MunicaoTresOitao() {

        super(0.2, 20,2,1);
    }

    @Override
    public void removerMunicaoDaMaleta(){
        this.getMaletaDeItensAQuePertence().removerItem(this);
    }

}
