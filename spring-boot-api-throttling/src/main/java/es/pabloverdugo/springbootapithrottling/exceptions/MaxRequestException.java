package es.pabloverdugo.springbootapithrottling.exceptions;

public class MaxRequestException extends RuntimeException {

    private int max;
    private int total;
    private int period;

    public MaxRequestException(int max, int total, int period) {
        this.max = max;
        this.total = total;
        this.period = period;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String getMessage() {
        return "Max request reached." + this.getMax() + " from a total of " + this.getTotal();
    }

}
