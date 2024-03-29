import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class CarTransporter <T extends Car> extends Truck{


    protected Loadable <T> loadable;


    public CarTransporter(int maxLoad, Color color, int x, int y) {
        super(2, 550, color, "Car Transporter", x, y, new Flatbed());
        this.loadable = new Loadable(maxLoad, x, y);
    }

    public void load(T car) {
        if (!attachment.attachmentInUse() && this.getCurrentSpeed() == 0 && !(car instanceof Truck)){
            loadable.load(car);
        }
    }
    public Car unload() {
        if (!attachment.attachmentInUse() && this.getCurrentSpeed() == 0) {
            return loadable.unload();
        }
        throw new IllegalArgumentException("The flatbed is either in use or the truck is moving");
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
