package pl.michol.calculator.api.model;

import java.io.Serializable;

public class CalculatorResponse implements Serializable{

    private Double result;

    public CalculatorResponse(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CalculatorResponse{" +
                "result=" + result +
                '}';
    }
}
