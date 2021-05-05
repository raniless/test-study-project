package part2.ch6;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class JettySample {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ContextHandler contextHandler = new ContextHandler(server, "/");
        contextHandler.setResourceBase("./pom.xml");
        contextHandler.setHandler(new ResourceHandler());

        server.start();
    }
}