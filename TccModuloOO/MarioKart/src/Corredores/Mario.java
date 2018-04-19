package Corredores;

public class Mario extends Corredor {
    public Mario() {
        super(7);
    }

    @Override
    public void andar() {
        super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista() + super.getCasasQueAndaPorVez() + 1);
        if (super.getCasaQueEstouNaPista() > super.getPistaQueEstouCorrendo().getQuantidadesDeCasas()-1){
            super.getPistaQueEstouCorrendo().getPodium().subirNoPodium(this);
        }
    }
}
