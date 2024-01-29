import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CarTransporter extends Truck{

    protected Loadable loadable;

    public CarTransporter(int maxLoad, Color color, int x, int y) {
        super(2, 550, color, "Car Transporter", x, y, new Flatbed());
        this.loadable = new Loadable(maxLoad, x, y);
    }

    public void raiseFlatbed() {
        if (this.getCurrentSpeed() == 0) {
            this.attachment.raiseAttachment();
        }
    }

    public void lowerFlatbed() {
        if (this.getCurrentSpeed() == 0) {
            this.attachment.lowerAttachment();
        }
    }

    public void load(Car car) {
        if (!attachment.attachmentInUse() && this.getCurrentSpeed() == 0 && !(car instanceof Truck)){
            loadable.load(car);
        }
    }

    public Car unload() {
        if (!attachment.attachmentInUse() && this.getCurrentSpeed() == 0) {
            return loadable.unload();
        }
        return null;
    }

    @Override
    public void move(){
        super.move();
        this.loadable.move(this.getX(), this.getY());
        for (int i = 0; i < loadable.nrOfLoadedCars(); i++){
            Car car = loadable.getLoadedCars().get(i);
            car.setX(loadable.getX());
            car.setY(loadable.getY());
        }
    }
}
