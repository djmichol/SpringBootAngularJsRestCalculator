package pl.michol.calculator.engine;

public enum OperatorWithPriority {

    /**
     * ( 	0
     * + - ) 	1
     * / % 	2
     * ^ 	3
     **/

    OPEN_BRACKET("(", 0),
    CLOSE_BRACKET(")", 1),
    PLUS("+", 1),
    MINUS("-", 1),
    MULTIPLY("*", 2),
    DIVINE("/", 2),
    MOD("%", 2),
    POWER("^", 3);

    private final int priority;
    private final String operator;

    OperatorWithPriority(String operator, int priority) {
        this.priority = priority;
        this.operator = operator;
    }

    public int getPriority() {
        return priority;
    }

    public String getOperator() {
        return operator;
    }

    public static OperatorWithPriority getValue(String value) {
        for(OperatorWithPriority e: OperatorWithPriority.values()) {
            if(e.getOperator().equals(value)) {
                return e;
            }
        }
        return null;// not found
    }
}
