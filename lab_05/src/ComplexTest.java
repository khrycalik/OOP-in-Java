import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest {

    @Test
    public void ComTS() {
        Complex c2 = new Complex(-8.5, -0.9);
        String expectedResult = "-8.5 - 0.9i";
        assertEquals(expectedResult, c2.toString());
    }

    @Test
    public void ComEQ() {
        assertEquals( new Complex(1,1), (new Complex(1,1)));
    }


    @Test
    public void ComHC() {
        assertEquals((new Complex(1,1).hashCode()) , (new Complex(1,1).hashCode()));
    }

    @Test
    public void ComEQ_HC() {
        Complex c1 = new Complex(1,1);
        Complex c2 = new Complex(1,1);

        assertEquals( c1, c2);
        assertEquals(c1.hashCode() , c2.hashCode());
    }
}
