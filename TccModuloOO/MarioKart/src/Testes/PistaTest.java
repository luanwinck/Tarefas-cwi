package Testes;

import Corredores.*;
import Erros.AlvoInvalidoException;
import Erros.ItemINaoEquipadoException;
import Itens.Baletao;
import Itens.CascoVerde;
import Itens.Cogumelo;
import Pistas.DonutPlains;
import Pistas.LugarNoPodium;
import Pistas.Pista;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PistaTest {
    @Test
    public void testesPista(){
        DonutPlains donutPlains = new DonutPlains();
        Luigi luigi = new Luigi();
        Luigi luigi2 = new Luigi();
        Luigi luigi3 = new Luigi();

        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(luigi2);
        donutPlains.adicionarCorredor(luigi3);

        for (int i = 0; i < 7; i++) {
            luigi.andar();
        }

        for (int i = 0; i < 15; i++) {
            luigi3.andar();
        }

        for (int i = 0; i < 15; i++) {
            luigi2.andar();
        }


        assertEquals(luigi,donutPlains.getPodium().getCorredorNaPosicao(LugarNoPodium.PRIMEIRO_LUGAR));
        assertEquals(luigi3,donutPlains.getPodium().getCorredorNaPosicao(LugarNoPodium.SEGUNDO_LUGAR));
        assertEquals(luigi2,donutPlains.getPodium().getCorredorNaPosicao(LugarNoPodium.TERCEIRO_LUGAR));
    }

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
    public void testarUsoDoCogumelo() throws ItemINaoEquipadoException {
        DonutPlains donutPlains = new DonutPlains();
        Luigi luigi = new Luigi();
        Cogumelo cogumelo = new Cogumelo();

        donutPlains.adicionarCorredor(luigi);

        luigi.andar();

        assertEquals(3,luigi.getCasaQueEstouNaPista());

        luigi.equiparItem(cogumelo);
        luigi.usarItem(cogumelo);

        assertEquals(7,luigi.getCasaQueEstouNaPista());

    }

    @Test
    public void testarCorredorSaiDaCorridaAposZerarVida() throws AlvoInvalidoException, ItemINaoEquipadoException {
        Luigi luigi = new Luigi();
        Mario mario = new Mario();

        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(mario);

        CascoVerde cascoVerde = new CascoVerde();

        mario.equiparItem(cascoVerde);
        mario.usarItem(cascoVerde,luigi);

        mario.equiparItem(cascoVerde);
        mario.usarItem(cascoVerde,luigi);

        assertEquals(null,luigi.getPistaQueEstouCorrendo());
    }

    @Test
    public void testarUsarItemNaoEquipadoGeraErro(){
        Luigi luigi = new Luigi();
        Cogumelo cogumelo = new Cogumelo();

        assertThrows(ItemINaoEquipadoException.class,() -> luigi.usarItem(cogumelo));
    }

    @Test
    public void testarUsarItemDeAtaqueEmSiMesmoGeraErro(){
        Luigi luigi = new Luigi();
        Baletao baletao = new Baletao();

        luigi.equiparItem(baletao);

        assertThrows(AlvoInvalidoException.class,() -> luigi.usarItem(baletao,luigi));
    }

    @Test
    public void testarUsarBaletaoComoItemDeBonusBonus() throws ItemINaoEquipadoException {
        DonutPlains donutPlains = new DonutPlains();

        Mario mario = new Mario();
        Baletao baletao = new Baletao();

        donutPlains.adicionarCorredor(mario);

        mario.andar();

        assertEquals(4,mario.getCasaQueEstouNaPista());

        mario.equiparItem(baletao);
        mario.usarItem(baletao);

        assertEquals(11,mario.getCasaQueEstouNaPista());

    }
}