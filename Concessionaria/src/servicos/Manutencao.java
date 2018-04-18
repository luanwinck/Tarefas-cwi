package servicos;

import produtos.Produto;

public class Manutencao extends Produto implements ServicosRealizados {

    private String nome;
    private double quantidadeDeHorasParaRealizarAManutencao;
    private double quantidadeDePessoasParaRealizarAManutencao;


    public Manutencao(double valorBase, int percentualLucro, String nome, double quantidadeDeHorasParaRealizarAManutencao, double quantidadeDePessoasParaRealizarAManutencao) {
        super(valorBase, percentualLucro);
        this.nome = nome;
        this.quantidadeDeHorasParaRealizarAManutencao = quantidadeDeHorasParaRealizarAManutencao;
        this.quantidadeDePessoasParaRealizarAManutencao = quantidadeDePessoasParaRealizarAManutencao;
    }

    @Override
    public double calcularValorBaseServico(){
        return quantidadeDePessoasParaRealizarAManutencao * quantidadeDeHorasParaRealizarAManutencao * super.getValorBase();
    }

    @Override
    public double calcularValorTotalServico(){
        return super.getValorBase() + calcularLucroTotal() + calcularValorTotalImpostos();
    }

    @Override
    public double calcularLucroTotal() {
        return calcularValorBaseServico() + calcularValorTotalImpostos() * super.getPercentualLucro();
    }

    public double calcularValorTotalImpostos() {
        return calcularValorBaseServico() * super.getICMS();
    }


}
