import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private Lion lion;

    private final String sex;
    private final boolean expectedResult;

    public LionParameterizedTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() throws Exception {
        Feline feline = new Feline();
        lion = new Lion(sex, feline);
    }

    @Test
    public void checkDoesHaveManeReturnsNecessaryValue() {
        boolean actualResult = lion.doesHaveMane();
        assertEquals(expectedResult, actualResult);
    }
}