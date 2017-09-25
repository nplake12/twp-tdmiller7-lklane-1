import org.junit.Assert;
import org.junit.Test;

public class PageOfRevisionsTest {

    @Test
    public void testRedirection(){
        WikipediaPageParser parser = new WikipediaPageParser();
        PageOfRevisions page = parser.parseJsonFile("soup", "4");
        Assert.assertEquals("soup", page.isRedirected());
    }
}
