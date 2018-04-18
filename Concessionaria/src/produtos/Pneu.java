package produtos;

public class Pneu extends Produto{
    public Pneu(double valorBase, int percentualLucro) {
        super(valorBase, percentualLucro);
    }

    public double calcularValorBaseDosPneus(){
        return getValorBase() + calcularValorTotalImpostos();
    }
}
