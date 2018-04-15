package Armas;

public class PlantaVermelha extends Plantas {
    public PlantaVermelha() {
        super(0.5, 1, 1);
    }

    @Override
    public String getReferencia() {
        return "Planta vermelha";
    }
}
