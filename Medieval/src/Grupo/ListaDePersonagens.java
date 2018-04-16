package Grupo;

import Personagens.Pesronagem;

import java.util.LinkedList;
import java.util.List;

public class ListaDePersonagens {

    private List<Pesronagem> listaDePersonagens;

    public ListaDePersonagens() {
        this.listaDePersonagens = new LinkedList<>();
    }

    public void adicionarPersonagemALista(Pesronagem  personagem){
        this.listaDePersonagens.add(personagem);
        personagem.vincularAListaAQuePertence(this);
    }

}
