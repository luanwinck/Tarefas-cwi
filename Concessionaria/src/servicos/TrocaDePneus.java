package servicos;

import produtos.Pneu;

import java.util.LinkedList;
import java.util.List;

public class TrocaDePneus implements ServicosRealizados {

    List<Pneu> pneusASeremTrocados;
    private final double valorBaseDeMaoDeObraPorPneu = 30;
    private final double valorDeLucro = 20;
    private int quantidadeDePneus;
    private double valorBaseDosPneus;
    private double valorTotalDosPneus;

    public TrocaDePneus() {
        this.pneusASeremTrocados = new LinkedList<>();
    }

    public void realizarTrocaDePneus(List listaDePneus){
        pneusASeremTrocados.addAll(listaDePneus);
    }

    public int quantidadeDePneus(){
        quantidadeDePneus = 0;
        for (Pneu pneusTrocados : this.pneusASeremTrocados){
            this.quantidadeDePneus++;
        }
        return quantidadeDePneus;
    }

    public double calcularValorBaseDosPneus(){
        valorBaseDosPneus = 0;
        for (Pneu pneusTrocados : this.pneusASeremTrocados){
            this.valorBaseDosPneus += pneusTrocados.calcularValorBaseDosPneus();
        }
        return valorBaseDosPneus;
    }

    public double calculaValorTotalDosPneus(){
        valorTotalDosPneus = 0;
        for (Pneu pneusTrocados : this.pneusASeremTrocados){
            this.valorTotalDosPneus += pneusTrocados.calcularValorTotal();
        }
        return valorTotalDosPneus;
    }

    @Override
    public double calcularValorBaseServico() {
        return quantidadeDePneus() * valorBaseDeMaoDeObraPorPneu + calcularValorBaseDosPneus();
    }

    @Override
    public double calcularValorTotalServico() {
        return quantidadeDePneus() * (valorBaseDeMaoDeObraPorPneu + valorDeLucro) + calculaValorTotalDosPneus();
    }

    @Override
    public double calcularLucroTotal(){
        return quantidadeDePneus() * valorDeLucro;
    }
}
