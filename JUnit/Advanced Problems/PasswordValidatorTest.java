import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PasswordValidatorTest {
    public boolean isValidPassword(String password)
    {
        if (password == null)
            return false;
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
    }
    @Test
    public void testValidPassword()
    {
        PasswordValidatorTest validator = new PasswordValidatorTest();
        assertTrue(validator.isValidPassword("Password1"));
    }
    @Test
    public void testInvalidPasswordTooShort()
    {
        PasswordValidatorTest validator = new PasswordValidatorTest();
        assertFalse(validator.isValidPassword("Pass1"));
    }
    @Test
    public void testInvalidPasswordNoUppercase()
    {
        PasswordValidatorTest validator = new PasswordValidatorTest();
        assertFalse(validator.isValidPassword("password1"));
    }
    @Test
    public void testInvalidPasswordNoDigit()
    {
        PasswordValidatorTest validator = new PasswordValidatorTest();
        assertFalse(validator.isValidPassword("Password"));
    }
    @Test
    public void testInvalidPasswordNull()
    {
        PasswordValidatorTest validator = new PasswordValidatorTest();
        assertFalse(validator.isValidPassword(null));
    }
    @Test
    public void testValidPasswordWithSpecialCharacters()
    {
        PasswordValidatorTest validator = new PasswordValidatorTest();
        assertTrue(validator.isValidPassword("ValidPassword1!"));
    }
}
