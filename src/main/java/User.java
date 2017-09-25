import com.google.gson.JsonArray;

import java.util.ArrayList;

public class User {

    public ArrayList<Revision> revisionList = new ArrayList();
    public String username;
    public String revisions;

    public Revision getRevision(String searchName){
        return revisionList.get(0);
    }

    public User(String username){
        this.username = username;
    }

    public void addRevision(Revision revision){
        revisionList.add(revision);
    }

    public ArrayList<Revision> getRevisionList(){
        return this.revisionList;
    }

    public String getRevisions(){
        String string= "";
        int count = 0;
        for(int i = 0; i < revisionList.size(); i++){
            if(count < 1) {
                string = string + revisionList.get(i).getTimestamp();
                count++;
            }else {
                string = string + ", " +revisionList.get(i).getTimestamp();
                count++;
            }
        }
        return string;
    }

    public String getUsername(){
        return this.username;
    }
}
