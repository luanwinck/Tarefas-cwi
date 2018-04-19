package Itens;

public class Baletao implements ItemDeAtaque, ItemDeBonus{
    @Override
    public int casasExtras() {
        return 7;
    }

    @Override
    public int danoCausado() {
        return 5;
    }
}
