package Corredores;

public class Mario extends Corredor {
    private int casasQueAndaAMais;

    public Mario() {
        super(7);
        this.casasQueAndaAMais = 1;
    }

    @Override
    public void andar() {
        super.setCasaQueEstouNaPista(super.getCasaQueEstouNaPista() + super.getCasasQueAndaPorVez() + this.casasQueAndaAMais);
        super.verificarSeChegouAoFimDaCorrida();
    }
}
