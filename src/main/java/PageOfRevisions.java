import com.google.gson.JsonArray;

import java.util.ArrayList;

public class PageOfRevisions {

    public ArrayList<Revision> revisionList = new ArrayList();

    public void createRevisionList(JsonArray array){
        for(int i = 0; i < array.size(); i++){
            //addRevision(i);
        }
    }

    public void addRevision(Revision revision){
        revisionList.add(revision);
    }
}
