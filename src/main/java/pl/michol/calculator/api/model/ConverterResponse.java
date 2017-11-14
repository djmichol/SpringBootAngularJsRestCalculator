package pl.michol.calculator.api.model;

public class ConverterResponse {

    private String onp;

    public ConverterResponse(String onp) {
        this.onp = onp;
    }

    public ConverterResponse() {
    }

    public String getOnp() {
        return onp;
    }

    public void setOnp(String onp) {
        this.onp = onp;
    }

    @Override
    public String toString() {
        return "ConverterResponse{" +
                "onp='" + onp + '\'' +
                '}';
    }
}
