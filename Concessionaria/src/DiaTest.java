import org.junit.jupiter.api.Test;
import produtos.Pneu;
import produtos.Produto;
import produtos.Veiculo;
import servicos.Revisao;
import servicos.TrocaDePneus;


import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaTest {
    @Test
    public void testarCalcularValorEntratadaTotalEntradaDeProdutosEEntradaDeServicos(){
        //Arrange
        Produto veiculo1 = new Veiculo(100, 1, 1, "vw", "gol", "chumbo");
        Produto veiculo2 = new Veiculo(1000, 1,1,"vw","gol","chumbo");
        Produto veiculo3 = new Veiculo(10, 1,1,"vw","gol","chumbo");
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
    public void testarCalcularValorEntratadaAdicionadoUmaTrocaDePneus(){
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


        double valorTotalDeEntradaDeServicosEsperado = 2020;
        double valorTotalDeEntradaDeServicosRetornado = dia.consultarTotalDeEntradaDeServicos();


        assertEquals(valorTotalDeEntradaDeServicosEsperado, valorTotalDeEntradaDeServicosRetornado);
    }
}
