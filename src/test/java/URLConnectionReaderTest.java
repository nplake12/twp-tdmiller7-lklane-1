import org.junit.Test;

public class URLConnectionReaderTest {

    //Needs Assert
    @Test
    public void testURLNull() throws Exception {
        URLConnectionReader reader = new URLConnectionReader();
        reader.searchWikipediaTitle("Soup", "4");
    }
}