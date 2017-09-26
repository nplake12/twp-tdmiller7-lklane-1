package bsu.edu.cs222;

import bsu.edu.cs222.PageOfRevisions;
import bsu.edu.cs222.WikipediaPageParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class RevisionTest {

    @Test
    public void testDuplicates() throws IOException {
        WikipediaPageParser wikipediaPageParser = new WikipediaPageParser();
        PageOfRevisions page = wikipediaPageParser.parseJsonFile("Soup", "40");
        Assert.assertNotEquals(page.getUserList().size(), 40);

    }
}
