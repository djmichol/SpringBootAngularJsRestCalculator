package pl.michol.calculator;

import org.junit.Assert;
import org.junit.Test;
import pl.michol.calculator.engine.ONPCalculator;

public class CalculateTest {

    private static final String VALID_ONP = "12 2 3 4 * 10 5 / + * +";
    private static final Double VALID_RESULT = 40d;

    @Test
    public void validONPValidResultTest() {
        ONPCalculator onpCalculator = new ONPCalculator();
        Double result = onpCalculator.calculate(VALID_ONP);
        Assert.assertEquals(VALID_RESULT, result);
    }

}
