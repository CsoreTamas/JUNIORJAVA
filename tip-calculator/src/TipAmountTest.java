import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TipAmountTest {
    @Test
    void shouldReturnSumOfTheArray() {
        //given
        int[] array = {2000, 1000, 500, 500};
        //when
        int result = TipCalculator.calculateCosts(array);
        //than
        Assertions.assertEquals(4000, result);
    }

    @Test
    void shouldReturnTotalCostAndTipPercentageResult() {
        //given
        int[] totalCost = {2000, 1000, 500, 500};
        int tip = 20;
        //when
        int result = TipCalculator.calculateTipAmount(totalCost, tip);
        //than
        Assertions.assertEquals(800, result);
    }
}


