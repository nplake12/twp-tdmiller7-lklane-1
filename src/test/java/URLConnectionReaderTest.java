import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;

public class URLConnectionReaderTest {

    @Test
    public void testURLSoup() throws Exception {
        WikipediaPageParser jsonObject = new WikipediaPageParser();
        jsonObject.parseJsonFile("Soup", "4");
        boolean result = jsonObject.isEmpty();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testTimezoneIsGreenwichMeanTime() throws ParseException {
        final Calendar calendar = javax.xml.bind.DatatypeConverter.parseDateTime("2010-04-05T17:16:00Z");
        Assert.assertEquals("gotten timezone", "GMT+00:00", calendar.getTimeZone().getID());
    }

    @Test
    public void testURLInvalidText() throws Exception {
        WikipediaPageParser jsonObject = new WikipediaPageParser();
        jsonObject.parseJsonFile("SLKDJFF", "4");
        boolean result = jsonObject.isEmpty();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testNetworkConnection() throws Exception {
        WikipediaPageParser jsonObject = new WikipediaPageParser();
        jsonObject.parseJsonFile("Soup", "4");
        boolean result = jsonObject.isConnected();
        Assert.assertEquals(true, result);
    }


    @Test
    public void testNetworkC3onnection() throws Exception {
        WikipediaPageParser jsonObject = new WikipediaPageParser();
        jsonObject.parseJsonFile("Soup", "4");
        boolean result = jsonObject.isConnected();
        Assert.assertEquals(true, result);
    }
}