package api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FailedLoginDTO {

    private String error;

    public FailedLoginDTO() {

    }

    public FailedLoginDTO(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "Error: " + getError();
    }

}
