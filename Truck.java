import java.awt.*;

public abstract class Truck extends Car{

    public Attachment attachment;
    public Truck(int doors, int horsepower, Color carcolor, String model, double x, double y, Attachment attachment) {
        super(doors, horsepower, carcolor, model, x, y);
        this.attachment = attachment;

    }
    @Override
    protected double speedFactor() {
        if (this.attachment.attachmentInUse() == Boolean.FALSE) {
            return getEnginePower() * 0.01;
  }
        return 0;
    }
}




