import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

public class URLConnectionReaderTest {

    //Needs Assert
    @Test
    public void testURLNotNull() throws Exception {
        Parser jsonObject = new Parser();
        jsonObject.parseJsonFile("Soup", 4);
        boolean result = jsonObject.isEmpty();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testURLNull() throws Exception {
        Parser jsonObject = new Parser();
        jsonObject.parseJsonFile("", 4);
        boolean result = jsonObject.isEmpty();
        Assert.assertEquals(true, result);
    }
}