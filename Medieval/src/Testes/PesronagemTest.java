package Testes;

import Personagens.Elfo;
import Personagens.Humano;
import Personagens.Orc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PesronagemTest {
    @Test
    public void TestePoderDoOrcSemAGarra(){
        Orc orc = new Orc(10,"orc",false);

        int valorRecebido= orc.getPoderDeAtaque();
        int valorEsperado= 10;

        assertEquals(valorEsperado,valorRecebido);
    }
    @Test
    public void TestePoderDoOrcComAGarra(){
        Orc orc = new Orc(10,"orc",true);

        int valorRecebido= orc.getPoderDeAtaque();
        int valorEsperado= 50;

        assertEquals(valorEsperado,valorRecebido);
    }
    @Test
    public void TestePoderDoHumanoSemOArco(){
        Humano humano = new Humano(10,"humano",false);

        int valorRecebido= humano.getPoderDeAtaque();
        int valorEsperado= 10;

        assertEquals(valorEsperado,valorRecebido);
    }
    @Test
    public void TestePoderDoHumanoComOArco(){
        Humano humano = new Humano(10,"humano",true);

        int valorRecebido= humano.getPoderDeAtaque();
        int valorEsperado= 20;

        assertEquals(valorEsperado,valorRecebido);
    }
    @Test
    public void TestePoderDoElfo(){
        Elfo elfo = new Elfo(15,"elfo",20);

        int valorRecebido= elfo.getPoderDeAtaque();
        int valorEsperado= 35;

        assertEquals(valorEsperado,valorRecebido);
    }

}