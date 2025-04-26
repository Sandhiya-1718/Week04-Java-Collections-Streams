import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;
public class UserRegistrationTest {
    public void registerUser(String username, String email, String password)
    {
        if (username == null || username.isEmpty())
            throw new IllegalArgumentException("Username cannot be empty.");
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (email == null || !Pattern.matches(emailRegex, email))
            throw new IllegalArgumentException("Invalid email format.");
        if (password == null || password.length() < 6)
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
    }
    @Test
    public void testValidRegistration()
    {
        UserRegistrationTest registration = new UserRegistrationTest();
        registration.registerUser("validUser", "user@example.com", "password123");
    }
    @Test
    public void testEmptyUsername()
    {
        UserRegistrationTest registration = new UserRegistrationTest();
        try
        {
            registration.registerUser("", "user@example.com", "password123");
            fail("Exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Username cannot be empty.", e.getMessage());
        }
    }
    @Test
    public void testInvalidEmailFormat()
    {
        UserRegistrationTest registration = new UserRegistrationTest();
        try
        {
            registration.registerUser("validUser", "invalidEmail", "password123");
            fail("Exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Invalid email format.", e.getMessage());
        }
    }
    @Test
    public void testShortPassword()
    {
        UserRegistrationTest registration = new UserRegistrationTest();
        try
        {
            registration.registerUser("validUser", "user@example.com", "123");
            fail("Exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Password must be at least 6 characters long.", e.getMessage());
        }
    }
    @Test
    public void testNullUsername()
    {
        UserRegistrationTest registration = new UserRegistrationTest();
        try
        {
            registration.registerUser(null, "user@example.com", "password123");
            fail("Exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Username cannot be empty.", e.getMessage());
        }
    }
    @Test
    public void testNullEmail()
    {
        UserRegistrationTest registration = new UserRegistrationTest();
        try
        {
            registration.registerUser("validUser", null, "password123");
            fail("Exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Invalid email format.", e.getMessage());
        }
    }
    @Test
    public void testNullPassword()
    {
        UserRegistrationTest registration = new UserRegistrationTest();
        try
        {
            registration.registerUser("validUser", "user@example.com", null);
            fail("Exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Password must be at least 6 characters long.", e.getMessage());
        }
    }
}
