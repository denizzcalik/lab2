import java.awt.*;

public class Scania extends Truck{
    public Platform platform;
    public Scania(Color color, int x, int y, Platform platform) {
        super(2, 550, color, "Scania", x, y, platform = new Platform());
        this.platform = platform;

    }
    public void raisePlatform(double amount){
        if (getCurrentSpeed() == 0) {
            this.platform.raiseAngle(amount);
        }
    }
    public void lowerPlatform(double amount){
        if (getCurrentSpeed() == 0) {
            this.platform.lowerAngle(amount);
        }
    }

}
