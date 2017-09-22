import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class RevisionTest {

    @Test
    public void testNotUTCTime() throws IOException {
        Parser parser = new Parser();
        PageOfRevisions pageOfRevision = parser.parseJsonFile("Soup", 4);
        Assert.assertNotEquals(pageOfRevision.getUserList()
                .get(0)
                .getRevisions()
                .get(0).getUtcTime(), pageOfRevision.getUserList()
                .get(0).getRevisions()
                .get(0).getTimestamp());
    }
}
