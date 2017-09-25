import org.junit.Test;

import java.io.IOException;

public class UserTest {

    @Test
    public void testDuplicateRevisions() throws IOException {
        WikipediaPageParser wikipediaPageParser = new WikipediaPageParser();
        PageOfRevisions soupPage = wikipediaPageParser.parseJsonFile("Soup", "40");
    }
}
