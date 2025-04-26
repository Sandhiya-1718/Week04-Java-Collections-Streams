import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
public class FileProcessorTest {
    static class FileProcessor
    {
        public void writeToFile(String filename, String content) throws IOException
        {
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
        }
        public String readFromFile(String filename) throws IOException
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
                content.append(line);
            reader.close();
            return content.toString();
        }
    }
    FileProcessor processor;
    String testFile = "testfile.txt";
    @BeforeEach
    public void setUp()
    {
        processor = new FileProcessor();
    }
    @AfterEach
    public void cleanUp()
    {
        try
        {
            Files.deleteIfExists(Paths.get(testFile));
        }
        catch (IOException e)
        {
            System.out.println("Cleanup failed: " + e.getMessage());
        }
    }
    @Test
    public void testWriteAndReadFile() throws IOException
    {
        String content = "Hello, File!";
        processor.writeToFile(testFile, content);
        String readContent = processor.readFromFile(testFile);
        assertEquals(content, readContent);
    }
    @Test
    public void testFileExistsAfterWrite() throws IOException
    {
        processor.writeToFile(testFile, "Check existence");
        assertTrue(Files.exists(Paths.get(testFile)));
    }
    @Test
    public void testReadNonExistentFileThrowsException()
    {
        try
        {
            processor.readFromFile("nonexistent.txt");
            fail("Expected IOException not thrown");
        }
        catch (IOException e)
        {
            assertInstanceOf(FileNotFoundException.class, e);
        }
    }
}
