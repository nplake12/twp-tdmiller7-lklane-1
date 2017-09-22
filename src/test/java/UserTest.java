import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class UserTest {

    @Test
    public void testDuplicateRevisions() throws IOException {
        Parser parser = new Parser();
        PageOfRevisions soupPage = parser.parseJsonFile("Soup", 40);
        System.out.println("After List" + soupPage.getUserNameSizeAfter());
        System.out.println("Before List" + soupPage.getUserNameSizeBefore());
        ArrayList<User> userList = soupPage.getUserList();
        for(int i = 0; i < userList.size(); i++) {
            //System.out.println(userList.get(i).getName() + " = Froid");
            if (userList.get(i).getName() == "Froid") {
                //System.out.println(userList.get(i).getRevisions());
            }
        }
    }
}
