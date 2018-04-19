package Corredores;

public class Bowser extends Corredor {

    private int vezesQueJaAndou;

    public Bowser() {
        super(10);
        this.vezesQueJaAndou = 0;
    }

    @Override
    public void andar(){
        vezesQueJaAndou++;
        if (vezesQueJaAndou < 3){
            super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista() + super.getCasasQueAndaPorVez()-2);
        }
        else{
            super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista() + super.getCasasQueAndaPorVez()+2);

        }


        if (super.getCasaQueEstouNaPista() > super.getPistaQueEstouCorrendo().getQuantidadesDeCasas()-1) {
            super.getPistaQueEstouCorrendo().getPodium().subirNoPodium(this);
        }
    }
}
