package Testes;


import Armas.*;
import Inventario.Maleta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaletaTest {

    //Peso tresOitao: 1.2kg
    //Peso municao tresOitao: 0.2kg
    //Peso calibre12: 4.5kg
    //Peso municao calibre12: 0.4kg
    //Peso bazuca: 15kg
    //Peso missel da bazuca: 3kg
    //Peso plantas verde e vermelha: 0.5kg
    //Peso fusão das plantas verde: 0.7kg
    //Peso fusão das plantas vermelha: 0.7kg;
    //Peso fusão das plantas vermelha e verde: 0.8kg

    //tamanho maleta: 10x10

    @Test
    public void TestarColocandoUmaBazucaEUmMisselNaMaletaERetornandoEspacosDisponiveis44(){
        Bazuca bazuca = new Bazuca();
        MisselDeBazuca misselDeBazuca = new MisselDeBazuca();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(bazuca);
        maleta.adicionarItemNaMaleta(misselDeBazuca);

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 44;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarColocandoUmaBazucaEUmMisselNaMaletaEAtirandoComBazucaRetornandoEspacosDisponiveis60(){
        Bazuca bazuca = new Bazuca();
        MisselDeBazuca misselDeBazuca = new MisselDeBazuca();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(bazuca);
        maleta.adicionarItemNaMaleta(misselDeBazuca);
        bazuca.atirar(misselDeBazuca);

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 60;

        assertEquals(resultadoObtido,resultadoEsperado);
    }

    @Test
    public void TestarColocandoUmaBazucaEUmMisselEUmCalibre12NaMaletaERetornandoQueNaoCabeNaMaleta(){
        Bazuca bazuca = new Bazuca();
        MisselDeBazuca misselDeBazuca = new MisselDeBazuca();
        Calibre12 calibre12 = new Calibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(bazuca);
        maleta.adicionarItemNaMaleta(misselDeBazuca);
        maleta.adicionarItemNaMaleta(calibre12);

        boolean resultadoObtido = maleta.getItemCabeNaMaleta();
        boolean resultadoEsperado = false;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarColocandoUmaBazucaEUmMisselEUmCalibre12ViradoNaMaletaERetornandoQueCabeNaMaleta(){
        Bazuca bazuca = new Bazuca();
        MisselDeBazuca misselDeBazuca = new MisselDeBazuca();
        Calibre12 calibre12 = new Calibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(bazuca);
        maleta.adicionarItemNaMaleta(misselDeBazuca);
        maleta.adicionarItemNaMaletaVirado(calibre12);

        boolean resultadoObtido = maleta.getItemCabeNaMaleta();
        boolean resultadoEsperado = true;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarColocandoUmaBazucaEUmMisselEUmTresOitaoNaMaletaERetornandoQueCabeNaMaleta(){
        Bazuca bazuca = new Bazuca();
        MisselDeBazuca misselDeBazuca = new MisselDeBazuca();
        TresOitao tresOitao = new TresOitao();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(bazuca);
        maleta.adicionarItemNaMaleta(misselDeBazuca);
        maleta.adicionarItemNaMaleta(tresOitao);

        boolean resultadoObtido = maleta.getItemCabeNaMaleta();
        boolean resultadoEsperado = true;

        assertEquals(resultadoObtido,resultadoEsperado);
    }

    @Test
    public void TestarColocandoUmTresOitaUmCalibreEUmaBazucaERemovendoOCalibre12ERetornandoTamanhoRestante54(){
        TresOitao tresOitao = new TresOitao();
        Calibre12 calibre12 = new Calibre12();
        Bazuca bazuca = new Bazuca();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(tresOitao);
        maleta.adicionarItemNaMaleta(calibre12);
        maleta.removerItem(calibre12);
        maleta.adicionarItemNaMaleta(bazuca);

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 54;

        assertEquals(resultadoObtido,resultadoEsperado);
    }


    @Test
    public void TestarColocandoUmTresOitaoEUmCalibre12ERetornandoQueCalibre12OcupaMaisEspaco(){
        TresOitao tresOitao = new TresOitao();
        Calibre12 calibre12 = new Calibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(tresOitao);
        maleta.adicionarItemNaMaleta(calibre12);

        ItemDaMaleta resultadoObtido = maleta.getItemQueOcupaMaisEspaco();
        ItemDaMaleta resultadoEsperado = calibre12;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarColocandoUmTresOitaoUmCalibre12EUmaBazucaERetornaABazucaComoItemMaisPesado(){
        TresOitao tresOitao = new TresOitao();
        Calibre12 calibre12 = new Calibre12();
        Bazuca bazuca = new Bazuca();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(tresOitao);
        maleta.adicionarItemNaMaleta(calibre12);
        maleta.adicionarItemNaMaleta(bazuca);

        ItemDaMaleta resultadoObtido = maleta.getItemQueOcupaMaisEspaco();
        ItemDaMaleta resultadoEsperado = bazuca;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarColocandoUmCalibre12EMunicaoDeCalibre12RetornandoTamanhoRestante77(){
        Calibre12 calibre12 = new Calibre12();
        MunicaoCalibre12 municaoCalibre12 = new MunicaoCalibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(calibre12);
        maleta.adicionarItemNaMaleta(municaoCalibre12);

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 77;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarColocandoUmCalibre12EMunicaoDeCalibre12EAtirandoAteGastarTodaMunicaoRetornandoTamanhoRestante79(){
        Calibre12 calibre12 = new Calibre12();
        MunicaoCalibre12 municaoCalibre12 = new MunicaoCalibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(calibre12);
        maleta.adicionarItemNaMaleta(municaoCalibre12);

        for (int i = 0; i < 4; i++) {
            calibre12.atirar();
            calibre12.recarregar(municaoCalibre12);
        }

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 79;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarColocandoUmCalibre12EMunicaoDeCalibre12EAtirandoSemGastarTodaMunicaoRetornandoTamanhoRestante77(){
        Calibre12 calibre12 = new Calibre12();
        MunicaoCalibre12 municaoCalibre12 = new MunicaoCalibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(calibre12);
        maleta.adicionarItemNaMaleta(municaoCalibre12);

        for (int i = 0; i < 3; i++) {
            calibre12.atirar();
            calibre12.recarregar(municaoCalibre12);
        }

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 77;

        assertEquals(resultadoObtido,resultadoEsperado);

    }

    @Test
    public void TestarPesoTotalCarregadoPorUmTresOitaoEUmCalibre12Retornando5Virgula7(){
        TresOitao tresOitao = new TresOitao();
        Calibre12 calibre12 = new Calibre12();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(tresOitao);
        maleta.adicionarItemNaMaleta(calibre12);

        double resultadoObtido = maleta.getPesoTotalDosItensDaMaleta();
        double resultadoEsperado = 5.7;

        assertEquals(resultadoObtido,resultadoEsperado);
    }

    @Test
    public void TestarPesoTotalCarregadoPorUmaBazucaEUmMisselRetornando18(){
        Bazuca bazuca = new Bazuca();
        MisselDeBazuca misselDeBazuca = new MisselDeBazuca();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(bazuca);
        maleta.adicionarItemNaMaleta(misselDeBazuca);

        double resultadoObtido = maleta.getPesoTotalDosItensDaMaleta();
        double resultadoEsperado = 18;

        assertEquals(resultadoObtido,resultadoEsperado);
    }

    @Test
    public void TestarPesoTotalCarregadoPorUmaBazucaEUmMisselUmTresOitaoEMunicaoDeTresOitaoRetornando18(){
        Bazuca bazuca = new Bazuca();
        MisselDeBazuca misselDeBazuca = new MisselDeBazuca();
        TresOitao tresOitao = new TresOitao();
        MunicaoTresOitao municaoTresOitao = new MunicaoTresOitao();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(bazuca);
        maleta.adicionarItemNaMaleta(misselDeBazuca);
        maleta.adicionarItemNaMaleta(tresOitao);
        maleta.adicionarItemNaMaleta(municaoTresOitao);

        double resultadoObtido = maleta.getPesoTotalDosItensDaMaleta();
        double resultadoEsperado = 19.4;

        assertEquals(resultadoObtido,resultadoEsperado);
    }


}