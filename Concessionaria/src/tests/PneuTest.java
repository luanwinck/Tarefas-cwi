package tests;

import org.junit.jupiter.api.Test;
import produtos.Pneu;


import static org.junit.jupiter.api.Assertions.*;

class PneuTest {
    @Test
    public void testarCalcularValorTotalImpostos(){
        //Arrange
        Pneu pneu = new Pneu(200,10);

        double valorTotalImpostosEsperado = 26;
        double valorTotalImpostosRetornado = pneu.calcularValorTotalImpostos();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }

    @Test
    public void testarCalcularValorBase(){
        //Arrange
        Pneu pneu = new Pneu(200,10);

        double valorTotalImpostosEsperado = 226;
        double valorTotalImpostosRetornado = pneu.calcularValorBaseDosPneus();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }

    @Test
    public void testarCalcularLucroTotal(){
        //Arrange
        Pneu pneu = new Pneu(200,10);

        double valorTotalImpostosEsperado = 22.6;
        double valorTotalImpostosRetornado = pneu.calcularLucroTotal();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }

    @Test
    public void testarCalcularValorTotal(){
        //Arrange
        Pneu pneu = new Pneu(200,10);

        double valorTotalImpostosEsperado = 248.6;
        double valorTotalImpostosRetornado = pneu.calcularValorTotal();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }

}