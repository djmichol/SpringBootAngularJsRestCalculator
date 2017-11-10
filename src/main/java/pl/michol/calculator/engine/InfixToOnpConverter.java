package pl.michol.calculator.engine;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.michol.calculator.engine.utils.CalculateUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class InfixToOnpConverter implements Converter<String, String> {

    @Nullable
    @Override
    public String convert(String s) {
        List<String> input = Arrays.asList(s.split(" "));
        Queue<String> resultQueue = new LinkedList();
        Stack<OperatorWithPriority> operatorStack = new Stack();
        input.stream().forEach(inCHar -> {
            Double number = CalculateUtils.isDouble(inCHar);
            if (number != null) {
                resultQueue.add(inCHar);
            } else if (OperatorWithPriority.OPEN_BRACKET.getOperator().equals(inCHar)) {
                operatorStack.push(OperatorWithPriority.OPEN_BRACKET);
            } else if (OperatorWithPriority.CLOSE_BRACKET.getOperator().equals(inCHar)) {
                OperatorWithPriority actualOperator = operatorStack.pop();
                while (!actualOperator.equals(OperatorWithPriority.OPEN_BRACKET) && !operatorStack.isEmpty()) {
                    resultQueue.add(actualOperator.getOperator());
                    actualOperator = operatorStack.pop();
                }
            } else if (CalculateUtils.isOperator(inCHar)) {
                OperatorWithPriority operator = OperatorWithPriority.getValue(inCHar);
                if (operatorStack.isEmpty()) {
                    operatorStack.push(operator);
                } else {
                    OperatorWithPriority o2 = operatorStack.pop();
                    if (operator.getPriority() > o2.getPriority()) {
                        operatorStack.push(o2);
                        operatorStack.push(operator);
                    } else {
                        while (operator.getPriority() <= o2.getPriority() && !operatorStack.isEmpty()) {
                            resultQueue.add(o2.getOperator());
                            o2 = operatorStack.pop();
                        }
                        if (operator.getPriority() > o2.getPriority()) {
                            operatorStack.push(o2);
                        } else {
                            resultQueue.add(o2.getOperator());
                        }
                        operatorStack.push(operator);
                    }
                }
            }
        });
        while (!operatorStack.isEmpty()) {
            resultQueue.add(operatorStack.pop().getOperator());
        }
        return resultQueue.stream().collect(Collectors.joining(" "));
    }
}
