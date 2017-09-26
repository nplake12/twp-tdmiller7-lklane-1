package bsu.edu.cs222;

import com.google.common.collect.HashMultiset;

import java.sql.Timestamp;
import java.util.*;

public class PageOfRevisions {

    public String name;
    public String redirectedAfter;
    public String redirectedBefore;
    public boolean isNotFound;
    public List<User> usernameList = new ArrayList<>();

    public PageOfRevisions(String name, String redirectAfter, String redirectBefore, boolean isNotFound){
        this.redirectedAfter = redirectAfter;
        this.redirectedBefore = redirectBefore;
        this.name = name;
        this.isNotFound = isNotFound;
    }

    public void searchSameUser(List<User> usernames){

        HashMultiset<String> revisionCount = HashMultiset.create();
        for(User user : usernames){
            revisionCount.add(user.getUsername());
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
        for(User user: usernames){
            usernameList.add(user);
        }
    }

    public String isRedirected(){
        if(redirectedBefore.equals(redirectedAfter)){
            return redirectedBefore;
        }else{
            return redirectedBefore + " changed to " + redirectedAfter;
        }
    }

    public List<User> getUserList() {
        return usernameList;
    }

    public boolean isPageFound() {
        return isNotFound;
    }
}
