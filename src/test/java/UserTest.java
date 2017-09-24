import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class UserTest {

    @Test
    public void testDuplicateRevisions() throws IOException {
        Parser parser = new Parser();
        PageOfRevisions soupPage = parser.parseJsonFile("Soup", 40);
    }
}
