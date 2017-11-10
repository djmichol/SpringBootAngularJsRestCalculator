package pl.michol.calculator;

import org.junit.Assert;
import org.junit.Test;
import pl.michol.calculator.engine.InfixToOnpConverter;

public class ToONPConverterTest {

    private static final String ONP = "3 4 2 * 1 5 - 2 ^ / +";
    private static final String Infix = "3 + 4 * 2 / ( 1 - 5 ) ^ 2";

    private static final String Infix2 = "( ( 2 + 7 ) / 3 + ( 14 - 3 ) * 4 ) / 2";
    private static final String ONP2 = "2 7 + 3 / 14 3 - 4 * + 2 /";

    @Test
    public void test(){
        InfixToOnpConverter infixToOnpConverter = new InfixToOnpConverter();
        String result = infixToOnpConverter.convert(Infix);
        Assert.assertEquals(ONP,result);
    }

    @Test
    public void test2(){
        InfixToOnpConverter infixToOnpConverter = new InfixToOnpConverter();
        String result = infixToOnpConverter.convert(Infix2);
        Assert.assertEquals(ONP2,result);
    }

}
