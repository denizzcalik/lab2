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
}
