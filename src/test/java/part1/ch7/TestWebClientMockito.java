package part1.ch7;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class TestWebClientMockito {
    private ConnectionFactory connectionFactory;
    private InputStream inputStream;

    @Before
    public void setUp() {
        connectionFactory = mock(ConnectionFactory.class);
        inputStream = mock(InputStream.class);
    }

    @Test
    public void testGetContentOk() throws Exception {
        when(connectionFactory.getInputStream()).thenReturn(inputStream);
        when(inputStream.read()).thenReturn(new Integer((byte)'W'))
                                .thenReturn(new Integer((byte)'o'))
                                .thenReturn(new Integer((byte)'r'))
                                .thenReturn(new Integer((byte)'k'))
                                .thenReturn(new Integer((byte)'s'))
                                .thenReturn(new Integer((byte)'!'))
                                .thenReturn(-1);

        WebClientUsingClassFactory client = new WebClientUsingClassFactory();
        String result = client.getContent(connectionFactory);
        assertEquals("Works!", result);
    }

    @Test
    public void testGetContentCannotCloseInputStream() throws Exception {
        when(connectionFactory.getInputStream()).thenReturn(inputStream);
        when(inputStream.read()).thenReturn(-1);
        doThrow(new IOException("cannot close")).when(inputStream).close();

        WebClientUsingClassFactory client = new WebClientUsingClassFactory();
        String result = client.getContent(connectionFactory);
        assertNull(result);
    }
}