package part2.ch7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestWebClientEasyMock {
    private ConnectionFactory connectionFactory;
    private InputStream inputStream;

    @Before
    public void setUp() {
        connectionFactory = createMock(ConnectionFactory.class);
        inputStream = createMock(InputStream.class);
    }

    @Test
    public void testGetContentOk() throws Exception {
        expect(connectionFactory.getInputStream()).andReturn(inputStream);
        expect(inputStream.read()).andReturn(new Integer((byte)'W'));
        expect(inputStream.read()).andReturn(new Integer((byte)'o'));
        expect(inputStream.read()).andReturn(new Integer((byte)'r'));
        expect(inputStream.read()).andReturn(new Integer((byte)'k'));
        expect(inputStream.read()).andReturn(new Integer((byte)'s'));
        expect(inputStream.read()).andReturn(new Integer((byte)'!'));
        expect(inputStream.read()).andReturn(-1);
        inputStream.close();

        replay(connectionFactory);
        replay(inputStream);

        WebClientUsingClassFactory client = new WebClientUsingClassFactory();
        String result = client.getContent(connectionFactory);
        assertEquals("Works!", result);
    }

    @Test
    public void testGetContentCannotCloseInputStream() throws Exception {
        expect(connectionFactory.getInputStream()).andReturn(inputStream);
        expect(inputStream.read()).andReturn(-1);
        inputStream.close();

        replay(connectionFactory);
        replay(inputStream);
        WebClientUsingClassFactory client = new WebClientUsingClassFactory();
        String result = client.getContent(connectionFactory);

        assertNull(result);
    }

    @After
    public void tearDown() {
        verify(connectionFactory);
        verify(inputStream);
    }
}