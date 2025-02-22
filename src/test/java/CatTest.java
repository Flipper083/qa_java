import com.example.Cat;
import com.example.Feline;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    private Cat cat;
    private Feline mockFeline;

    @Before
    public void setUp() {
        mockFeline = Mockito.mock(Feline.class);
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Мясо"));

        List<String> food = cat.getFood();
        assertNotNull(food);
        assertTrue(food.contains("Мясо"));
    }
}
