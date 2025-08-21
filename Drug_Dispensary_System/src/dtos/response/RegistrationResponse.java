package dtos.response;

public class RegistrationResponse {
    private String message;

    public RegistrationResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
