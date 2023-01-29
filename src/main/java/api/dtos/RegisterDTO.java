package api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterDTO {
    private String login;

    private String pass;

    public RegisterDTO() {

    }
    public RegisterDTO(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}
