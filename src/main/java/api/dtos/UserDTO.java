package api.dtos;

public class UserDTO {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO(String login, String password) {
        this.username = login;
        this.password = password;
    }
}
