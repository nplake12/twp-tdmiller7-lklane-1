import com.google.common.collect.HashMultiset;
import com.google.gson.JsonArray;
import com.sun.javafx.collections.ImmutableObservableList;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PageOfRevisions {

    public String name;
    public boolean isRedirected;
    public boolean isNotFound;
    public ArrayList<User> usernameList;

    public PageOfRevisions(String name, boolean isRedirected, boolean isNotFound){
        this.isRedirected = isRedirected;
        this.name = name;
        this.isNotFound = isNotFound;
    }

    public void searchSameUser(ArrayList<User> usernameList){
        /*HashMultiset<String> revisionCount = HashMultiset.create();

        System.out.println(usernameList.size());

        for(int i = 0; i < usernameList.size(); i++){
            revisionCount.add(usernameList.get(i).getName());
        }

        for(int i = 0; i < usernameList.size(); i++) {
            for (int j = 0; j < usernameList.size(); j++) {
                int firstCount = revisionCount.count(usernameList.get(i).getName());
                int secondCount = revisionCount.count(usernameList.get(j).getName());
                if (secondCount < firstCount) {
                    User firstUser = usernameList.get(i);
                    User secondUser = usernameList.get(j);
                    usernameList.set(i, secondUser);
                    usernameList.set(j, firstUser);
                } else if (secondCount == firstCount) {
                    Timestamp firsTimeStamp = Timestamp.valueOf(usernameList.get(i).getRevisions().get(0).getTimestamp());
                    Timestamp secondTimeStamp = Timestamp.valueOf(usernameList.get(j).getRevisions().get(0).getTimestamp());
                    if (firsTimeStamp.after(secondTimeStamp)) {
                        User firstUser = usernameList.get(i);
                        User secondUser = usernameList.get(j);
                        usernameList.set(i, secondUser);
                        usernameList.set(j, firstUser);
                    }
                }
            }
        }
*/

    }

    public boolean isRedirected(){
        return isRedirected;
    }

    public ArrayList<User> getUserList() {
        return usernameList;
    }
}
