import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline(); // Используем реальный экземпляр Feline
    }

    @Test
    public void testGetFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family); // Проверяем, что возвращается правильная семья
    }

    @Test
    public void testGetKittens() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens); // Проверяем, что по умолчанию возвращается 1
    }

    @Test
    public void testGetKittensWithCount() {
        int count = 3;
        int kittensCount = feline.getKittens(count);
        assertEquals(count, kittensCount); // Проверяем, что возвращается переданное количество
    }

    @Test
    public void testEatMeat() throws Exception {
        // Проверяем, что метод eatMeat не выбрасывает исключение и возвращает ожидаемые значения
        List<String> food = feline.eatMeat();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertNotNull(food); // Проверяем, что результат не null
        assertEquals(expectedFood, food); // Сравниваем два списка целиком
    }
}