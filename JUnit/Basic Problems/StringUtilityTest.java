import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class StringUtilityTest {
    static class StringUtils {
        public String reverse(String str)
        {
            return new StringBuilder(str).reverse().toString();
        }
        public boolean isPalindrome(String str)
        {
            String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
        }
        public String toUpperCase(String str)
        {
            return str.toUpperCase();
        }
    }
    StringUtils utils = new StringUtils();
    @Test
    public void testReverse()
    {
        assertEquals("dcba", utils.reverse("abcd"));
        assertEquals("!dlroW ,olleH", utils.reverse("Hello, World!"));
    }
    @Test
    public void testIsPalindrome()
    {
        assertTrue(utils.isPalindrome("madam"));
        assertTrue(utils.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(utils.isPalindrome("hello"));
    }
    @Test
    public void testToUpperCase()
    {
        assertEquals("HELLO", utils.toUpperCase("hello"));
        assertEquals("JAVA", utils.toUpperCase("Java"));
    }
}
