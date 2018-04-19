package Pistas;

import Corredores.Corredor;

public class Podium {

    private Corredor[] corredorsNoPodium;

    public Podium() {
        corredorsNoPodium = new Corredor[3];
    }

    public void subirNoPodium(Corredor corredor){
        for (int i = 0; i < 2; i++) {
            if (corredorsNoPodium[i] == corredor){
                return;
            }
        }

        if (corredorsNoPodium[0] == null){
            corredorsNoPodium[0] = corredor;
            return;
        }

        else if (corredorsNoPodium[1] == null){
            corredorsNoPodium[1] = corredor;
            return;
        }

        else if (corredorsNoPodium[2] == null){
            corredorsNoPodium[2] = corredor;
            return;
        }
    }

    public Corredor getCorredorNaPosicao(LugarNoPodium lugarNoPodium){
        if (lugarNoPodium == LugarNoPodium.PRIMEIRO_LUGAR){
            return corredorsNoPodium[0];
        }

        else if (lugarNoPodium == LugarNoPodium.SEGUNDO_LUGAR){
            return corredorsNoPodium[1];
        }

        else {
            return corredorsNoPodium[2];
        }
    }
}
