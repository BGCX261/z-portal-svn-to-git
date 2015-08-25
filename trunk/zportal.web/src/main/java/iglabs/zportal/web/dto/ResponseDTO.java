package iglabs.zportal.web.dto;

public class ResponseDTO<T> {
    
    public static <U> ResponseDTO<U> success(U data) {
        return new ResponseDTO<U>(data, true, null);
    }
    
    public static ResponseDTO failure(String message) {
        return new ResponseDTO(null, false, message);
    }
    
    
    protected ResponseDTO(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }
    
    public T getData() {
        return data;
    }
    
    public String getMessage() {
        return message;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    
    private final T data;
    private final boolean success;
    private final String message;
}
