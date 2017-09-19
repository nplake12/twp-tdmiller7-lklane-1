import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import static java.net.URLEncoder.encode;

public class Parser {

    JsonArray array = null;

    public void parseJsonFile(String searchTitle, int revisionAmount) throws IOException {

        searchTitle = encode(searchTitle, "UTF-8");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + searchTitle + "&rvprop=timestamp|user&rvlimit=" + revisionAmount + "&redirects");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa17; me@bsu.edu)");

        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");

        InputStream inputStream = connection.getInputStream();
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        System.out.println(rootElement);
        JsonObject rootObject = rootElement.getAsJsonObject();
        System.out.println(rootObject);
        try {
            JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
            for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
                JsonObject entryObject = entry.getValue().getAsJsonObject();
                array = entryObject.getAsJsonArray("revisions");
            }
        }catch(Exception e){
            System.out.println("BatchComplete");
        }

        System.out.println(array);
    }

    public boolean isEmpty(){
        if(array == null){
            return true;
        }
        return false;
    }
}
