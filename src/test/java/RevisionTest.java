import org.junit.Test;

import java.io.IOException;

public class RevisionTest {

    @Test
    public void testRedirect() throws Exception {
        WikipediaPageParser wikipediaPageParser = new WikipediaPageParser();
        //PageOfRevisions soupPage = wikipediaPageParser.parseJsonFile("Obama", "40");
        //boolean result = soupPage.isRedirected();
        //Assert.assertEquals(true, result);
    }

    @Test
    public void testDuplicates() throws IOException {
        WikipediaPageParser wikipediaPageParser = new WikipediaPageParser();
        //PageOfRevisions page = wikipediaPageParser.parseJsonFile("Soup", "40");

    }
}
