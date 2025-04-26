import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TemperatureConverterTest {
    public double celsiusToFahrenheit(double celsius)
    {
        return (celsius * 9/5) + 32;
    }
    public double fahrenheitToCelsius(double fahrenheit)
    {
        return (fahrenheit - 32) * 5/9;
    }
    @Test
    public void testCelsiusToFahrenheit()
    {
        TemperatureConverterTest converter = new TemperatureConverterTest();
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.001);
        assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.001);
    }
    @Test
    public void testFahrenheitToCelsius()
    {
        TemperatureConverterTest converter = new TemperatureConverterTest();
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.001);
        assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.001);
    }
    @Test
    public void testExtremeTemperatures()
    {
        TemperatureConverterTest converter = new TemperatureConverterTest();
        assertEquals(1000, converter.celsiusToFahrenheit(537.7778), 0.001);
        assertEquals(537.7778, converter.fahrenheitToCelsius(1000), 0.001);
    }
    @Test
    public void testNegativeTemperatures()
    {
        TemperatureConverterTest converter = new TemperatureConverterTest();
        assertEquals(-22, converter.celsiusToFahrenheit(-30), 0.001);
        assertEquals(-30, converter.fahrenheitToCelsius(-22), 0.001);
    }
}
