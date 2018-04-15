package Inventario;

import Armas.*;

public class Maleta {

    private ItemDaMaleta[][] espacoDaMaleta;
    private int espacosDisponivel;
    private boolean itemCabeNaMaleta;
    private double pesoTotalDosItensDaMaleta;
    private ItemDaMaleta itemQueOcupaMaisEspaco;
    private double pesoItemQueOcupaMaisEspaco;

    public Maleta() {
        this.espacoDaMaleta = new ItemDaMaleta[10][10];
        this.itemCabeNaMaleta = true;
    }


    public void adicionarItemNaMaleta(ItemDaMaleta itemDaMaleta) {
        int auxI = 0;
        int auxJ = 0;
        boolean controle = false;
        for (int i = 0; i < espacoDaMaleta.length; i++) {
            for (int j = 0; j < espacoDaMaleta.length; j++) {
                if (espacoDaMaleta[i][j] == null && !controle) {
                    if (espacoDaMaleta.length-j >= itemDaMaleta.getLarguraOcupada()){
                        if (espacoDaMaleta.length-i >= itemDaMaleta.getAlturaOcupada()){
                            auxI = i;
                            auxJ = j;
                            controle = true;
                        }
                    }
                }
            }
        }
        if (!controle){
            this.itemCabeNaMaleta = false;
        }
        for (int i = auxI; i < itemDaMaleta.getAlturaOcupada()+auxI; i++){
            for (int j = auxJ; j < itemDaMaleta.getLarguraOcupada()+auxJ; j++){
                espacoDaMaleta[i][j] = itemDaMaleta;
                itemDaMaleta.vincularAMaleta(this);
            }
        }
        this.pesoTotalDosItensDaMaleta += itemDaMaleta.getPeso();
        if (itemDaMaleta.getPeso() > pesoItemQueOcupaMaisEspaco) {
            this.itemQueOcupaMaisEspaco = itemDaMaleta;
            this.pesoItemQueOcupaMaisEspaco = itemDaMaleta.getPeso();
        }

    }

    public void adicionarItemNaMaletaVirado(ItemDaMaleta itemDaMaleta) {
        int auxI = 0;
        int auxJ = 0;
        boolean controle = false;
        for (int i = 0; i < espacoDaMaleta.length; i++) {
            for (int j = 0; j < espacoDaMaleta.length; j++) {
                if (espacoDaMaleta[i][j] == null && !controle) {
                    if (espacoDaMaleta.length-j >= itemDaMaleta.getAlturaOcupada()){
                        if (espacoDaMaleta.length-i >= itemDaMaleta.getLarguraOcupada()){
                            auxI = i;
                            auxJ = j;
                            controle = true;
                        }
                    }
                }
            }
        }
        if (!controle){
            this.itemCabeNaMaleta = false;
        }
        for (int i = auxI; i < itemDaMaleta.getLarguraOcupada()+auxI; i++){
            for (int j = auxJ; j < itemDaMaleta.getAlturaOcupada()+auxJ; j++){
                espacoDaMaleta[i][j] = itemDaMaleta;
                itemDaMaleta.vincularAMaleta(this);
            }
        }
        this.pesoTotalDosItensDaMaleta += itemDaMaleta.getPeso();
        if (itemDaMaleta.getPeso() > pesoItemQueOcupaMaisEspaco) {
            this.itemQueOcupaMaisEspaco = itemDaMaleta;
            this.pesoItemQueOcupaMaisEspaco = itemDaMaleta.getPeso();
        }

    }


    public void removerItem(ItemDaMaleta itemDaMaleta) {

        for (int i = 0; i < espacoDaMaleta.length; i++) {
            for (int j = 0; j < espacoDaMaleta.length; j++) {
                if (espacoDaMaleta[i][j] == itemDaMaleta){
                    espacoDaMaleta[i][j] = null;
                }
            }

        }
        this.pesoTotalDosItensDaMaleta -= itemDaMaleta.getPeso();
    }

    public void fundirPlantas(Plantas plantaA, Plantas plantaB){
        if (plantaA.getReferencia() == plantaB.getReferencia()){
            if (plantaA.getReferencia() == "Planta verde"){
                FusaoVerdeVerde fusaoVerdeVerde = new FusaoVerdeVerde();

                removerItem(plantaA);
                removerItem(plantaB);

                adicionarItemNaMaleta(fusaoVerdeVerde);

            }
            if (plantaA.getReferencia() == "Planta vermelha"){
                FusaoVermelhoVermelho fusaoVermelhoVermelho = new FusaoVermelhoVermelho();

                removerItem(plantaA);
                removerItem(plantaB);

                adicionarItemNaMaleta(fusaoVermelhoVermelho);
            }
        }
        else{
            FusaoVerdeVermelho fusaoVerdeVermelho = new FusaoVerdeVermelho();

            removerItem(plantaA);
            removerItem(plantaB);

            adicionarItemNaMaleta(fusaoVerdeVermelho);
        }
    }



    public int getEspacosDisponiveisNaMaleta(){
        for (int i = 0; i < espacoDaMaleta.length; i++) {
            for (int j = 0; j < espacoDaMaleta.length; j++) {
                if (espacoDaMaleta[i][j] == null){
                    this.espacosDisponivel ++;
                }
            }

        }
        return espacosDisponivel;
    }

    public double getPesoTotalDosItensDaMaleta(){ return pesoTotalDosItensDaMaleta; }

    public ItemDaMaleta getItemQueOcupaMaisEspaco(){ return itemQueOcupaMaisEspaco; }

    public boolean getItemCabeNaMaleta(){ return itemCabeNaMaleta; }

}
