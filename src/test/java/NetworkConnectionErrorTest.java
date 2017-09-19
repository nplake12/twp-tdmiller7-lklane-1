import org.junit.Assert;
import org.junit.Test;

public class NetworkConnectionErrorTest {

    //Needs Assert
    @Test
    public void testURLNull() throws Exception {
        NetworkConnectionError error = new NetworkConnectionError();
        boolean result = error.checkConnection();
        Assert.assertTrue(result);
    }
}