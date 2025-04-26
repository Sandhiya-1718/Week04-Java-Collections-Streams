import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class DatabaseConnectionTest {
    static class DatabaseConnection
    {
        private boolean connected;
        public void connect()
        {
            connected = true;
            System.out.println("Connected to the database.");
        }
        public void disconnect()
        {
            connected = false;
            System.out.println("Disconnected from the database.");
        }
        public boolean isConnected()
        {
            return connected;
        }
    }
    DatabaseConnection db;
    @BeforeEach
    public void setUp()
    {
        db = new DatabaseConnection();
        db.connect();
    }
    @AfterEach
    public void tearDown()
    {
        db.disconnect();
    }
    @Test
    public void testConnectionIsEstablished()
    {
        assertTrue(db.isConnected(), "Database should be connected before test");
    }
    @Test
    public void testMultipleConnections()
    {
        assertTrue(db.isConnected(), "Database should be connected in each test");
    }
}
