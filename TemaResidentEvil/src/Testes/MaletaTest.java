package Testes;


import Armas.Calibre12;
import Armas.ItemDaMaleta;
import Armas.TresOitao;
import Inventario.Maleta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaletaTest {
    @Test
    public void TestarItemMaisPesado(){
        Calibre12 calibre12A = new Calibre12();
        Calibre12 calibre12B = new Calibre12();
        Calibre12 calibre12C = new Calibre12();
        Calibre12 calibre12D = new Calibre12();
        TresOitao tresOitao = new TresOitao();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(calibre12A);
        maleta.adicionarItemNaMaleta(calibre12A);
        maleta.adicionarItemNaMaleta(calibre12A);
        maleta.adicionarItemNaMaleta(calibre12A);
        maleta.adicionarItemNaMaleta(tresOitao);
        maleta.removerItem(calibre12A);



        int resultadoObtido = maleta.espacosDisponiveisNaMaleta();
        int resultadoEsperado = 63;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarItemMaisPesad(){
        Calibre12 calibre12A = new Calibre12();
        Calibre12 calibre12B = new Calibre12();
        Calibre12 calibre12C = new Calibre12();
        Calibre12 calibre12D = new Calibre12();
        TresOitao tresOitaoA = new TresOitao();
        TresOitao tresOitaoB = new TresOitao();
        TresOitao tresOitaoC = new TresOitao();
        TresOitao tresOitaoD = new TresOitao();
        TresOitao tresOitaoE = new TresOitao();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(calibre12A);
        maleta.adicionarItemNaMaleta(calibre12B);
        maleta.adicionarItemNaMaleta(calibre12C);
        maleta.adicionarItemNaMaleta(tresOitaoA);
        maleta.adicionarItemNaMaleta(tresOitaoB);
        maleta.adicionarItemNaMaleta(tresOitaoC);
        maleta.adicionarItemNaMaleta(tresOitaoD);
        maleta.adicionarItemNaMaleta(tresOitaoE);
        maleta.removerItem(tresOitaoA);



        boolean resultadoObtido = maleta.getItemCabeNaMaleta();
        boolean resultadoEsperado = true;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarPesoTotalCarregado(){
        TresOitao tresOitao = new TresOitao();
        Calibre12 calibre12 = new Calibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(calibre12);

        double resultadoObtido = maleta.getPesoTotalDosItensDaMaleta();
        double resultadoEsperado = 4.5;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarItemQue(){
        TresOitao tresOitao = new TresOitao();
        Calibre12 calibre12 = new Calibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(calibre12);

        ItemDaMaleta resultadoObtido = maleta.getItemQueOcupaMaisEspaco();
        ItemDaMaleta resultadoEsperado = calibre12;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

}