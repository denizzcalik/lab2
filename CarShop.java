public class CarShop <T extends Car>{


    protected Loadable <T> loadable;
    //private Class<T> acceptedCarType;


    public CarShop(int capacity, double x, double y){
        this.loadable = new Loadable<>(capacity, x, y);
        //this.acceptedCarType = null;
    }




//    public CarShop(int capacity, double x, double y, Class<T> acceptedCarType){
//        this.loadable = new Loadable<>(capacity, x, y);
//        this.acceptedCarType = acceptedCarType;




    public void load(T vehicle) {
        loadable.load(vehicle);
    }


    public T unload() {
        return loadable.unload();
    }


}
