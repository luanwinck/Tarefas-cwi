package Corredores;

import Erros.AlvoInvalidoException;
import Erros.ItemINaoEquipadoException;
import Itens.Item;
import Itens.ItemDeAtaque;
import Itens.ItemDeBonus;
import Itens.ItemDeRecuperacao;
import Pistas.Pista;

public abstract class Corredor {
    private int vida;
    private int casasQueAndaPorVez;
    private int casaQueEstouNaPista;
    private Item itemEquipado;

    private Pista pistaQueEstouCorrendo;

    public Corredor(int vida) {
        this.vida = vida;
        this.casasQueAndaPorVez = 3;
        this.casaQueEstouNaPista = 0;
    }

    public void vincularAPista(Pista pista){
        pistaQueEstouCorrendo = pista;
    }

    public void andar(){
        casaQueEstouNaPista += casasQueAndaPorVez;
        this.verificarSeChegouAoFimDaCorrida();
    }

    public int getVida() {
        return vida;
    }

    public int getCasasQueAndaPorVez() {
        return casasQueAndaPorVez;
    }

    public int getCasaQueEstouNaPista() {
        return casaQueEstouNaPista;
    }

    public Pista getPistaQueEstouCorrendo() {
        return pistaQueEstouCorrendo;
    }

    protected void setVida(int vida) {
        this.vida = vida;
    }

    protected void setCasasQueAndaPorVez(int casasQueAndaPorVez) {
        this.casasQueAndaPorVez = casasQueAndaPorVez;
    }

    protected void setCasaQueEstouNaPista(int casaQueEstouNaPista) {
        this.casaQueEstouNaPista = casaQueEstouNaPista;
    }

    public void equiparItem(Item item){
        itemEquipado = item;
    }

    public void usarItem(ItemDeBonus itemDeBonus) throws ItemINaoEquipadoException {
        if (verificarSeItemEstaEquipado(itemDeBonus)){
            this.setCasaQueEstouNaPista(this.getCasaQueEstouNaPista() + itemDeBonus.casasExtras());
            this.verificarSeChegouAoFimDaCorrida();
            return;
        }

        throw new ItemINaoEquipadoException();
    }

    public void usarItem(ItemDeRecuperacao itemDeRecuperacao) throws ItemINaoEquipadoException {
        if (verificarSeItemEstaEquipado(itemDeRecuperacao)){
            this.setVida(this.getVida() + itemDeRecuperacao.vidaRecuperada());
            return;
        }

        throw new ItemINaoEquipadoException();
    }

    public void usarItem(ItemDeAtaque itemDeAtaque,Corredor corredor) throws ItemINaoEquipadoException, AlvoInvalidoException {
        if (verificarSeItemEstaEquipado(itemDeAtaque)){
            if (corredor != this){
                corredor.setVida(corredor.getVida() - itemDeAtaque.danoCausado());
                if (corredor.getVida() <= 0){
                    corredor.removerDaPista();
                }
                return;
            }
            throw new AlvoInvalidoException();
        }

        throw new ItemINaoEquipadoException();
    }

    protected boolean verificarSeItemEstaEquipado(Item item){
        return item == itemEquipado ? true : false;
    }

    protected void removerDaPista(){
        pistaQueEstouCorrendo.removerCorredor(this);

        pistaQueEstouCorrendo = null;

    }

    protected void verificarSeChegouAoFimDaCorrida(){
        if (casaQueEstouNaPista > pistaQueEstouCorrendo.getQuantidadesDeCasas()-1){
            pistaQueEstouCorrendo.getPodium().subirNoPodium(this);
        }
    }


}
