package part1.ch7;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestableWebClient extends WebClient {
    private HttpURLConnection connection;

    public void setHttpURLConnection(HttpURLConnection connection) {
        this.connection = connection;
    }

    @Override
    protected HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        return this.connection;
    }
}
