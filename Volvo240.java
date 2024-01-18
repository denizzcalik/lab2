import java.awt.*;

public class Volvo240 extends Car{

    public TrimCar trimcar;

    public Volvo240(Color color, int x, int y){
        super(4, 100, color, "Volvo240", x, y);
        this.trimcar = new TrimCar(1.25);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimcar.getTrim();
    }

}
