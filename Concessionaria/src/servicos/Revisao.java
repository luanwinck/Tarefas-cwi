package servicos;

public class Revisao implements ServicosRealizados {
    private double valorDaRevisao;
    private double valorBase;
    private int percentualLucro;
    private final double ICMS = 0.13;

    public Revisao(double valorDaRevisao, double valorBase, int percentualLucro) {
        this.valorDaRevisao = valorDaRevisao;
        this.valorBase = valorBase;
        this.percentualLucro = percentualLucro;
    }

    @Override
    public double calcularValorBaseServico() {
        return valorDaRevisao;
    }

    @Override
    public double calcularValorTotalServico() {
        return valorBase + valorDaRevisao;
    }

    @Override
    public double calcularLucroTotal() {
        return calcularValorBaseServico() + calcularValorTotalImpostos() * ((double) percentualLucro / 100);
    }

    public double calcularValorTotalImpostos() {
        return calcularValorBaseServico() * ICMS;
    }
}
