package Corredores;

public class Peach extends Corredor {

    private int vezesQueJaAndou;
    private int casasQueAndaAMais;

    public Peach() {
        super(6);
        this.vezesQueJaAndou = 0;
        this.casasQueAndaAMais = 2;
    }

    @Override
    public void andar(){
        vezesQueJaAndou++;
        if (vezesQueJaAndou%3 == 0){
            super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista() + this.casasQueAndaAMais);
        }
        super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista() + super.getCasasQueAndaPorVez());
        super.verificarSeChegouAoFimDaCorrida();
    }


}
