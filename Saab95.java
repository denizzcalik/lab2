import java.awt.*;

public class Saab95 extends Car {

    public TurboCar turbocar;

    public Saab95(Color color, int x, int y){
        super(2, 125, color, "Saab95", x, y);
        this.turbocar = new TurboCar();
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * turbocar.getTurbo();
    }
}
