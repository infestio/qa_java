package qa_java_tests;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatReturnCorrectFoodTypesDoneTest() throws Exception {
        List<String> expectedFoodTypes = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodTypes = feline.eatMeat();
        Assert.assertEquals(expectedFoodTypes, actualFoodTypes);
    }

    @Test
    public void getKittensWithCountPositiveTest() {
        int expectedCountKitten = 2;
        int actualCountKitten = feline.getKittens(2);
        Assert.assertEquals(expectedCountKitten, actualCountKitten);
    }

    @Test
    public void getFamilyReturnCorrectNameFamilyDoneTest() {
        String expectedNameFamily = "Кошачьи";
        String actualNameFamily = feline.getFamily();
        Assert.assertEquals(expectedNameFamily, actualNameFamily);
    }

    @Test
    public void getKittensNoParamPositiveTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
}
