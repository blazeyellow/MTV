package MTV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFile {

    private BufferedReader br;

    public DataFile(String filename) throws DataFileAccessError {
        load(filename);

    }

    public void load(String filename) throws DataFileAccessError {
        if (!isLoaded()) {
            FileInputStream inputFile = null;

            try {
                inputFile = new FileInputStream(filename);

            } catch (FileNotFoundException e) {
                throw new DataFileAccessError("Cannot open data file");

            }

            br = new BufferedReader(new InputStreamReader(inputFile));

        }
    }

    public String readNextLine() throws DataFileAccessError {

        String line;
        try {
            line = br.readLine();

        } catch (IOException e) {
            throw new DataFileAccessError("Cannot read data file");

        }

        if (!isDataLine(line)) {
            try {
                while ((line = br.readLine()) != null) {
                    if (isDataLine(line)) {
                        break;

                    }
                }
            } catch (IOException e) {
                throw new DataFileAccessError("Error reading data file: " + e.getLocalizedMessage());

            }
        }

        return line;

    }

    public boolean isLoaded() {
        return br != null;

    }

    public boolean isDataLine(String line) {

        if (line==null) {
            return false;

        }

        Pattern pattern = Pattern.compile("^\\s*\\d\\d\\d\\d\\s*.*");
        Matcher m = pattern.matcher(line);

        return m.matches();

    }
}
