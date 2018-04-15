package Inventario;

import Armas.ItemDaMaleta;

import java.util.LinkedList;
import java.util.List;

public class Maleta {

    private List<ItemDaMaleta> listaDeItensDaMaleta;
    private ItemDaMaleta[][] espacoDaMaleta;
    private int espacosDisponivel;
    private boolean itemCabeNaMaleta;
    private double pesoTotalDosItensDaMaleta;
    private ItemDaMaleta itemQueOcupaMaisEspaco;

    public Maleta() {
        this.listaDeItensDaMaleta = new LinkedList<>();
        this.pesoTotalDosItensDaMaleta = pesoTotalDosItensDaMaleta;
        this.espacoDaMaleta = new ItemDaMaleta[10][10];
        this.itemCabeNaMaleta = true;
    }

    public void adicionarItemNaMaletaxx(ItemDaMaleta itemDaMaleta) {
        int controle = 1;
        int contadorDePosicaoLivre = 0;
        for (int i = 0; i < espacoDaMaleta.length; i++) {
            for (int j = 0; j < espacoDaMaleta.length; j++) {
                if (espacoDaMaleta[i][j] == null && controle == 1) {
                    int auxI = i;
                    int auxJ = j;
                    for (int x = i; x < itemDaMaleta.getAlturaOcupada() + i; x++) {
                        for (int y = j; y < itemDaMaleta.getLarguraOcupada() + j; y++) {
                            contadorDePosicaoLivre++;
                        }
                    }
                    if (contadorDePosicaoLivre == itemDaMaleta.getTamanhoOcupado()) {
                        for (int l = auxI; l < itemDaMaleta.getAlturaOcupada() + auxI; l++) {
                            for (int m = auxJ; m < itemDaMaleta.getLarguraOcupada() + auxJ; m++) {
                                espacoDaMaleta[l][m] = itemDaMaleta;
                                itemDaMaleta.vincularAMaleta(this);
                            }
                        }
                        controle = 0;
                    }

                }
            }
        }

        this.pesoTotalDosItensDaMaleta += itemDaMaleta.getPeso();
        this.itemQueOcupaMaisEspaco = itemDaMaleta;
    }

    public void adicionarItemNaMaletaVirado(ItemDaMaleta itemDaMaleta) {
        int controle = 1;
        int contadorDePosicaoLivre = 0;

        for (int i = 0; i < espacoDaMaleta.length; i++) {
            for (int j = 0; j < espacoDaMaleta.length; j++) {
                if (espacoDaMaleta[i][j] == null && controle == 1) {
                    int auxI = i;
                    int auxJ = j;
                    for (int x = i; x < itemDaMaleta.getLarguraOcupada() + i; x++) {
                        for (int y = j; y < itemDaMaleta.getAlturaOcupada() + j; y++) {
                            contadorDePosicaoLivre++;
                        }
                    }
                    if (contadorDePosicaoLivre == itemDaMaleta.getTamanhoOcupado()) {
                        for (int l = auxI; l < itemDaMaleta.getLarguraOcupada() + auxI; l++) {
                            for (int m = auxJ; m < itemDaMaleta.getAlturaOcupada() + auxJ; m++) {
                                espacoDaMaleta[l][m] = itemDaMaleta;
                                itemDaMaleta.vincularAMaleta(this);
                            }
                        }
                        controle = 0;
                    }

                }
            }
        }

        this.pesoTotalDosItensDaMaleta += itemDaMaleta.getPeso();
        this.itemQueOcupaMaisEspaco = itemDaMaleta;
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
    public int espacosDisponiveisNaMaleta(){
        for (int i = 0; i < espacoDaMaleta.length; i++) {
            for (int j = 0; j < espacoDaMaleta.length; j++) {
                if (espacoDaMaleta[i][j] != null){
                    this.espacosDisponivel ++;
                }
            }

        }
        return espacosDisponivel;
    }

    public double getPesoTotalDosItensDaMaleta(){ return pesoTotalDosItensDaMaleta; }

    public ItemDaMaleta getItemQueOcupaMaisEspaco(){ return itemQueOcupaMaisEspaco; }

    public boolean getItemCabeNaMaleta(){ return itemCabeNaMaleta; }

    public List<ItemDaMaleta> getListaDeItensDaMaleta() {return listaDeItensDaMaleta; }




}
