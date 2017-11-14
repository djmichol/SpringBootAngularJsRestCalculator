package pl.michol.calculator.engine.algorithms.model;

public class SortRequest {

    private Double[] array;

    public SortRequest(Double[] array) {
        this.array = array;
    }

    public SortRequest() {
    }

    public Double[] getArray() {
        return array;
    }

    public void setArray(Double[] array) {
        this.array = array;
    }
}
