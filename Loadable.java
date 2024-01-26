import java.util.ArrayList;
import java.util.List;

public class Loadable implements CarLoading{
    private final int maxLoad;
    private final ArrayList<Car> loadedCars;
    private static final double loadingRadius = 3;
    private double x;
    private double y;

    public Loadable(int maxLoad, double x, double y){
        this.maxLoad = maxLoad;
        this.loadedCars = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    public void move(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
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
    public void unload() {
        if (!loadedCars.isEmpty()) {
            Car car = loadedCars.removeLast();
            car.setX(this.getX() + 2); // Tog nåt godtyckligt
            car.setY(this.getY() + 2);
        }
    }

    public List<Car> getLoadedCars() {
        return new ArrayList<>(loadedCars);
    }
    public int nrOfLoadedCars(){
        return getLoadedCars().size();
    }

    public double distanceBetween(Car car) {
        return Math.sqrt(Math.pow(this.getX() - car.getX(), 2) + Math.pow(this.getY() - car.getY(), 2));
    }
    private boolean canLoad(Car car) {
        return loadedCars.size() < maxLoad
                && !(this.distanceBetween(car) >= loadingRadius) && !(car instanceof CarTransporter);
    }



}