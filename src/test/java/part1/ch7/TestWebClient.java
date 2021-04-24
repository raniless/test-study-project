package part1.ch7;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class TestWebClient {
    @Test
    public void testGetContentOk() throws Exception {
        MockHttpUrlConnection mockHttpUrlConnection = new MockHttpUrlConnection();
        mockHttpUrlConnection.setExpectedInputStream(new ByteArrayInputStream("It works".getBytes()));

        TestableWebClient client = new TestableWebClient();
        client.setHttpURLConnection(mockHttpUrlConnection);
        URL url = new URL("http://localhost");
        String result = client.getContent(url);
        assertEquals("It works", result);
    }
}