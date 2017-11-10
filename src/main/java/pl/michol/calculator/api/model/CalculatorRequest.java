package pl.michol.calculator.api.model;

import java.io.Serializable;

public class CalculatorRequest implements Serializable{

    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "CalculatorRequest{" +
                "operation='" + operation + '\'' +
                '}';
    }
}
