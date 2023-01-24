package api.dtos;

public class SuccessLoginDTO {

    private String token;

    public SuccessLoginDTO() {

    }

    public SuccessLoginDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
