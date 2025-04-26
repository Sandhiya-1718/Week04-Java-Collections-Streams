import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateFormatterTest {
    public String formatDate(String inputDate)
    {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException("Invalid date format. Expected format is yyyy-MM-dd.");
        }
    }
    @Test
    public void testValidDate()
    {
        DateFormatterTest formatter = new DateFormatterTest();
        assertEquals("07-05-2025", formatter.formatDate("2025-05-07"));
    }
    @Test
    public void testValidDateWithDifferentDate()
    {
        DateFormatterTest formatter = new DateFormatterTest();
        assertEquals("01-01-2000", formatter.formatDate("2000-01-01"));
    }
    @Test
    public void testInvalidDateFormat()
    {
        DateFormatterTest formatter = new DateFormatterTest();
        try
        {
            formatter.formatDate("07-05-2025"); // Incorrect format
            fail("Exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Invalid date format. Expected format is yyyy-MM-dd.", e.getMessage());
        }
    }
    @Test
    public void testInvalidDateWithWrongMonth()
    {
        DateFormatterTest formatter = new DateFormatterTest();
        try
        {
            formatter.formatDate("2025-13-07");
            fail("Exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Invalid date format. Expected format is yyyy-MM-dd.", e.getMessage());
        }
    }
    @Test
    public void testInvalidDateWithNonExistentDate()
    {
        DateFormatterTest formatter = new DateFormatterTest();
        try
        {
            formatter.formatDate("2025-02-30");
            fail("Exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Invalid date format. Expected format is yyyy-MM-dd.", e.getMessage());
        }
    }
}
