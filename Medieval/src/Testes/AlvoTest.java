package Testes;

import Alvos.Alvo;
import Alvos.RaidBoss;
import Grupo.Grupo;
import Personagens.Orc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlvoTest {
    @Test
    public void testarAtaqueDeGrupoAoAlvoEEleSendoDestruido(){
        Alvo alvo = new Alvo(100);
        Grupo grupo = new Grupo();
        Orc orc = new Orc(10,"orc",true);
        Orc orc2 = new Orc(10,"orc",true);

        grupo.adicionarPersonagemAoGrupo(orc);
        grupo.adicionarPersonagemAoGrupo(orc2);
        alvo.receberAtaque(grupo.ataqueSimples());

        boolean RetornoEsperado = true;
        boolean RetornoObtido = alvo.destruido();

        assertEquals(RetornoEsperado, RetornoObtido);

    }

    @Test
    public void testarAtaqueDeGrupoAoRaidBossNaoSendoDestruido(){
        RaidBoss raidBoss = new RaidBoss(100,"raid boss",50);
        Grupo grupo = new Grupo();
        Orc orc = new Orc(10,"orc",true);
        Orc orc2 = new Orc(10,"orc",true);

        grupo.adicionarPersonagemAoGrupo(orc);
        grupo.adicionarPersonagemAoGrupo(orc2);
        raidBoss.receberAtaque(grupo.ataqueSimples());

        boolean RetornoEsperado = false;
        boolean RetornoObtido = raidBoss.destruido();

        assertEquals(RetornoEsperado, RetornoObtido);

    }

    @Test
    public void testarAtaqueDeGrupoAoRaidBossSendoDestruido(){
        RaidBoss raidBoss = new RaidBoss(100,"raid boss",50);
        Grupo grupo = new Grupo();
        Orc orc = new Orc(10,"orc",true);
        Orc orc2 = new Orc(10,"orc",true);

        grupo.adicionarPersonagemAoGrupo(orc);
        grupo.adicionarPersonagemAoGrupo(orc2);
        raidBoss.receberAtaque(grupo.ataqueSimples());
        raidBoss.receberAtaque(grupo.ataqueSimples());

        boolean RetornoEsperado = true;
        boolean RetornoObtido = raidBoss.destruido();

        assertEquals(RetornoEsperado, RetornoObtido);

    }







}