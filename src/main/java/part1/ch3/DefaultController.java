package part1.ch3;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller {
    private Map<String, RequestHandler> requestHandlers = new HashMap<>();

    protected RequestHandler getHandler(Request request) {
        if(!requestHandlers.containsKey(request.getName())) {
            String message = "Cannot find handler for request name ["+request.getName()+"]";
            throw new RuntimeException(message);
        }

        return requestHandlers.get(request.getName());
    }

    @Override
    public Response processRequest(Request request) {
        Response response = null;
        try {
            RequestHandler requestHandler = getHandler(request);
            response = requestHandler.process(request);
        }
        catch (Exception e) {
            response = new ErrorResponse(request, e);
        }

        return response;
    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if(requestHandlers.containsKey(request.getName())) {
            String message = "A request handler has already been registered for request name ["+request.getName()+"]";
            throw new RuntimeException(message);
        }

        requestHandlers.put(request.getName(), requestHandler);
    }
}
