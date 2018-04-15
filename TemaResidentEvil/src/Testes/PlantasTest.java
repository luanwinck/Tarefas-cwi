package Testes;

import Armas.PlantaVerde;
import Armas.PlantaVermelha;
import Inventario.Maleta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantasTest {

    //planta verde e vermelha ocupas 1x1
    //fusão de duas plantas verdes ocupa 1x3
    //fusão de duas plantas vermelhas ocupa 3x2
    //fusão de uma planta verde e uma vermelha ocupa 2x2
    //tamanho maleta 10x10

    @Test
    public void TestarFundirUmaPlantaVerdeEUmaVermelhaRetornandoEspacoDisponivelNaMaleta96(){
        PlantaVerde plantaVerde = new PlantaVerde();
        PlantaVermelha plantaVermelha = new PlantaVermelha();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(plantaVerde);
        maleta.adicionarItemNaMaleta(plantaVermelha);

        maleta.fundirPlantas(plantaVerde,plantaVermelha);

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 96;

        assertEquals(resultadoObtido,resultadoEsperado);
    }

    @Test
    public void  TestarFundirDuasPlantasVerdesRetornandoEspacoDisponivelNaMaleta97(){
        PlantaVerde plantaVerde = new PlantaVerde();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(plantaVerde);
        maleta.adicionarItemNaMaleta(plantaVerde);

        maleta.fundirPlantas(plantaVerde,plantaVerde);

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 97;

        assertEquals(resultadoObtido,resultadoEsperado);
    }

    @Test
    public void TestarFundirDuasPlantasVermelhasRetornandoEspacoDisponivelNaMaleta94(){
        PlantaVermelha plantaVermelhaA = new PlantaVermelha();
        PlantaVermelha plantaVermelhaB = new PlantaVermelha();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(plantaVermelhaA);
        maleta.adicionarItemNaMaleta(plantaVermelhaB);

        maleta.fundirPlantas(plantaVermelhaA,plantaVermelhaB);

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 94;

        assertEquals(resultadoObtido,resultadoEsperado);
    }
    @Test
    public void TestarFundirUmaPlantaVerdeEUmaVermelhaContentoUmaPlantaVerdeAMaisRetornandoEspacoDisponivelNaMaleta95(){
        PlantaVerde plantaVerdeA = new PlantaVerde();
        PlantaVerde plantaVerdeB = new PlantaVerde();
        PlantaVermelha plantaVermelha = new PlantaVermelha();
        Maleta maleta = new Maleta();

        maleta.adicionarItemNaMaleta(plantaVermelha);
        maleta.adicionarItemNaMaleta(plantaVerdeA);
        maleta.adicionarItemNaMaleta(plantaVerdeB);


        maleta.fundirPlantas(plantaVerdeA,plantaVermelha);

        int resultadoObtido = maleta.getEspacosDisponiveisNaMaleta();
        int resultadoEsperado = 95;

        assertEquals(resultadoObtido,resultadoEsperado);
    }
}