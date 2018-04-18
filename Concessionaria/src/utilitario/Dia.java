package utilitario;

import produtos.Produto;
import servicos.Manutencao;
import servicos.ServicosRealizados;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Dia {
    public Dia() {
        this.produtosVendidos = new LinkedList<>();
        this.servicosRealizados = new LinkedList<>();

    }

    private List<Produto> produtosVendidos;
    private List<ServicosRealizados> servicosRealizados;
    private double valorTotalDeEntradaDeServicos;
    private double valorTotalDeEntradaDeProdutos;
    private double valorTotalDeEntradaDeLucroServicos;
    private double valorTotalDeEntradaDeLucroProdutos;


    public void venderProduto(Produto produto){
        produtosVendidos.add(produto);
    }

    public void realizarServico(ServicosRealizados servicosRealizados){
        this.servicosRealizados.add(servicosRealizados);
    }

    public void venderProdutosEmLote(List listaDeProdutos){
        produtosVendidos.addAll(listaDeProdutos);
    }

    public double consultarTotalDeEntrada(){
        return consultarTotalDeEntradaDeProdutos() + consultarTotalDeEntradaDeServicos();
    }

    public double consultarTotalDeEntradaDeLucro(){
        return consultarTotalDeEntradaDeDeLucroProdutos() + consultarTotalDeEntradaDeDeLucroServicos();
    }

    public double consultarTotalDeEntradaDeServicos(){
        valorTotalDeEntradaDeServicos = 0;
        for (ServicosRealizados servicosRealizados : this.servicosRealizados){
            valorTotalDeEntradaDeServicos += servicosRealizados.calcularValorTotalServico();
        }
        return valorTotalDeEntradaDeServicos;
    }

    public double consultarTotalDeEntradaDeProdutos(){
        valorTotalDeEntradaDeProdutos = 0;
        for (Produto produtosVendidos : this.produtosVendidos){
            valorTotalDeEntradaDeProdutos += produtosVendidos.calcularValorTotal();
        }
        return valorTotalDeEntradaDeProdutos;
    }

    public double consultarTotalDeEntradaDeDeLucroServicos(){
        valorTotalDeEntradaDeLucroServicos = 0;
        for (ServicosRealizados servicosRealizados : this.servicosRealizados){
            valorTotalDeEntradaDeLucroServicos += servicosRealizados.calcularLucroTotal();
        }
        return valorTotalDeEntradaDeLucroServicos;
    }

    public double consultarTotalDeEntradaDeDeLucroProdutos(){
        valorTotalDeEntradaDeLucroProdutos = 0;
        for (Produto produtosVendidos : this.produtosVendidos){
            valorTotalDeEntradaDeLucroProdutos += produtosVendidos.calcularLucroTotal();
        }
        return valorTotalDeEntradaDeLucroProdutos;
    }

    public void removerProdutoDaListaDePordutosVendidos(Produto produto){
        produtosVendidos.remove(produto);
    }

    public void removerServicoDaListaDeServicosRealziados(ServicosRealizados servicosRealizados){
        this.servicosRealizados.remove(servicosRealizados);
    }

    public List<Produto> ordenarProdutosDoMaiorValorTotalParaOMenorValorTotal() {
        Produto[] produtosOrdenadosDoMaiorParaOMenor = new Produto[produtosVendidos.size()];
        produtosOrdenadosDoMaiorParaOMenor = produtosVendidos.toArray(produtosOrdenadosDoMaiorParaOMenor);

        int numeroDeProdutos = produtosOrdenadosDoMaiorParaOMenor.length;

        for (int i = 0; i < numeroDeProdutos; i++) {
            for (int j = 0; j < numeroDeProdutos - 1; j++) {
                Produto produtoA = produtosOrdenadosDoMaiorParaOMenor[j];
                Produto produtoB = produtosOrdenadosDoMaiorParaOMenor[j + 1];

                if (produtoA.calcularValorTotal() < produtoB.calcularValorTotal()) {
                    produtosOrdenadosDoMaiorParaOMenor[j] = produtoB;
                    produtosOrdenadosDoMaiorParaOMenor[j + 1] = produtoA;
                }
            }
        }

        return Arrays.asList(produtosOrdenadosDoMaiorParaOMenor);
    }

    public List<Produto> ordenarProdutosDoMenorValorTotalParaOMaiorValorTotal() {
        Produto[] produtosOrdenadosDoMaiorParaOMenor = new Produto[produtosVendidos.size()];
        produtosOrdenadosDoMaiorParaOMenor = produtosVendidos.toArray(produtosOrdenadosDoMaiorParaOMenor);

        int numeroDeProdutos = produtosOrdenadosDoMaiorParaOMenor.length;

        for (int i = 0; i < numeroDeProdutos; i++) {
            for (int j = 0; j < numeroDeProdutos - 1; j++) {
                Produto produtoA = produtosOrdenadosDoMaiorParaOMenor[j];
                Produto produtoB = produtosOrdenadosDoMaiorParaOMenor[j + 1];

                if (produtoA.calcularValorTotal() > produtoB.calcularValorTotal()) {
                    produtosOrdenadosDoMaiorParaOMenor[j] = produtoB;
                    produtosOrdenadosDoMaiorParaOMenor[j + 1] = produtoA;
                }
            }
        }

        return Arrays.asList(produtosOrdenadosDoMaiorParaOMenor);
    }
}
