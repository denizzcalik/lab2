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

    @Override
    public Car unload() {
        if (!loadedCars.isEmpty() && !attachment.attachmentInUse() && this.getCurrentSpeed() == 0) {
            Car car = loadedCars.removeLast();
            car.setX(this.getX() + 2); // Tog nåt godtyckligt
            car.setY(this.getY() + 2);
            return car;
        }
        return null;
    }

    @Override
    public List<Car> getLoadedCars() {
        return new ArrayList<>(loadedCars);
    }
    public int nrOfLoadedCars(){
        return getLoadedCars().size();
    }

    private boolean canLoad(Car car) {
        if (loadedCars.size() >= maxLoad || attachment.attachmentInUse() || this.getCurrentSpeed() != 0) {
            return false;
        }

        double distance = Math.sqrt(Math.pow(this.getX() - car.getX(), 2) + Math.pow(this.getY() - car.getY(), 2));
        return distance <= loadingRadius && !(car instanceof CarTransporter);
    }
}
