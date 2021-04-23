package part1.ch6;

import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class TestWebClient {
    @BeforeClass
    public static void setUp() throws Exception {
        TestWebClient testWebClient = new TestWebClient();
        ContextHandlerCollection handlerCollection = new ContextHandlerCollection();

        ContextHandler contentOkContext = new ContextHandler("/testGetContentOk");
        contentOkContext.setHandler(testWebClient.new TestGetContentOkHandler());
        handlerCollection.addHandler(contentOkContext);

        ContextHandler contentNotFoundContext = new ContextHandler("/testGetContentNotFound");
        contentNotFoundContext.setHandler(testWebClient.new TestGetContentNotFoundHandler());
        handlerCollection.addHandler(contentNotFoundContext);

        Server server = new Server(8080);
        server.setHandler(handlerCollection);
        server.setStopAtShutdown(true);
        server.start();
    }

    private class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
            OutputStream out = httpServletResponse.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            httpServletResponse.setIntHeader(HttpHeader.CONTENT_LENGTH.toString(), writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }

    private class TestGetContentNotFoundHandler extends AbstractHandler {
        @Override
        public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Test
    public void testGetContentOk() throws Exception {
        WebClient webClient = new WebClient();
        URL url = new URL("http://localhost:8080/testGetContentOk");
        String result = webClient.getContent(url);
        assertEquals("It works", result);
    }

    @Test
    public void testGetContentNotFound() throws Exception {
        WebClient webClient = new WebClient();
        URL url = new URL("http://localhost:8080/testGetContentNotFound");
        String result = webClient.getContent(url);
        assertNull(result);
    }

    @AfterClass
    public static void tearDown() {

    }
}