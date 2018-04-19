package Testes;

import Corredores.Bowser;
import Corredores.Luigi;
import Corredores.Mario;
import Corredores.Peach;
import Pistas.DonutPlains;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorredorTest {
    @Test
    public void testesAndarPeach(){
        DonutPlains donutPlains = new DonutPlains();
        Peach peach = new Peach();

        donutPlains.adicionarCorredor(peach);

        peach.andar();
        assertEquals(3,peach.getCasaQueEstouNaPista());

        peach.andar();
        assertEquals(6,peach.getCasaQueEstouNaPista());

        peach.andar();
        assertEquals(11,peach.getCasaQueEstouNaPista());

        peach.andar();
        assertEquals(14,peach.getCasaQueEstouNaPista());
    }

    @Test
    public void testesAndarBowser(){
        DonutPlains donutPlains = new DonutPlains();
        Bowser bowser = new Bowser();

        donutPlains.adicionarCorredor(bowser);

        bowser.andar();
        assertEquals(1,bowser.getCasaQueEstouNaPista());

        bowser.andar();
        assertEquals(2,bowser.getCasaQueEstouNaPista());

        bowser.andar();
        assertEquals(7,bowser.getCasaQueEstouNaPista());

        bowser.andar();
        assertEquals(12,bowser.getCasaQueEstouNaPista());
    }

    @Test
    public void testesAndarMario(){
        DonutPlains donutPlains = new DonutPlains();
        Mario mario = new Mario();

        donutPlains.adicionarCorredor(mario);

        mario.andar();
        assertEquals(4,mario.getCasaQueEstouNaPista());

        mario.andar();
        assertEquals(8,mario.getCasaQueEstouNaPista());

        mario.andar();
        assertEquals(12,mario.getCasaQueEstouNaPista());

        mario.andar();
        assertEquals(16,mario.getCasaQueEstouNaPista());
    }

    @Test
    public void testesAndarLuigi(){
        DonutPlains donutPlains = new DonutPlains();
        Luigi luigi = new Luigi();

        donutPlains.adicionarCorredor(luigi);

        luigi.andar();
        assertEquals(3,luigi.getCasaQueEstouNaPista());

        luigi.andar();
        assertEquals(6,luigi.getCasaQueEstouNaPista());

        luigi.andar();
        assertEquals(9,luigi.getCasaQueEstouNaPista());

        luigi.andar();
        assertEquals(12,luigi.getCasaQueEstouNaPista());
    }



}