import java.net.*;
import java.io.*;
import static java.net.URLEncoder.encode;

public class URLConnectionReader {

    public void searchWikipediaTitle(String searchTitle, String revisionAmount) throws Exception {

        searchTitle = encode(searchTitle, "UTF-8");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + searchTitle + "&rvprop=timestamp|user&rvlimit=" + revisionAmount + "&redirects");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa17; me@bsu.edu)");

        InputStream inputJson = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/sample.json"));

        while ((inputLine = reader.readLine()) != null)
            writer.write(inputLine);

        inputJson.close();
        writer.close();
    }
}