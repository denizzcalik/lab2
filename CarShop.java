public class CarShop <T extends Car>{

    protected Loadable <T> loadable;

    public CarShop(int capacity, double x, double y){
        this.loadable = new Loadable<>(capacity, x, y);
    }
    
    public void load(T vehicle) {
        loadable.load(vehicle);
    }

    public T unload() {
        return loadable.unload();
    }


}
