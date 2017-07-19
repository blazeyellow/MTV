package MTV;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestMTV extends TestCase {

    public static final String headerLineEnd = "              degC    degC    days      mm   hours";

    public void testLoadFile() throws Exception {
        FileInputStream inputFile = new FileInputStream("resource/heathrowdata.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFile));

        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);

            br.mark(0);
            if (line.equals(headerLineEnd)) {
                System.out.println("Whoo-hoo");
            }


        }
    }

    public void testSplitDataLine() {
        String string = "   1948   1    8.9     3.3    ---     85.0    --- ";

        String [] data = string.split("\\s{1,}");

        for (String item : data) {
            System.out.println(item);

        }

    }
}
