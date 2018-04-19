package Corredores;

public class Peach extends Corredor {

    private int vezesQueJaAndou;

    public Peach() {
        super(6);
        this.vezesQueJaAndou = 0;
    }

    @Override
    public void andar(){
        vezesQueJaAndou++;
        if (vezesQueJaAndou%3 == 0){
            super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista()+2);
        }
        super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista() + super.getCasasQueAndaPorVez());
        if (super.getCasaQueEstouNaPista() > super.getPistaQueEstouCorrendo().getQuantidadesDeCasas()-1){
            super.getPistaQueEstouCorrendo().getPodium().subirNoPodium(this);
        }
    }


}
