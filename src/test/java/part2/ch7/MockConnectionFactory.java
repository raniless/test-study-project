package part2.ch7;

import java.io.InputStream;

public class MockConnectionFactory implements ConnectionFactory {
    private InputStream inputStream;

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    @Override
    public InputStream getInputStream() throws Exception {
        return inputStream;
    }
}
