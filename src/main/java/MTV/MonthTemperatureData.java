package MTV;

public class MonthTemperatureData {

    private Integer year;
    private Integer month;
    private Float min;
    private Float max;
    private Float tempVariance;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getTempVariance() {
        return tempVariance;
    }

    public void setTempVariance(Float tempVariance) {
        this.tempVariance = tempVariance;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer("   ")
            .append(year)
            .append("  ")
            .append(month)
            .append("   ")
            .append(tempVariance);

        return sb.toString();

    }
}
