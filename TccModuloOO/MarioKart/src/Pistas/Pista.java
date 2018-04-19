package Pistas;

import Corredores.Corredor;

import java.util.LinkedList;

public abstract class Pista {
    private int quantidadesDeCasas;
    private LinkedList<Corredor> corredoresNaPista;
    private Podium podium;

    public Pista(int quantidadesDeCasas) {

        this.quantidadesDeCasas = quantidadesDeCasas;
        this.corredoresNaPista = new LinkedList<>();
        this.podium = new Podium();
    }

    public Podium getPodium(){
        return podium;
    }

    public int getQuantidadesDeCasas(){
        return quantidadesDeCasas;
    }

    public void adicionarCorredor(Corredor corredor){
        corredoresNaPista.add(corredor);
        corredor.vincularAPista(this);
    }

    public void removerCorredor(Corredor corredor){
        corredoresNaPista.remove(corredor);
    }

    public boolean getCorredorEstaNaPista(Corredor corredor){
        for (Corredor corredorNaPista : corredoresNaPista){
            if (corredor == corredorNaPista){
                return true;
            }
        }
        return false;
    }


}
