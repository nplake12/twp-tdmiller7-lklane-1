import org.junit.Assert;
import org.junit.Test;

public class PageOfRevisionsTest {

    @Test
    public void testRedirection(){
        WikipediaPageParser parser = new WikipediaPageParser();
        PageOfRevisions page = parser.parseJsonFile("soup", "4");
        Assert.assertEquals("soup", page.isRedirected());
    }

    @Test
    public void testPageNotFound(){
        WikipediaPageParser parser = new WikipediaPageParser();
        PageOfRevisions page = parser.parseJsonFile("sdfksajflkasjdfljasldf", "2");
        Assert.assertEquals(false, page.isPageFound());
    }
}
