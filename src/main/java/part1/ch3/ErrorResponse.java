package part1.ch3;

public class ErrorResponse implements Response {
    private Request ordinalRequest;
    private Exception ordinalException;

    public ErrorResponse(Request request, Exception exception) {
        this.ordinalRequest = request;
        this.ordinalException = exception;
    }

    public Request getOrdinalRequest() {
        return this.ordinalRequest;
    }

    public Exception getOrdinalException() {
        return this.ordinalException;
    }
}
