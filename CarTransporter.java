import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CarTransporter extends Truck implements CarLoading {
    private final int maxLoad;
    private final ArrayList<Car> loadedCars;
    private static final double loadingRadius = 3; //Kan såklart ändras eller läggas in i CarTransporter, men tänkte att det är samma för alla


    public CarTransporter(int maxLoad, Color color, int x, int y) {
        super(2, 550, color, "CarTransporter", x, y, new Flatbed());
        this.maxLoad = maxLoad;
        this.loadedCars = new ArrayList<>();
    }
    public void raiseFlatbed() {
        if (getCurrentSpeed() == 0) {
            this.attachment.raiseAttachment();
        }
    }

    public void lowerFlatbed() {
        if (getCurrentSpeed() == 0) {
            this.attachment.lowerAttachment();
        }
    }

    @Override
    public void load(Car car) {
        if (canLoad(car)) {
            loadedCars.add(car);
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }

    public void unload() {
        if (!attachment.attachmentInUse() && this.getCurrentSpeed() == 0) {
            loadable.unload();
        }
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
