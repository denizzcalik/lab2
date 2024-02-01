import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;

public class Saab95Test {
    private Saab95 testSaab;

    @BeforeEach
    public void setUp() {
        testSaab = new Saab95(Color.blue, 12, 5);
    }

    @Test //Testar att sätta på Saab-Turbo
    public void TestSaabTurboOn() {
        testSaab.turbocar.setTurboOn();
        assertEquals(1.3, testSaab.turbocar.getTurbo());
    }


    @Test // Testar att sätta av Saab-Turbo
    public void TestSaabTurboOff() {
        testSaab.turbocar.setTurboOff();
        assertEquals(1, testSaab.turbocar.getTurbo());
    }


    @Test // Testar speedFactor med Turbo
    public void TestSaabSpeedfactor() {
        testSaab.turbocar.setTurboOn();
        assertEquals(1.625, testSaab.speedFactor());
    }


    @Test // Testar att flytta en Saab (x)
    public void TestSaabSetX() {
        testSaab.setX(7);
        assertEquals(7, testSaab.getX());
    }


    @Test // Testar att flytta en Saab (y)
    public void TestSaabSetY() {
        testSaab.setY(7);
        assertEquals(7, testSaab.getY());
    }


    @Test // Testar att flytta en Saabs riktning
    public void TestSaabSetAngle() {
        testSaab.setDirection(Math.PI/2);
        assertEquals(Math.PI/2, testSaab.getDirection());
    }


    @Test //Testar att sätta på motorn
    public void TestSaabStartEngine() {
        testSaab.startEngine();
        assertEquals(0.1, testSaab.getCurrentSpeed());
    }


    @Test //Testar att stänga av motorn
    public void TestSaabStopEngine() {
        testSaab.startEngine();
        testSaab.stopEngine();
        assertEquals(0, testSaab.getCurrentSpeed());
    }
}