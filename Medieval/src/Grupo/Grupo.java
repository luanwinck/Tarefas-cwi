package Grupo;

import Personagens.Humano;
import Personagens.Pesronagem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Grupo {

    private List<Pesronagem> grupoDePersonagens;
    private Pesronagem[] listaOrdenada;
    private int ataqueTotal;
    private int ataqueDosHumanos;

    public Grupo() {
        grupoDePersonagens = new LinkedList<>();
    }

    public void adicionarPersonagemAoGrupo(Pesronagem  personagem){
        this.grupoDePersonagens.add(personagem);
    }

    public void adicionarLstaDePersonagensAoGrupo(List lista){
        this.grupoDePersonagens.addAll(lista);
    }

    public int ataqueSimples(){
        this.ataqueTotal = 0;
        for (Pesronagem personagemNoGrupo : this.grupoDePersonagens){
            this.ataqueTotal += personagemNoGrupo.getPoderDeAtaque();
        }
        return this.ataqueTotal;
    }

    public int ataqueSomentePorHumanos(){
        this.ataqueDosHumanos = 0;
        for (Pesronagem personagemNoGrupo : this.grupoDePersonagens){
            if (personagemNoGrupo instanceof Humano) {
                this.ataqueDosHumanos += personagemNoGrupo.getPoderDeAtaque();
            }
        }
        return this.ataqueDosHumanos;
    }

    public List<Pesronagem> ataqueOrdenado() {
        Pesronagem[] itensOrdenados = new Pesronagem[grupoDePersonagens.size()];
        itensOrdenados = grupoDePersonagens.toArray(itensOrdenados);

        int numeroDeItens = itensOrdenados.length;

        for (int i = 0; i < numeroDeItens; i++) {
            for (int j = 0; j < numeroDeItens - 1; j++) {
                Pesronagem itemA = itensOrdenados[j];
                Pesronagem itemB = itensOrdenados[j + 1];

                if (this.itemAMaiorQueB(itemA, itemB)) {
                    itensOrdenados[j] = itemB;
                    itensOrdenados[j + 1] = itemA;
                }
            }
        }

        return Arrays.asList(itensOrdenados);
    }
    protected boolean itemAMaiorQueB(Pesronagem itemA, Pesronagem itemB) {
        return itemA.getNome().compareToIgnoreCase(itemB.getNome()) > 0;
    }
    public List<Pesronagem> retornaLista(){
        return grupoDePersonagens;
    }
}
