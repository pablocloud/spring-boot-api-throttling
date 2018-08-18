package es.pabloverdugo.springbootapithrottling.domain;

public abstract class ApiThrottles {

    private Integer perSecond;
    private Integer perMinute;
    private Integer perHour;
    private Integer perDay;

    public ApiThrottles() {

    }

    public ApiThrottles(Integer perSecond, Integer perMinute, Integer perHour, Integer perDay) {
        this.perSecond = perSecond;
        this.perMinute = perMinute;
        this.perHour = perHour;
        this.perDay = perDay;
    }

    public Integer getPerSecond() {
        return perSecond;
    }

    public void setPerSecond(Integer perSecond) {
        this.perSecond = perSecond;
    }

    public Integer getPerMinute() {
        return perMinute;
    }

    public void setPerMinute(Integer perMinute) {
        this.perMinute = perMinute;
    }

    public Integer getPerHour() {
        return perHour;
    }

    public void setPerHour(Integer perHour) {
        this.perHour = perHour;
    }

    public Integer getPerDay() {
        return perDay;
    }

    public void setPerDay(Integer perDay) {
        this.perDay = perDay;
    }

}
