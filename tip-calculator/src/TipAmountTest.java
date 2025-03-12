import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TipAmountTest {
    @Test
    void shouldReturnSumOfTheArray() {
        //given
        int[] array = {25, 25, 25, 25};
        //when
        int result = TipCalculator.calculateCosts(array);
        //than
        Assertions.assertEquals(100, result);
    }

    @Test
    void tenPercentShouldReturnTen() {
        //given
        int[] totalCost = {25, 25, 25, 25};
        int tipPercentage = 10;
        //when
        int result = TipCalculator.calculateTipAmount(totalCost, tipPercentage);
        //than
        Assertions.assertEquals(10, result);
    }

    @Test
    void eightyPercentShouldReturnEighty() {
        //given
        int[] totalCost = {25, 25, 25, 25};
        int tipPercentage = 80;
        //when
        int result = TipCalculator.calculateTipAmount(totalCost, tipPercentage);
        //than
        Assertions.assertEquals(80, result);
    }

    @Test
    void ninePercentShouldReturnNine() {
        //given
        int[] totalCost = {25, 25, 25, 25};
        int tipPercentage = 9;
        //when
        int result = TipCalculator.calculateTipAmount(totalCost, tipPercentage);
        //than
        Assertions.assertEquals(-1, result);
    }

    @Test
    void eightyOnePercentShouldReturnEightyOne() {
        //given
        int[] totalCost = {25, 25, 25, 25};
        int tipPercentage = 81;
        //when
        int result = TipCalculator.calculateTipAmount(totalCost, tipPercentage);
        //than
        Assertions.assertEquals(-1, result);
    }

    @Test
    void shouldEightyReturnTrue() {
        boolean result = TipCalculator.isTipValid(80);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldTenReturnTrue() {
        boolean result = TipCalculator.isTipValid(10);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldNineReturnFalse() {
        boolean result = TipCalculator.isTipValid(9);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldEightyOneReturnFalse() {
        boolean result = TipCalculator.isTipValid(81);
        Assertions.assertFalse(result);
    }
}

