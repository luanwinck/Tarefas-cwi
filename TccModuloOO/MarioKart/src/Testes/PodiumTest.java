package Testes;

import Corredores.Luigi;
import Erros.ItemINaoEquipadoException;
import Itens.Cogumelo;
import Pistas.DonutPlains;
import Pistas.LugarNoPodium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PodiumTest {
    @Test
    public void testarCorredoresChegandoAoPodium(){
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
    public void testarCorredorChegandoAoPodiumUsandoItem() throws ItemINaoEquipadoException {
        DonutPlains donutPlains = new DonutPlains();
        Luigi luigi = new Luigi();
        Cogumelo cogumelo = new Cogumelo();

        donutPlains.adicionarCorredor(luigi);

        for (int i = 0; i < 6; i++) {
            luigi.andar();
        }

        assertEquals(null,donutPlains.getPodium().getCorredorNaPosicao(LugarNoPodium.PRIMEIRO_LUGAR));

        luigi.equiparItem(cogumelo);
        luigi.usarItem(cogumelo);

        assertEquals(luigi,donutPlains.getPodium().getCorredorNaPosicao(LugarNoPodium.PRIMEIRO_LUGAR));

    }

}