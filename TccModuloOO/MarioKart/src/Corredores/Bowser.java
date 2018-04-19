package Corredores;

public class Bowser extends Corredor {

    private int vezesQueJaAndou;
    private int casasQueAndaAMais;
    private int casasQueAndaAMenos;

    public Bowser() {
        super(10);
        this.vezesQueJaAndou = 0;
        this.casasQueAndaAMais = 2;
        this.casasQueAndaAMenos = 2;
    }

    @Override
    public void andar(){
        vezesQueJaAndou++;
        if (vezesQueJaAndou < 3){
            super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista() + super.getCasasQueAndaPorVez() - casasQueAndaAMenos);
        }
        else{
            super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista() + super.getCasasQueAndaPorVez() + casasQueAndaAMais);

        }
        super.verificarSeChegouAoFimDaCorrida();
    }
}
