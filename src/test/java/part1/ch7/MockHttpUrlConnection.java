package part1.ch7;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MockHttpUrlConnection extends HttpURLConnection {
    private InputStream stream;

    public MockHttpUrlConnection() {
        super(null);
    }
    protected MockHttpUrlConnection(URL url) {
        super(url);
    }

    public void setExpectedInputStream(InputStream stream) {
        this.stream = stream;
    }
    public InputStream getInputStream() throws IOException {
        return this.stream;
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {

    }
}