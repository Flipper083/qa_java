import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private Lion lion;

    private final String sex;
    private final Object expectedResult;

    public LionParameterizedTest(String sex, Object expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() {
        Feline feline = new Feline();
        try {
            lion = new Lion(sex, feline);
        } catch (Exception exception) {
            String textException = "Используйте допустимые значения пола животного - самец или самка";
            Assert.assertEquals(textException, exception.getMessage());
        }
    }

    @Test
    public void checkDoesHaveManeReturnsNecessaryValue() {
        boolean actualResult = lion.doesHaveMane();
        assertEquals(expectedResult, actualResult);
    }
}