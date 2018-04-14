package Inventario;

import Armas.ItemDaMaleta;

import java.util.LinkedList;
import java.util.List;

public class Maleta {

    private List<ItemDaMaleta> listaDeItensDaMaleta;
    //private int array[15][15];
    private int espacosDisponivel;
    private boolean itemCabeNaMaleta;
    private int pesoTotalDosItensDaMaleta;

    public Maleta() {
        this.listaDeItensDaMaleta = new LinkedList<>();
        this.pesoTotalDosItensDaMaleta = pesoTotalDosItensDaMaleta;
    }


    public void adicionarItemNaMaleta(ItemDaMaleta itemDaMaleta) {
        this.listaDeItensDaMaleta.add(itemDaMaleta);
        itemDaMaleta.vincularAMaleta(this);
    }

    public void removerItem(ItemDaMaleta itemDaMaleta) {
        this.listaDeItensDaMaleta.remove(itemDaMaleta);
    }

    public List<ItemDaMaleta> getListaDeItensDaMaleta() {
        return listaDeItensDaMaleta;
    }




}
