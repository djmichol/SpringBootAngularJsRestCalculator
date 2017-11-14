package pl.michol.calculator.engine.algorithms.model;

public class SortResponse {

    private Double[] result;
    private Long time;

    public Double[] getResult() {
        return result;
    }

    public void setResult(Double[] result) {
        this.result = result;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public SortResponse(Double[] result, Long time) {
        this.result = result;
        this.time = time;
    }

    public SortResponse() {
    }
}
