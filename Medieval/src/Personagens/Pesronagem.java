package Personagens;

import Grupo.Grupo;
import Grupo.ListaDePersonagens;

public class Pesronagem {

    private int poderDeAtaque;
    private String nome;

    private Grupo grupoAQuePertence;
    private ListaDePersonagens listaAQuePertence;

    public Pesronagem(int poderDeAtaque, String nome) {
        this.poderDeAtaque = poderDeAtaque;
        this.nome = nome;
    }



    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }

    public void vincularAGrupoAQuePertence(Grupo grupo){
        this.grupoAQuePertence = grupo;
    }

    public void vincularAListaAQuePertence(ListaDePersonagens listaDePersonagens){
        this.listaAQuePertence = listaDePersonagens;
    }

    public String getNome(){
        return nome;
    }

}
