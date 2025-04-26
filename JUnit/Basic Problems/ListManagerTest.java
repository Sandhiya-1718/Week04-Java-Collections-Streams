import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
public class ListManagerTest {
    static class ListManager
    {
        public void addElement(List<Integer> list, int element)
        {
            list.add(element);
        }
        public void removeElement(List<Integer> list, int element)
        {
            list.remove(Integer.valueOf(element));
        }
        public int getSize(List<Integer> list)
        {
            return list.size();
        }
    }
    ListManager manager = new ListManager();
    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        manager.addElement(list, 20);
        assertEquals(2, list.size());
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }
    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        manager.removeElement(list, 10);
        assertEquals(1, list.size());
        assertFalse(list.contains(10));
        assertTrue(list.contains(20));
    }
    @Test
    public void testGetSize()
    {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, manager.getSize(list));
        list.add(1);
        list.add(2);
        assertEquals(2, manager.getSize(list));
    }
}
