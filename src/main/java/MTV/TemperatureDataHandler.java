package MTV;

import java.util.ArrayList;
import java.util.List;

public class TemperatureDataHandler {

    private List<MonthTemperatureData> topVariances = new ArrayList<MonthTemperatureData>();

    public List getVariances() {
        return topVariances;

    }

    /**
     *
     * adds entry to variance list if (and only if) variance is equal.
     * if variance is greater then those existing in list, then zap list and add current
     * variance
     *
     * @param monthTemperatureData
     */
    public void setMonthTemperatureData(MonthTemperatureData monthTemperatureData) {

        float variance = monthTemperatureData.getMax() - monthTemperatureData.getMin();
        float topVariance = topVariances.size()==0 ? -1.0f : topVariances.get(0).getTempVariance();

        if (variance == topVariance) {
            // add
            topVariances.add(monthTemperatureData);

        } else if (variance > topVariance) {
            // replace
            topVariances.clear();
            topVariances.add(monthTemperatureData);

        }
    }

    public static MonthTemperatureData getTemperatures(String line) {

//        String [] data = line.split("[\\s]*");
        String [] data = line.split("\\s{1,}");

        MonthTemperatureData tempData = new MonthTemperatureData();
        tempData.setYear(Integer.valueOf(data[1]));
        tempData.setMonth(Integer.valueOf(data[2]));

        Float min = Float.valueOf(data[4]);
        Float max = Float.valueOf(data[3]);

        tempData.setMin(min);
        tempData.setMax(max);

        tempData.setTempVariance(max - min);

        return tempData;

    }

    public String outputResults() {
        return this.toString();

    }

    @Override
    public String toString() {

        if (topVariances.size()>0) {
            StringBuffer sb = new StringBuffer("   yyyy  mm  variance\n");

            for (MonthTemperatureData data : topVariances) {
                sb.append(data.toString());

            }

            return sb.toString();

        } else {
            return "No data";

        }
    }
}
