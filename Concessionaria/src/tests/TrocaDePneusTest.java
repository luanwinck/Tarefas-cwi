package tests;

import org.junit.jupiter.api.Test;
import produtos.Pneu;
import servicos.TrocaDePneus;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TrocaDePneusTest {

    //mao de obra: 30,00
    //lucro: 20,00

    @Test
    public void testarCalcularValorBaseServico(){
        TrocaDePneus trocaDePneus = new TrocaDePneus();
        LinkedList pneusASeremTrocados = new LinkedList();
        Pneu pneu = new Pneu(200,10);
        Pneu pneu1 = new Pneu(200,10);

        pneusASeremTrocados.add(pneu);
        pneusASeremTrocados.add(pneu1);

        trocaDePneus.realizarTrocaDePneus(pneusASeremTrocados);

        double valorTotalImpostosEsperado = 512;
        double valorTotalImpostosRetornado = trocaDePneus.calcularValorBaseServico();

        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }
    @Test
    public void testarCalcularValorTotalServico(){
        TrocaDePneus trocaDePneus = new TrocaDePneus();
        LinkedList pneusASeremTrocados = new LinkedList();
        Pneu pneu = new Pneu(200,10);
        Pneu pneu2 = new Pneu(200,10);

        pneusASeremTrocados.add(pneu);
        pneusASeremTrocados.add(pneu2);

        trocaDePneus.realizarTrocaDePneus(pneusASeremTrocados);

        double valorTotalImpostosEsperado = 597.2;
        double valorTotalImpostosRetornado = trocaDePneus.calcularValorTotalServico();

        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }

    @Test
    public void testarCalcularValorTotalServicoCom4Pneus(){
        TrocaDePneus trocaDePneus = new TrocaDePneus();
        LinkedList pneusASeremTrocados = new LinkedList();
        Pneu pneu = new Pneu(200,10);
        Pneu pneu2 = new Pneu(200,10);
        Pneu pneu3 = new Pneu(300,10);
        Pneu pneu4 = new Pneu(300,10);

        pneusASeremTrocados.add(pneu);
        pneusASeremTrocados.add(pneu2);
        pneusASeremTrocados.add(pneu3);
        pneusASeremTrocados.add(pneu4);

        trocaDePneus.realizarTrocaDePneus(pneusASeremTrocados);

        double valorTotalImpostosEsperado = 1443;
        double valorTotalImpostosRetornado = trocaDePneus.calcularValorTotalServico();

        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }


}