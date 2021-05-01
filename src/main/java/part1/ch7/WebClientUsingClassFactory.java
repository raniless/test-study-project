package part1.ch7;

import java.io.IOException;
import java.io.InputStream;

public class WebClientUsingClassFactory {
    public String getContent(ConnectionFactory connectionFactory) {
        String result;
        StringBuffer content = new StringBuffer();
        InputStream is = null;
        try {
            //Class Factory Refactoring (WebClient 보다 확장성 높은 구현)
            is = connectionFactory.getInputStream();
            int count;
            while(-1 != (count = is.read())) {
                content.append(new String(Character.toChars(count)));
            }
            result = content.toString();
        }
        catch (Exception e) {
            result = null;
        }
        finally {
            if(is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    result = null;
                }
            }
        }

        return result;
    }
}
