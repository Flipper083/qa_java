import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

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

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualSound)
                .as("Звук, который издает кот, должен быть 'Мяу'")
                .isEqualTo(expectedSound);
        softly.assertAll(); // Проверка всех утверждений
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        List<String> food = cat.getFood();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(food)
                .as("Список пищи не должен быть null")
                .isNotNull();
        softly.assertThat(food.size())
                .as("Список пищи должен содержать 2 элемента")
                .isEqualTo(2);
        softly.assertThat(food)
                .as("Список пищи должен содержать 'Мясо'")
                .contains("Мясо");
        softly.assertThat(food)
                .as("Список пищи должен содержать 'Рыба'")
                .contains("Рыба");
        softly.assertAll(); // Проверка всех утверждений
    }
}