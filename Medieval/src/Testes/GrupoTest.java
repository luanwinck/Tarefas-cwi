package Testes;

import Grupo.Grupo;
import Grupo.ListaDePersonagens;
import Personagens.Elfo;
import Personagens.Humano;
import Personagens.Orc;
import Personagens.Pesronagem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    @Test
    public void TestarAtaqueDeGrupo(){
        Grupo grupo = new Grupo();
        Elfo elfo = new Elfo(30,"elfo",10);
        Orc orc = new Orc(20,"orc",true);

        grupo.adicionarPersonagemAoGrupo(elfo);
        grupo.adicionarPersonagemAoGrupo(orc);

        int ResultadoObtido = grupo.ataqueSimples();
        int ResultadoEspeado = 140;

        assertEquals(ResultadoEspeado, ResultadoObtido);

    }

    @Test
    public void TestarAtaqueSomentePorHumanos(){
        Grupo grupo = new Grupo();
        Elfo elfo = new Elfo(10,"elfo",10);
        Orc orc = new Orc(10,"orc",true);
        Humano humano = new Humano(10,"humano",true);
        Humano humano1 = new Humano(15,"humano",false);

        grupo.adicionarPersonagemAoGrupo(elfo);
        grupo.adicionarPersonagemAoGrupo(orc);
        grupo.adicionarPersonagemAoGrupo(humano);
        grupo.adicionarPersonagemAoGrupo(humano1);

        int ResultadoObtido = grupo.ataqueSomentePorHumanos();
        int ResultadoEspeado = 35;

        assertEquals(ResultadoEspeado, ResultadoObtido);

    }

    @Test
    public void TestarAtaqueTotalComHumanos(){
        Grupo grupo = new Grupo();
        Elfo elfo = new Elfo(10,"elfo",10);
        Orc orc = new Orc(10,"orc",false);
        Humano humano = new Humano(10,"humano",true);
        Humano humano1 = new Humano(15,"humano",false);

        grupo.adicionarPersonagemAoGrupo(elfo);
        grupo.adicionarPersonagemAoGrupo(orc);
        grupo.adicionarPersonagemAoGrupo(humano);
        grupo.adicionarPersonagemAoGrupo(humano1);

        int ResultadoObtido = grupo.ataqueSimples();
        int ResultadoEspeado = 65;

        assertEquals(ResultadoEspeado, ResultadoObtido);

    }

    @Test
    public void TestarAdicionandoUmaListaAoGrupo(){
        Grupo grupo = new Grupo();
        Grupo grupo1 = new Grupo();
        ListaDePersonagens listaDePersonagens = new ListaDePersonagens();
        Elfo elfo = new Elfo(10,"elfo",10);
        Orc orc = new Orc(10,"orc",true);
        Humano humano = new Humano(10,"humano",true);

        grupo.adicionarPersonagemAoGrupo(elfo);
        grupo.adicionarPersonagemAoGrupo(orc);
        grupo1.adicionarPersonagemAoGrupo(orc);
        grupo1.adicionarPersonagemAoGrupo(humano);

        grupo.adicionarLstaDePersonagensAoGrupo(grupo1.retornaLista());

        int ResultadoObtido = grupo.ataqueSimples();
        int ResultadoEspeado = 140;

        assertEquals(ResultadoEspeado, ResultadoObtido);

    }

    @Test
    public void TestarOrdenacao(){
        Grupo grupo = new Grupo();
        Grupo grupo1 = new Grupo();
        Elfo elfo = new Elfo(10,"elfo",10);
        Orc orc = new Orc(10,"orc",true);
        Humano humano = new Humano(10,"humano",true);
        Humano humano1 = new Humano(10,"humano1",true);

        grupo.adicionarPersonagemAoGrupo(humano1);
        grupo.adicionarPersonagemAoGrupo(orc);
        grupo.adicionarPersonagemAoGrupo(humano);
        grupo.adicionarPersonagemAoGrupo(elfo);

        grupo1.adicionarPersonagemAoGrupo(elfo);
        grupo1.adicionarPersonagemAoGrupo(humano);
        grupo1.adicionarPersonagemAoGrupo(humano1);
        grupo1.adicionarPersonagemAoGrupo(orc);


        List<Pesronagem> ResultadoObtido = grupo.ataqueOrdenado();
        List<Pesronagem> ResultadoEspeado = grupo1.retornaLista();

        assertEquals(ResultadoEspeado, ResultadoObtido);

    }

}