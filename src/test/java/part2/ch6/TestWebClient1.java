package part2.ch6;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import static org.junit.Assert.assertEquals;

public class TestWebClient1 {
    @BeforeClass
    public static void setUp() throws Exception {
        TestWebClient1 testWebClient = new TestWebClient1();
        URL.setURLStreamHandlerFactory(testWebClient.new StubStreamHandlerFactory());
    }

    private class StubStreamHandlerFactory implements URLStreamHandlerFactory {
        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }

    private class StubHttpURLStreamHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL url) throws IOException {
            return new StubHttpURLConnection(url);
        }
    }

    @Test
    public void testGetContentOk() throws Exception {
        WebClient webClient = new WebClient();
        URL url = new URL("http://localhost");
        String result = webClient.getContent(url);
        assertEquals("It works", result);
    }
}
