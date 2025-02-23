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
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals("Звук, который издает кот, должен быть 'Мяу'", expectedSound, actualSound);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        List<String> food = cat.getFood();
        assertNotNull("Список пищи не должен быть null", food);
        assertEquals("Список пищи должен содержать 2 элемента", 2, food.size());
        assertTrue("Список пищи должен содержать 'Мясо'", food.contains("Мясо"));
        assertTrue("Список пищи должен содержать 'Рыба'", food.contains("Рыба"));
    }
}