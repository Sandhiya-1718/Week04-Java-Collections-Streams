import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class CalculatorTest {
    static class Calculator{
        public int add(int a,int b)
        {
            return a+b;
        }
        public int subtract(int a,int b)
        {
            return a-b;
        }
        public int multiply(int a,int b)
        {
            return a*b;
        }
        public int divide(int a,int b)
        {
            if(b==0)
                throw new ArithmeticException("Cannot divide by zero");
            return a/b;
        }
    }
    Calculator calculator=new Calculator();
    @Test
    public void testAdd()
    {
        assertEquals(8,calculator.add(5,3));
    }
    @Test
    public void testSubtract()
    {
        assertEquals(2,calculator.subtract(5,3));
    }
    @Test
    public void testMultiply()
    {
        assertEquals(15, calculator.multiply(5,3));
    }
    @Test
    public void testDivide()
    {
        assertEquals(2,calculator.divide(6,3));
    }
    @Test
    public void testDivideByZero()
    {
        try
        {
            calculator.divide(10,0);
            fail("Expected ArithmeticException not thrown.");
        }
        catch (ArithmeticException e)
        {
            assertEquals("Cannot divide by zero",e.getMessage());
        }
    }
}
