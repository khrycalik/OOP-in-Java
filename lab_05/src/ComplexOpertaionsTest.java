import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexOpertaionsTest {
    @Test
    public void ComOpeAdd() {
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
    
        assertEquals("-6.0 + 12.2i", ComplexOperations.add(c1, c2).toString());
    }

    @Test
    public void ComOpeSub() {
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
    
        assertEquals("11.0 + 14.0i", ComplexOperations.subtract(c1, c2).toString());
    }

    @Test
    public void ComOpeMul() {
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
    
        assertEquals("-9.46 - 113.6i", ComplexOperations.multiply(c1, c2).toString());
    }

    @Test
    public void ComOpeDiv() {
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
    
        assertEquals("-0.4522310429783739 - 1.4932931836846426i", ComplexOperations.divide(c1, c2).toString());
    }
  
}
