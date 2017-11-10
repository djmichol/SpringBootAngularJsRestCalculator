package pl.michol.calculator.engine;

import org.springframework.stereotype.Component;
import pl.michol.calculator.engine.exception.BadFormatException;
import pl.michol.calculator.engine.utils.CalculateUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@Component
public class ONPCalculator {

    public Double calculate(String onpInput) {
        Stack<Double> tmp = new Stack();
        List<String> input = Arrays.asList(onpInput.split(" "));
        input.stream().forEach(inputString -> {
            Double liczba = CalculateUtils.isDouble(inputString);
            if (liczba != null) {
                tmp.push(liczba);
            } else if (CalculateUtils.isOperator(inputString)) {
                Double l1 = tmp.pop();
                Double l2 = tmp.pop();
                Double result = makeCalculation(l2, l1, OperatorWithPriority.getValue(inputString));
                if(result==null){
                    throw new BadFormatException();
                }
                tmp.push(result);
            }
        });
        return tmp.pop();
    }

    private Double makeCalculation(Double o1, Double o2, OperatorWithPriority operator) {
        switch (operator) {
            case PLUS:
                return o1 + o2;
            case MINUS:
                return o1 - o2;
            case DIVINE:
                return o1 / o2;
            case POWER:
                return Math.pow(o1, o2);
            case MULTIPLY:
                return o1 * o2;
            case MOD:
                return o1 % o2;
            default:
                return null;
        }
    }
}
