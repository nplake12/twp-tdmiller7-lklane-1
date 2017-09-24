import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class RevisionTest {

    @Test
    public void testRedirect() throws Exception {
        Parser parser = new Parser();
        //PageOfRevisions soupPage = parser.parseJsonFile("Obama", 40);
        //boolean result = soupPage.isRedirected();
        //Assert.assertEquals(true, result);
    }

    @Test
    public void testDuplicates() throws IOException {
        Parser parser = new Parser();
        //PageOfRevisions page = parser.parseJsonFile("Soup", 40);

    }
}
