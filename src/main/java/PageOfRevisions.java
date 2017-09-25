import com.google.common.collect.HashMultiset;
import com.google.gson.JsonArray;
import com.sun.javafx.collections.ImmutableObservableList;
import javafx.collections.ObservableList;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.*;

public class PageOfRevisions {

    public String name;
    public String redirectedAfter;
    public String redirectedBefore;
    public boolean isNotFound;
    public List<User> usernameList = new ArrayList<User>();

    public PageOfRevisions(String name, String redirectAfter, String redirectBefore, boolean isNotFound){
        this.redirectedAfter = redirectAfter;
        this.redirectedBefore = redirectBefore;
        this.name = name;
        this.isNotFound = isNotFound;
    }


    public void searchSameUser(List<User> usernames){

        HashMultiset<String> revisionCount = HashMultiset.create();

        for(int i = 0; i < usernames.size(); i++){
            revisionCount.add(usernames.get(i).getUsername());
        }

        for(int i = 0; i < usernames.size(); i++) {
            for (int j = 0; j < usernames.size(); j++) {
                int firstCount = revisionCount.count(usernames.get(i).getUsername());
                int secondCount = revisionCount.count(usernames.get(j).getUsername());
                if (secondCount > firstCount) {
                    User firstUser = usernames.get(i);
                    User secondUser = usernames.get(j);
                    usernames.set(i, secondUser);
                    usernames.set(j, firstUser);
                } else if (secondCount == firstCount) {
                    if(secondCount > 1) {
                        Timestamp firsTimeStamp = Timestamp.valueOf(usernames.get(i).getRevisionList().get(0).getTimestamp());
                        Timestamp secondTimeStamp = Timestamp.valueOf(usernames.get(j).getRevisionList().get(0).getTimestamp());
                        if (firsTimeStamp.after(secondTimeStamp)) {
                            User firstUser = usernames.get(i);
                            User secondUser = usernames.get(j);
                            usernames.set(i, secondUser);
                            usernames.set(j, firstUser);

                            firstUser.getRevisionList().add(secondUser.getRevisionList().get(0));
                            usernames.remove(secondUser);
                        }
                    }
                }
            }
        }
        for(int i = 0; i < usernames.size(); i++){
            usernameList.add(usernames.get(i));
        }
    }

    public String isRedirected(){
        System.out.println(redirectedAfter);
        if(redirectedBefore.equals(redirectedAfter)){
            return redirectedBefore;
        }else{
            return redirectedBefore + " changed to " + redirectedAfter;
        }
    }

    public List<User> getUserList() {
        return usernameList;
    }
}
