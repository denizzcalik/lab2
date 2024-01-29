import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.awt.*;



public class Testtest {
    @Test
    public void TestVolvoColor() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals(Color.blue, testVolvo.getColor());
    }
    @Test
    public void TestVolvoDoor() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals(4, testVolvo.getNrDoors());
    }
    @Test
    public void TestVolvoModel() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals("Volvo240", testVolvo.getModelName());
    }
    @Test
    public void TestVolvoXequals12() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals(12, testVolvo.getX());
    }
    @Test
    public void TestVolvoYequals5() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        assertEquals(5, testVolvo.getY());
    }
    @Test
    public void TestVolvoColorChange() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        testVolvo.setColor(Color.black);
        assertEquals(Color.black, testVolvo.getColor());
    }
    @Test
    public void TestVolvoTurnLeft() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        testVolvo.incrementSpeed(1);
        testVolvo.turnLeft();
        testVolvo.move();
        assertEquals(10.75, testVolvo.getX());
    }

    @Test
    public void TestVolvoTurnRight() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        testVolvo.gas(1);
        testVolvo.turnRight();
        testVolvo.move();
        assertEquals( 13.25, testVolvo.getX());
    }

    @Test
    public void TestVolvoTurnRightTwice() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 12, 5);
        testVolvo.gas(1);
        testVolvo.gas(1);
        testVolvo.gas(1);
        testVolvo.brake(1);
        testVolvo.turnRight();
        testVolvo.turnRight();
        testVolvo.move();
        assertEquals( 2.5, testVolvo.getY());
    }
    
    @Test
    public void TestSaabTurboOn() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.turbocar.setTurboOn();
        assertEquals(1.3, testSaab.turbocar.getTurbo());
    }

    @Test
    public void TestSaabTurboOff() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.turbocar.setTurboOff();
        assertEquals(1, testSaab.turbocar.getTurbo());
    }

    @Test
    public void TestSaabSpeedfactor() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.turbocar.setTurboOn();
        assertEquals(1.625, testSaab.speedFactor());
    }

    @Test
    public void TestSaabSetX() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.setX(7);
        assertEquals(7, testSaab.getX());
    }

    @Test
    public void TestSaabSetY() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.setY(7);
        assertEquals(7, testSaab.getY());
    }

    @Test
    public void TestSaabSetAngle() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.setDirection(Math.PI/2);
        assertEquals(Math.PI/2, testSaab.getDirection());
    }

    @Test
    public void TestSaabStartEngine() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.startEngine();
        assertEquals(0.1, testSaab.getCurrentSpeed());
    }

    @Test
    public void TestSaabStopEngine() {
        Saab95 testSaab = new Saab95(Color.blue, 12, 5);
        testSaab.startEngine();
        testSaab.stopEngine();
        assertEquals(0, testSaab.getCurrentSpeed());
    }
    @Test
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
    @Test
    public void TestCarPosition() {
        CarTransporter newcar = new CarTransporter(2,  Color.black, 4, 5);
        Volvo240 volvo240 = new Volvo240(Color.black, 7, 6); // radie utanför vad som är ok
        //newcar.raiseFlatbed(); //får ej lasta bilar med flatbed uppe
        newcar.load(volvo240);
        assertEquals(0, newcar.loadable.nrOfLoadedCars());
    }
//    @Test
//    public void TestLastIndexIsRemoved() {
//        CarTransporter newTransporter = new CarTransporter(2,  Color.black, 4, 5);
//        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6); // radie på sqrt(2) från truck, ok
//        Saab95 saab95 = new Saab95(Color.blue, 6,5);
//        newTransporter.load(saab95);
//        newTransporter.load(volvo240);
//        assertEquals(volvo240, newTransporter.unload()); //volvo bör unloadas först, FIFO}
    @Test
    public void TestCarIsAtRightSpotWhenUnloading() {
        CarTransporter newTransporter = new CarTransporter(2, Color.black, 4, 5);
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6); // radie på sqrt(2) från truck, ok
        Saab95 saab95 = new Saab95(Color.blue, 6, 5);
        newTransporter.load(saab95);
        newTransporter.load(volvo240);
        newTransporter.unload();
        assertEquals(6, volvo240.getX());
    }
    @Test
    public void TestCarLoadMaximized() {
        CarTransporter newTransporter = new CarTransporter(1, Color.black, 4, 5);
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6); // radie på sqrt(2) från truck, ok
        Saab95 saab95 = new Saab95(Color.blue, 6, 5);
        newTransporter.load(saab95);
        newTransporter.load(volvo240);
        assertEquals(1, newTransporter.loadable.nrOfLoadedCars());
    }
    @Test
    public void TestLoadWhenFlatbedUp() {
        CarTransporter newTransporter = new CarTransporter(2, Color.black, 4, 5);
        newTransporter.raiseFlatbed();
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6); // radie på sqrt(2) från truck, ok
        newTransporter.load(volvo240);
        assertEquals(0, newTransporter.loadable.nrOfLoadedCars());
    }
    @Test
    public void TestFlipFlatbedTwice() {
        CarTransporter newTransporter = new CarTransporter(2, Color.black, 4, 5);
        newTransporter.raiseFlatbed();
        newTransporter.lowerFlatbed();
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6); // radie på sqrt(2) från truck, ok
        newTransporter.load(volvo240);
        assertEquals(1, newTransporter.loadable.nrOfLoadedCars());
    }
    @Test
    public void TestGas() {
        CarTransporter newTransporter = new CarTransporter(2, Color.black, 4, 5);
        Volvo240 volvo240 = new Volvo240(Color.black, 5, 6); // radie på sqrt(2) från truck, ok
        newTransporter.load(volvo240);
        newTransporter.gas(1);
        newTransporter.move();
        assertEquals(newTransporter.getX(), volvo240.getX());
    }
    @Test
    public void TestSameX() {
        CarTransporter newTransporter = new CarTransporter(2, Color.black, 4, 5);
        newTransporter.gas(1);
        newTransporter.move();
        assertEquals(10.5, newTransporter.loadable.getY());
    }

    @Test
    public void TestVolvoCarShop() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 0, 0);
        Saab95 testSaab = new Saab95(Color.blue, 0, 0);
        CarShop testShop = new CarShop(2, 0, 0, Volvo240.class);
        testShop.load(testVolvo);
 //       testShop.load(testSaab);
        testShop.unload();
        assertEquals(2, testVolvo.getY());
    }

    @Test
    public void TestAllCarShop() {
        Volvo240 testVolvo = new Volvo240(Color.blue, 0, 0);
        Saab95 testSaab = new Saab95(Color.blue, 0, 0);
        CarShop testShop = new CarShop(2, 0, 0);
        testShop.load(testVolvo);
        testShop.load(testSaab);
        testShop.unload();
        testShop.unload();
        Car car = testShop.unload();
        System.out.print(car);
        testShop.unload();
        assertEquals(2, testVolvo.getY());
    }
}
