package tests;

import org.junit.jupiter.api.Test;
import servicos.Revisao;

import static org.junit.jupiter.api.Assertions.*;

class RevisaoTest {
    @Test
    public void testarCalculoValorBaseServico(){
        Revisao revisao = new Revisao(100,50,10);

        double calculoEsperado = 100;
        double calculoObtido = revisao.calcularValorBaseServico();

        assertEquals(calculoEsperado,calculoObtido);
    }

    @Test
    public void testarCalculoValorTotalServico(){
        Revisao revisao = new Revisao(100,50,10);

        double calculoEsperado = 150;
        double calculoObtido = revisao.calcularValorTotalServico();

        assertEquals(calculoEsperado,calculoObtido);
    }

    @Test void testarCalculoLucroTotal(){
        Revisao revisao = new Revisao(100,50,10);

        double calculoEsperado = 11.3;
        double calculoObtido = revisao.calcularLucroTotal();

        assertEquals(calculoEsperado,calculoObtido);
    }



}