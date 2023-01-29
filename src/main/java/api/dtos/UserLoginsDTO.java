package api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginsDTO {

    private List<String> userLogins;

    public UserLoginsDTO() {

    }

    public UserLoginsDTO(List<String> userLogins) {
        this.userLogins = userLogins;
    }

    public List<String> getUserLogins() {
        return userLogins;
    }
}
