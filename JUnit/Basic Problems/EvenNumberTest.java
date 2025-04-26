import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class EvenNumberTest {
    public static boolean isEven(int number)
    {
        return number % 2 == 0;
    }
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEven_TrueCases(int num)
    {
        assertTrue(isEven(num), num + " should be even");
    }
    @ParameterizedTest
    @ValueSource(ints = {7, 9, 11})
    public void testIsEven_FalseCases(int num)
    {
        assertFalse(isEven(num), num + " should be odd");
    }
}
