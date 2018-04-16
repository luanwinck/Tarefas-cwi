package Testes;

import Personagens.Orc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PesronagemTest {
    @Test
    public void TestePoderDosPersonagens(){
        Orc orc = new Orc(10,"orc",false);

        int valorRecebido= orc.getPoderDeAtaque();
        int valorEsperado= 10;

        assertEquals(valorEsperado,valorRecebido);
    }

}