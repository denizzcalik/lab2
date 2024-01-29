public class CarShop{

    protected Loadable loadable;
    private Class<?> acceptedCarType;

    public CarShop(int capacity, double x, double y){
        this.loadable = new Loadable(capacity, x, y);
        this.acceptedCarType = Car.class;
    }


    public CarShop(int capacity, double x, double y, Class<?> acceptedCarType){
        this.loadable = new Loadable(capacity, x, y);
        this.acceptedCarType = acceptedCarType;
    }

    public void load(Car car) {
        if (acceptedCarType.isInstance(car)) {
            loadable.load(car);
        } else {
            throw new IllegalArgumentException("Invalid car type");
        }
    }

    public Car unload() {
        return loadable.unload();
    }

}
