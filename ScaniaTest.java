import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;
public class ScaniaTest {
    private Scania testScania;

    @BeforeEach
    public void setUp() {
        testScania = new Scania(Color.blue, 12, 5);
    }
    @Test //Testar Scanias Plattform-logik, en flytt bör gå men inte andra
    public void TestScaniaPlatform() {
        testScania.raiseAttachment();
        testScania.lowerAttachment();
        testScania.gas(1);
        testScania.move();
        testScania.stopEngine();
        testScania.raiseAttachment();
        testScania.move();
        assertEquals(10.5, testScania.getY());
    }
    @Test // Testar att en plattform inte kan nå över 70 grader
    public void TestAngleNotExceeding70() {
        for (int i = 0; i < 10; i++) {
            testScania.raiseAttachment();
        }
        assertEquals(70, testScania.attachment.getState());

    }
    @Test // Testar att en plattform inte kan nå under 0 grader
    public void TestAngleNotLessThan0() {
        for (int i = 0; i < 10; i++) {
            testScania.lowerAttachment();
        }
        assertEquals(0, testScania.attachment.getState());

    }
    @Test
    public void TestGasWhenPlatformInUse(){
        testScania.raiseAttachment();
        testScania.gas(1);
        assertEquals(0,testScania.speedFactor());
    }
}
