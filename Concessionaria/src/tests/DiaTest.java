package tests;

import org.junit.jupiter.api.Test;
import produtos.Pneu;
import produtos.Produto;
import produtos.Veiculo;
import servicos.Manutencao;
import servicos.Revisao;
import servicos.TrocaDePneus;
import utilitario.Dia;


import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaTest {
    @Test
    public void testarCalcularValorEntradaTotalEntradaDeProdutosEEntradaDeServicos(){
        //Arrange
        Produto veiculo1 = new Veiculo(100, 1, 1, "vw", "gol", "chumbo");
        Produto veiculo2 = new Veiculo(1000, 1,1,"fiat","palio","prata");
        Produto veiculo3 = new Veiculo(10, 1,1,"vw","polo","branco");
        Revisao revisao = new Revisao(1000,10,2);
        Revisao revisao2 = new Revisao(1000,10,2);
        Dia dia = new Dia();

        dia.venderProduto(veiculo1);
        dia.venderProduto(veiculo2);
        dia.venderProduto(veiculo3);
        dia.realizarServico(revisao);
        dia.realizarServico(revisao2);


        double valorTotalDeEntradaDeServicosEsperado = 2020;
        double valorTotalDeEntradaDeServicosRetornado = dia.consultarTotalDeEntradaDeServicos();

        double valorTotalDeEntradaDeProdutosEsperado = 1392.79;
        double valorTotalDeEntradaDeProdutosRetornado = dia.consultarTotalDeEntradaDeProdutos();

        double valorTotalDeEntradaEsperado = 3412.79;
        double valorTotalDeEntradaRetornado = dia.consultarTotalDeEntrada();


        assertEquals(valorTotalDeEntradaDeServicosEsperado, valorTotalDeEntradaDeServicosRetornado);
        assertEquals(valorTotalDeEntradaDeProdutosEsperado, valorTotalDeEntradaDeProdutosRetornado);
        assertEquals(valorTotalDeEntradaEsperado, valorTotalDeEntradaRetornado);
    }

    @Test
    public void testarCalcularValorEntradaAdicionadoUmaTrocaDePneus(){
        //Arrange
        Dia dia = new Dia();

        Pneu pneu1 = new Pneu(200,10);
        Pneu pneu2 = new Pneu(200,10);
        TrocaDePneus trocaDePneus = new TrocaDePneus();
        LinkedList listDePneus = new LinkedList();

        listDePneus.add(pneu1);
        listDePneus.add(pneu2);

        trocaDePneus.realizarTrocaDePneus(listDePneus);

        dia.realizarServico(trocaDePneus);


        double valorTotalDeEntradaEsperado = 597.2;
        double valorTotalDeEntradaDeRetornado = dia.consultarTotalDeEntradaDeServicos();


        assertEquals(valorTotalDeEntradaEsperado, valorTotalDeEntradaDeRetornado);
    }

    @Test
    public void testarCalcularValorEntratadaDeLucroAdicionadoUmaTrocaDePneus(){
        //Arrange
        Dia dia = new Dia();

        Pneu pneu1 = new Pneu(200,10);
        Pneu pneu2 = new Pneu(200,10);
        TrocaDePneus trocaDePneus = new TrocaDePneus();
        LinkedList listDePneus = new LinkedList();

        listDePneus.add(pneu1);
        listDePneus.add(pneu2);

        trocaDePneus.realizarTrocaDePneus(listDePneus);

        dia.realizarServico(trocaDePneus);


        double valorTotalDeEntradaDeLucroEsperado = 40;
        double valorTotalDeEntradaDeLucroRetornado = dia.consultarTotalDeEntradaDeLucro();


        assertEquals(valorTotalDeEntradaDeLucroEsperado, valorTotalDeEntradaDeLucroRetornado);
    }

    @Test
    public void testarCalcularSomenteValorEntradaDeLucroDeProduto(){
        //Arrange
        Produto veiculo1 = new Veiculo(15000, 10, 1.6, "vw", "gol", "chumbo");
        Produto veiculo2 = new Veiculo(10000, 10,1,"fiat","palio","prata");
        Produto veiculo3 = new Veiculo(30000, 10,1.6,"vw","polo","branco");
        Revisao revisao = new Revisao(1000,10,2);
        Revisao revisao2 = new Revisao(1000,10,2);
        Dia dia = new Dia();

        dia.venderProduto(veiculo1);
        dia.venderProduto(veiculo2);
        dia.venderProduto(veiculo3);
        dia.realizarServico(revisao);
        dia.realizarServico(revisao2);

        double valorEntradaDeLucroDeProdutosEsperada = 7106.5;
        double valorEntradaDeLucroDeProdutoObtida = dia.consultarTotalDeEntradaDeDeLucroProdutos();

        assertEquals(valorEntradaDeLucroDeProdutosEsperada,valorEntradaDeLucroDeProdutoObtida);
    }

    @Test
    public void testarCalcularSomenteValorEntradaDeLucroDeServicos(){
        //Arrange
        Produto veiculo1 = new Veiculo(15000, 10, 1.6, "vw", "gol", "chumbo");
        Produto veiculo2 = new Veiculo(10000, 10,1,"fiat","palio","prata");
        Produto veiculo3 = new Veiculo(30000, 10,1.6,"vw","polo","branco");
        Revisao revisao = new Revisao(1000,10,2);
        Revisao revisao2 = new Revisao(1000,10,2);
        Dia dia = new Dia();

        dia.venderProduto(veiculo1);
        dia.venderProduto(veiculo2);
        dia.venderProduto(veiculo3);
        dia.realizarServico(revisao);
        dia.realizarServico(revisao2);

        double valorEntradaDeLucroDeServicosEsperada = 45.2;
        double valorEntradaDeLucroDeServicosObtida = dia.consultarTotalDeEntradaDeDeLucroServicos();

        assertEquals(valorEntradaDeLucroDeServicosEsperada,valorEntradaDeLucroDeServicosObtida);
    }

    @Test
    public void testarOrdenarProdutosDoMaiorParaOMenor(){
        //Arrange
        Produto veiculo1 = new Veiculo(15000, 10, 1, "vw", "gol", "chumbo");
        Produto veiculo2 = new Veiculo(10000, 10,1,"fiat","palio","prata");
        Produto veiculo3 = new Veiculo(30000, 10,1,"vw","polo","branco");
        Produto veiculo4 = new Veiculo(50000, 10,1,"vw","polo","branco");
        Dia dia = new Dia();
        LinkedList listaDeProdutosOrdenados = new LinkedList();

        dia.venderProduto(veiculo1);
        dia.venderProduto(veiculo2);
        dia.venderProduto(veiculo3);
        dia.venderProduto(veiculo4);

        listaDeProdutosOrdenados.add(veiculo4);
        listaDeProdutosOrdenados.add(veiculo3);
        listaDeProdutosOrdenados.add(veiculo1);
        listaDeProdutosOrdenados.add(veiculo2);

        List listaDeProdutosOrdenadaEsperada = listaDeProdutosOrdenados;
        List listaDeProdutosOrdenadaObtida = dia.ordenarProdutosDoMaiorValorTotalParaOMenorValorTotal();

        assertEquals(listaDeProdutosOrdenadaEsperada,listaDeProdutosOrdenadaObtida);
    }

    @Test
    public void testarOrdenarProdutosDoMenorParaOMaior(){
        //Arrange
        Produto veiculo1 = new Veiculo(15000, 10, 1, "vw", "gol", "chumbo");
        Produto veiculo2 = new Veiculo(10000, 10,1,"fiat","palio","prata");
        Produto veiculo3 = new Veiculo(30000, 10,1,"vw","polo","branco");
        Produto veiculo4 = new Veiculo(50000, 10,1,"vw","polo","branco");
        Dia dia = new Dia();
        LinkedList listaDeProdutosOrdenados = new LinkedList();

        dia.venderProduto(veiculo1);
        dia.venderProduto(veiculo2);
        dia.venderProduto(veiculo3);
        dia.venderProduto(veiculo4);

        listaDeProdutosOrdenados.add(veiculo2);
        listaDeProdutosOrdenados.add(veiculo1);
        listaDeProdutosOrdenados.add(veiculo3);
        listaDeProdutosOrdenados.add(veiculo4);

        List listaDeProdutosOrdenadaEsperada = listaDeProdutosOrdenados;
        List listaDeProdutosOrdenadaObtida = dia.ordenarProdutosDoMenorValorTotalParaOMaiorValorTotal();

        assertEquals(listaDeProdutosOrdenadaEsperada,listaDeProdutosOrdenadaObtida);
    }

    @Test
    public void testarRemoverUmProdutoEDepoisCalcularOValorTotalDeEntrada(){
        //Arrange
        Produto veiculo1 = new Veiculo(15000, 10, 1, "vw", "gol", "chumbo");
        Produto veiculo2 = new Veiculo(10000, 10,1,"fiat","palio","prata");
        Produto veiculo3 = new Veiculo(30000, 10,1,"vw","polo","branco");
        Produto veiculo4 = new Veiculo(50000, 10,1,"vw","polo","branco");
        Dia dia = new Dia();

        dia.venderProduto(veiculo1);
        dia.venderProduto(veiculo2);
        dia.venderProduto(veiculo3);
        dia.venderProduto(veiculo4);

        dia.removerProdutoDaListaDePordutosVendidos(veiculo4);

        double valorTotalDeEntradaEsperado = 75201.5;
        double valorTotalDeEntradaRetornado = dia.consultarTotalDeEntrada();

        assertEquals(valorTotalDeEntradaEsperado,valorTotalDeEntradaRetornado);
    }

    @Test
    public void testarRemoverUmServicoEDepoisCalcularOValorTotalDeEntrada(){
        //Arrange
        Manutencao manutencao = new Manutencao(150,10,"manutenção",
                2,2);
        Manutencao manutencao1 = new Manutencao(200,20,"manutenção",
                4,3);
        Revisao revisao = new Revisao(100,70,20);
        Dia dia = new Dia();

        dia.realizarServico(manutencao);
        dia.realizarServico(manutencao1);
        dia.realizarServico(revisao);

        dia.removerServicoDaListaDeServicosRealziados(manutencao);

        double valorTotalDeEntradaEsperado = 1224.4;
        double valorTotalDeEntradaRetornado = dia.consultarTotalDeEntrada();

        assertEquals(valorTotalDeEntradaEsperado,valorTotalDeEntradaRetornado);
    }


}
