package MTV;

public class MTVEvaluator {
    public static void main( String[] args ) {
        DataFile dataFile;

        try {
            dataFile = new DataFile("resource/heathrowdata.txt");

        } catch (DataFileAccessError e) {
            System.out.println("Error loading file. Cannot continue");
            return;

        }

        TemperatureDataHandler handler = new TemperatureDataHandler();
        String line;
        try {
            while ((line = dataFile.readNextLine()) != null) {
                MonthTemperatureData temperatureData = handler.getTemperatures(line);
                handler.setMonthTemperatureData(temperatureData);

            }
        } catch (DataFileAccessError dataFileAccessError) {
            System.out.println("Error reading file. Cannot continue.");

        }

        System.out.println(handler.outputResults());

    }
}
