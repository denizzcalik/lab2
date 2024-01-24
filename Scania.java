import java.awt.*;

public class Scania extends Truck{

    public Scania(Color color, int x, int y) {
        super(2, 550, color, "Scania", x, y, new Platform());

    }
    public void raisePlatform(int amount){
        if (getCurrentSpeed() == 0) {
            if (this.attachment instanceof Platform) {
                ((Platform) this.attachment).raiseAttachment(amount);
            }
        }
    }
    public void lowerPlatform(int amount){
        if (getCurrentSpeed() == 0) {
            if (this.attachment instanceof Platform) {
                ((Platform) this.attachment).lowerAttachment(amount);
            }
        }
    }
}
