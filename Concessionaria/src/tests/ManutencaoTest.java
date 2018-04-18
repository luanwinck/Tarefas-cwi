package tests;

import org.junit.jupiter.api.Test;
import servicos.Manutencao;

import static org.junit.jupiter.api.Assertions.*;

class ManutencaoTest {
    @Test
    public void testarCalculoValorBaseServico(){
        Manutencao manutencao = new Manutencao(100,10,"manutencao",6,4);

        double calculoEsperado = 2400;
        double calculoObtido = manutencao.calcularValorBaseServico();

        assertEquals(calculoEsperado,calculoObtido);
    }

    @Test
    public void testarCalculoValorDeImpostos(){
        Manutencao manutencao = new Manutencao(100,10,"manutencao",6,4);

        double calculoEsperado = 312;
        double calculoObtido = manutencao.calcularValorTotalImpostos();

        assertEquals(calculoEsperado,calculoObtido);
    }

    @Test
    public void testarCalculoValorLucroTotal(){
        Manutencao manutencao = new Manutencao(100,10,"manutencao",6,4);

        double calculoEsperado = 271.2;
        double calculoObtido = manutencao.calcularLucroTotal();

        assertEquals(calculoEsperado,calculoObtido);
    }

    @Test
    public void testarCalculoValorTotal(){
        Manutencao manutencao = new Manutencao(100,10,"manutencao",6,4);

        double calculoEsperado = 683.2;
        double calculoObtido = manutencao.calcularValorTotalServico();

        assertEquals(calculoEsperado,calculoObtido);
    }

}