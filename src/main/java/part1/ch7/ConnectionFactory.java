package part1.ch7;

import java.io.InputStream;

public interface ConnectionFactory {
    InputStream getInputStream() throws Exception;
}