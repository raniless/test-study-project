package part1.ch7;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// HTTP 커넥션을 맺는 샘플 메서드
public class WebClient {
    public String getContent(URL url) {
        StringBuffer content = new StringBuffer();

        try {
            //Refactoring
            HttpURLConnection connection = createHttpURLConnection(url);
            connection.setDoInput(true);
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int count;
            while(-1 != (count = is.read(buffer))) {
                content.append(new String(buffer, 0, count));
            }
        }
        catch (IOException e) {
            return null;
        }

        return content.toString();
    }

    protected HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        return (HttpURLConnection)url.openConnection();
    }
}
