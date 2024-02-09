import java.awt.*;

public abstract class Truck extends Car{

    public Attachment attachment;
    public Truck(int doors, int horsepower, Color carcolor, String model, double x, double y, Attachment attachment) {
        super(doors, horsepower, carcolor, model, x, y, CarSize.LARGE);
        this.attachment = attachment;

    }
    @Override
    protected double speedFactor() {
        if (!this.attachment.attachmentInUse()) {
            return getEnginePower() * 0.01;
  }
        return 0;
    }
    public void raiseAttachment(){
        if (getCurrentSpeed() == 0) {
            this.attachment.raiseAttachment();
        }
    }
    public void lowerAttachment(){
        if (getCurrentSpeed() == 0) {
            this.attachment.lowerAttachment();
        }
    }

}





