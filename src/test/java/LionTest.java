import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private Predator predator;

    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(predator.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", predator);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", predator);
        assertEquals(predator.eatMeat(), lion.getFood());
    }

    @Test
    public void testGetFoodThrowsException() {
        assertThrows(Exception.class, () -> {
            new Lion("Неправильный пол", predator);
        });
    }

    @Test
    public void testLionHasManeWhenMale() throws Exception {
        Lion lion = new Lion("Самец", predator);
        assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void testLionDoesNotHaveManeWhenFemale() throws Exception {
        Lion lion = new Lion("Самка", predator);
        assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void testLionThrowsExceptionForInvalidSex() {
        assertThrows(Exception.class, () -> {
            new Lion("Неправильный пол", predator);
        });
    }
}
