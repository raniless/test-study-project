package part1.ch3;

public interface RequestHandler {
    Response process(Request request) throws Exception;
}
