import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ExceptionTest {
    static int divide(int a, int b)
    {
        if (b == 0)
            throw new ArithmeticException("Division by zero is not allowed");
        return a / b;
    }
    @Test
    public void testDivideNormal()
    {
        assertEquals(2, divide(10, 5));
    }
    @Test
    public void testDivideByZero()
    {
        try
        {
            divide(10, 0);
            fail("Expected ArithmeticException was not thrown.");
        }
        catch (ArithmeticException e)
        {
            assertEquals("Division by zero is not allowed", e.getMessage());
        }
    }
}