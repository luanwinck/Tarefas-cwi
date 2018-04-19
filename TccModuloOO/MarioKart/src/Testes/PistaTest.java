package Testes;

import Corredores.*;
import Erros.AlvoInvalidoException;
import Erros.ItemINaoEquipadoException;
import Itens.Baletao;
import Itens.CascoVerde;
import Itens.Cogumelo;
import Itens.CogumeloRoxo;
import Pistas.DonutPlains;
import Pistas.LugarNoPodium;
import Pistas.Pista;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PistaTest {


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
    public void testarUsarBaletaoComoItemDeBonus() throws ItemINaoEquipadoException {
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

    @Test
    public void testarUsarBaletaoComoItemDeAtaque() throws ItemINaoEquipadoException, AlvoInvalidoException {
        DonutPlains donutPlains = new DonutPlains();

        Mario mario = new Mario();
        Luigi luigi = new Luigi();
        Baletao baletao = new Baletao();

        donutPlains.adicionarCorredor(mario);
        donutPlains.adicionarCorredor(luigi);

        assertEquals(donutPlains,luigi.getPistaQueEstouCorrendo());

        mario.equiparItem(baletao);
        mario.usarItem(baletao,luigi);

        assertEquals(null, luigi.getPistaQueEstouCorrendo());

    }

    @Test
    public void testarUsarBaletaoComoItemDeAtaqueCorredorSaiDaPista() throws ItemINaoEquipadoException, AlvoInvalidoException {
        DonutPlains donutPlains = new DonutPlains();

        Mario mario = new Mario();
        Luigi luigi = new Luigi();
        Baletao baletao = new Baletao();

        donutPlains.adicionarCorredor(mario);
        donutPlains.adicionarCorredor(luigi);

        assertEquals(donutPlains,luigi.getPistaQueEstouCorrendo());

        mario.equiparItem(baletao);
        mario.usarItem(baletao,luigi);

        assertEquals(false, donutPlains.getCorredorEstaNaPista(luigi));
    }

    @Test
    public void testarUsarItemDeRecuperacao() throws ItemINaoEquipadoException {
        DonutPlains donutPlains = new DonutPlains();

        Mario mario = new Mario();
        CogumeloRoxo cogumeloRoxo = new CogumeloRoxo();

        donutPlains.adicionarCorredor(mario);

        assertEquals(7,mario.getVida());

        mario.equiparItem(cogumeloRoxo);
        mario.usarItem(cogumeloRoxo);

        assertEquals(9, mario.getVida());

        mario.equiparItem(cogumeloRoxo);
        mario.usarItem(cogumeloRoxo);

        assertEquals(11, mario.getVida());
    }
}