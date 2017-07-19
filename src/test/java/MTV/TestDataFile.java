package MTV;

import junit.framework.TestCase;

public class TestDataFile extends TestCase {

    public void testLoad() throws DataFileAccessError {
        DataFile dataFile = new DataFile("resource/heathrowdata.txt");

        assertTrue(dataFile.isLoaded());

    }

    public void testReadNextLine() throws Exception {

        String firstLine = "   1948   1    8.9     3.3    ---     85.0    ---";

        DataFile dataFile = new DataFile("resource/heathrowdata.txt");
        assertTrue(dataFile.readNextLine().equals(firstLine));

    }

    public void testIsDataLine_success() throws Exception {
        String goodData = "   1948   1    8.9     3.3    ---     85.0    --- ";
        DataFile dataFile = new DataFile("resource/heathrowdata.txt");
        assertTrue(dataFile.isDataLine(goodData));

    }

    public void testIsDataLine_failure() throws Exception {
        String badData = "rubbish";
        DataFile dataFile = new DataFile("resource/heathrowdata.txt");
        assertFalse(dataFile.isDataLine(badData));

    }

    public void testSplitDataLine() {
        String string = "   1948   1    8.9     3.3    ---     85.0    --- ";

        String [] data = string.split("\\s{1,}");

//        for (String item : data) {
//            System.out.println(item);
//
//        }

        assertTrue("1948".equals(data[1]));
        assertTrue("1".equals(data[2]));
        assertTrue("8.9".equals(data[3]));
    }
}
