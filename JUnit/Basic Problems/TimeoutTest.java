import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
public class TimeoutTest {
    public String longRunningTask()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        return "Completed";
    }
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testLongRunningTaskTimeout()
    {
        assertEquals("Completed", longRunningTask());
    }
}
