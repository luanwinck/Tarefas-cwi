package Testes;

import Armas.Calibre12;
import Armas.TresOitao;
import Inventario.Maleta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDaMaletaTest {

    @Test
    public void TesteAdicionarUmItemAMaleta(){
        TresOitao tresOitao = new TresOitao();
        Calibre12 calibre12 = new Calibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(tresOitao);
        maleta.adicionarItemNaMaleta(tresOitao);
        maleta.adicionarItemNaMaleta(calibre12);
        

        TresOitao tresOitaoNaMaleta =
                (TresOitao) maleta.getListaDeItensDaMaleta().get(1);

        assertEquals(tresOitaoNaMaleta, tresOitao);
    }

}