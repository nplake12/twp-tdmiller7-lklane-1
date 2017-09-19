import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NetworkConnectionError {

    public boolean checkConnection() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/sample.json"));
        if (reader.readLine() == null) {
            return false;
        }
        return true;
    }
}
