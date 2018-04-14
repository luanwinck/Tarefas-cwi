package Armas;

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

        Calibre12 calibre12NaMaleta =
                (Calibre12) maleta.getListaDeItensDaMaleta().get(2);

        assertEquals(calibre12NaMaleta, calibre12);
    }


}