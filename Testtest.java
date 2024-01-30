import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.awt.*;
public class Testtest {
    //Tester för Car:
    @Test // Testar CarSize
    public void TestCarSize() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals(Car.CarSize.MEDIUM, testVolvo.getSize());
    }

    @Test // Testar bilens färg
    public void TestVolvoColor() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals(Color.blue, testVolvo.getColor());
    }
    @Test // Testar bilens dörrantal
    public void TestVolvoDoor() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals(4, testVolvo.getNrDoors());
    }
    @Test // Testar bilens modell
    public void TestVolvoModel() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals("Volvo240", testVolvo.getModelName());
    }
    @Test // Testar bilens x-position
    public void TestVolvoXEquals12() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals(12, testVolvo.getX());
    }
    @Test // Testar bilens y-position
    public void TestVolvoYequals5() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals(5, testVolvo.getY());
    }
    @Test // Testar ett färgbyte
    public void TestVolvoColorChange() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        testVolvo.setColor(Color.black);
        assertEquals(Color.black, testVolvo.getColor());
    }
    @Test // Testar att svänga vänster och att flytta
    public void TestVolvoTurnLeft() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        testVolvo.incrementSpeed(1);
        testVolvo.turnLeft();
        testVolvo.move();
        assertEquals(10.75, testVolvo.getX());
    }


    @Test // Testar att svänga höger och att flytta
    public void TestVolvoTurnRight() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        testVolvo.gas(1);
        testVolvo.turnRight();
        testVolvo.move();
        assertEquals( 13.25, testVolvo.getX());
    }


    @Test // Testar bromsen
    public void TestVolvoBrake() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        testVolvo.gas(1);
        testVolvo.brake(1);
        testVolvo.move();
        assertEquals( 5, testVolvo.getY());
    }


    @Test // Testar att svänga höger två gånger (vända) och att köra iväg
    public void TestVolvoTurnRightTwice() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        testVolvo.gas(1);
        testVolvo.gas(1);
        testVolvo.turnRight();
        testVolvo.turnRight();
        testVolvo.move();
        assertEquals( 2.5, testVolvo.getY());
    }


    @Test //Testar att sätta på Saab-Turbo
    public void TestSaabTurboOn() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.turbocar.setTurboOn();
        assertEquals(1.3, testSaab.turbocar.getTurbo());
    }


    @Test // Testar att sätta av Saab-Turbo
    public void TestSaabTurboOff() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.turbocar.setTurboOff();
        assertEquals(1, testSaab.turbocar.getTurbo());
    }


    @Test // Testar speedFactor med Turbo
    public void TestSaabSpeedfactor() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.turbocar.setTurboOn();
        assertEquals(1.625, testSaab.speedFactor());
    }


    @Test // Testar att flytta en Saab (x)
    public void TestSaabSetX() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.setX(7);
        assertEquals(7, testSaab.getX());
    }


    @Test // Testar att flytta en Saab (y)
    public void TestSaabSetY() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.setY(7);
        assertEquals(7, testSaab.getY());
    }


    @Test // Testar att flytta en Saabs riktning
    public void TestSaabSetAngle() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.setDirection(Math.PI/2);
        assertEquals(Math.PI/2, testSaab.getDirection());
    }


    @Test //Testar att sätta på motorn
    public void TestSaabStartEngine() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.startEngine();
        assertEquals(0.1, testSaab.getCurrentSpeed());
    }


    @Test //Testar att stänga av motorn
    public void TestSaabStopEngine() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.startEngine();
        testSaab.stopEngine();
        assertEquals(0, testSaab.getCurrentSpeed());
    }


    //Tester För Scania
    @Test //Testar Scanias Plattform-logik, en flytt bör gå men inte andra
    public void TestScaniaPlatform() {
        Scania testScania = new Scania(Color.blue, 4, 5);
        testScania.raisePlatform();
        testScania.lowerPlatform();
        testScania.gas(1);
        testScania.move();
        testScania.stopEngine();
        testScania.raisePlatform();
        testScania.move();
        assertEquals(10.5, testScania.getY());
    }


    // Tester för CarTransporter
    @Test // Testar att lasta en bil utanför radien
    public void TestCarDistance() {
        CarTransporter<Car> newCar = new CarTransporter<>(2,  Color.black, 4, 5);
        Volvo240 volvo240 = new Volvo240(Color.black, 7, 6);
        newCar.load(volvo240);
        assertEquals(0, newCar.loadable.nrOfLoadedCars());
    }
    @Test //Testar att lasta av en bil - LIFO
    public void TestLastIndexIsRemoved() {
        CarTransporter<Car> newTransporter = new CarTransporter<>(2, Color.black, 4, 5);
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6);
        Saab95 saab95 = new Saab95(Color.blue, 6, 5);
        newTransporter.load(saab95);
        newTransporter.load(volvo240);
        assertEquals(volvo240, newTransporter.unload());
    }
    @Test //Testar att bilen lastas av på rätt position
    public void TestCarIsAtRightSpotWhenUnloading() {
        CarTransporter<Car> newTransporter = new CarTransporter<>(2, Color.black, 4, 5);
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6);
        Saab95 saab95 = new Saab95(Color.blue, 6, 5);
        newTransporter.load(saab95);
        newTransporter.load(volvo240);
        newTransporter.unload();
        assertEquals(6, volvo240.getX());
    }
    @Test //Testar att det inte går att lasta mer än maxLoad
    public void TestCarLoadMaximized() {
        CarTransporter<Car> newTransporter = new CarTransporter<>(1, Color.black, 4, 5);
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6); // radie på sqrt(2) från truck, ok
        Saab95 saab95 = new Saab95(Color.blue, 6, 5);
        newTransporter.load(saab95);
        newTransporter.load(volvo240);
        assertEquals(1, newTransporter.loadable.nrOfLoadedCars());
    }
    @Test //Testar att det inte går att lasta när flaket används
    public void TestLoadWhenFlatbedUp() {
        CarTransporter<Car> newTransporter = new CarTransporter<>(2, Color.black, 4, 5);
        newTransporter.raiseFlatbed();
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6);
        newTransporter.load(volvo240);
        assertEquals(0, newTransporter.loadable.nrOfLoadedCars());
    }
    @Test //Testar att höja och sänka flatbed
    public void TestFlipFlatbedTwice() {
        CarTransporter<Car> newTransporter = new CarTransporter<>(2, Color.black, 4, 5);
        newTransporter.raiseFlatbed();
        newTransporter.lowerFlatbed();
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6); // radie på sqrt(2) från truck, ok
        newTransporter.load(volvo240);
        assertEquals(1, newTransporter.loadable.nrOfLoadedCars());
    }
    @Test // Testar att flatbed har rätt states
    public void TestFlatbedState() {
        CarTransporter<Car> newTransporter = new CarTransporter<>(2, Color.black, 4, 5);
        newTransporter.raiseFlatbed();
        newTransporter.lowerFlatbed();
        assertEquals(0, newTransporter.attachment.getState());
    }
    @Test //Testar att bilen flyttas med transportören
    public void TestTransporterAndCarSameX() {
        CarTransporter<Car> newTransporter = new CarTransporter<>(2, Color.black, 4, 5);
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6); // radie på sqrt(2) från truck, ok
        newTransporter.load(volvo240);
        newTransporter.gas(1);
        newTransporter.move();
        assertEquals(newTransporter.getX(), volvo240.getX());
    }
    @Test //Testar att flatbed flyttas rätt
    public void TestFlatbedMovingWithTransporter() {
        CarTransporter<Car> newTransporter = new CarTransporter<>(2, Color.black, 4, 5);
        newTransporter.gas(1);
        newTransporter.move();
        assertEquals(10.5, newTransporter.loadable.getY());
    }


    @Test // Testar att en plattform inte kan nå över 70 grader
    public void TestAngleNotExceeding70() {
        Scania testScania = new Scania(Color.blue, 4, 5);
        for (int i = 0; i < 10; i++) {
            testScania.raisePlatform();
        }
        assertEquals(70, testScania.attachment.getState());


    }
    @Test // Testar att en plattform inte kan nå under 0 grader
    public void TestAngleNotLessThan0() {
        Scania testScania = new Scania(Color.blue, 4, 5);
        for (int i = 0; i < 10; i++) {
            testScania.lowerPlatform();
        }
        assertEquals(0, testScania.attachment.getState());


    }
    @Test // Testar att lasta en Scania på en CarTransporter
    public void TestLoadTruck() {
        CarTransporter <Car> testTruck = new CarTransporter<>(2, Color.black, 4, 5);
        Scania testScania = new Scania(Color.blue, 4, 5);
        testTruck.load(testScania);
        assertEquals(0, testTruck.loadable.nrOfLoadedCars());
    }


    // Testar för CarShop
    @Test // Testar position efter avlastning från en verkstad
    public void TestCarShopUnloadingPosition() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 0, 0);
        CarShop<Volvo240> testShop = new CarShop<>(2, 0, 0);
        testShop.load(testVolvo);
        testShop.unload();
        assertEquals(2, testVolvo.getY());
    }

    @Test // Testar att en bil inte kan lastas in i en full verkstad
    public void TestRightAmountOfCars(){
        CarShop<Car> testShop = new CarShop<>(2, 2, 4);
        Volvo240 volvo240 = new Volvo240(Color.black, 2,5);
        Saab95 saab95 = new Saab95(Color.blue, 3,4);
        Scania scania = new Scania(Color.blue, 5,6);
        testShop.load(volvo240);
        testShop.load(saab95);
        testShop.load(scania);
        assertEquals(2, testShop.loadable.nrOfLoadedCars());
    }
    @Test // Testar en allmän verkstad
    public void TestUnloadCarType(){
        CarShop<Car> testShop = new CarShop<>(2, 2, 4);
        Volvo240 volvo240 = new Volvo240(Color.black, 2,5);
        Saab95 saab95 = new Saab95(Color.blue, 3,4);
        testShop.load(volvo240);
        testShop.load(saab95);
        Car car = testShop.unload();
        assertEquals(Saab95.class, car.getClass());
    }
    @Test //Testar en Volvo-verkstad - bör inte kunna ta emot Saab
    public void VolvoCarShop(){
        CarShop<Volvo240> testShop = new CarShop<>(2, 2, 4);
        Volvo240 volvo240 = new Volvo240(Color.black, 2,5);
        Saab95 saab95 = new Saab95(Color.blue, 3,4);
        testShop.load(volvo240);
        // testShop.load(saab95); Om denna avkommenteras, varnas det för fel biltyp
        assertEquals(1, testShop.loadable.nrOfLoadedCars());


    }


}