package pl.michol.calculator.engine.utils;

import pl.michol.calculator.engine.OperatorWithPriority;

public class CalculateUtils {

    public static boolean isOperator(String oper) {
        if (OperatorWithPriority.DIVINE.getOperator().equals(oper)
                || OperatorWithPriority.MINUS.getOperator().equals(oper)
                || OperatorWithPriority.MOD.getOperator().equals(oper)
                || OperatorWithPriority.MULTIPLY.getOperator().equals(oper)
                || OperatorWithPriority.PLUS.getOperator().equals(oper)
                || OperatorWithPriority.POWER.getOperator().equals(oper)) return true;
        return false;
    }

    public static Double isDouble(String input) {
        try {
            Double output = Double.valueOf(input);
            return output;
        } catch (Exception e) {
            return null;
        }
    }
}
