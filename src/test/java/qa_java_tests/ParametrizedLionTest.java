package qa_java_tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class ParametrizedLionTest {

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Spy
    Feline feline;

    private final String sexLion;
    private final boolean expectedHasMane;

    public ParametrizedLionTest(String sexLion, boolean expectedHasMane) {
        this.sexLion = sexLion;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getCountKittens() {
        return new Object[][] {
                {"Самец",true},
                {"Самка",false},
        };
    }

    @Test
    public void doesHaveManeOrNotLionDoneTest() throws Exception {
        Lion lion = new Lion(feline, sexLion);
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals(expectedHasMane, actualResult);

    }
}
