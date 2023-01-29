package api.userControllerTests;

import api.BaseTest;
import api.dtos.RegisterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilClasses.ConfigContainer;
import utilClasses.LoginGenerator;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserRegisterNegativeTest extends BaseTest {

    @Test
    @DisplayName("User register negative test")
    public void userRegisterNegativeTest() {
        String login = "";

        if (LoginGenerator.getExistedLogins().isEmpty()) {
            throw new AssertionError("There are no existing logins");
        } else {
            login = LoginGenerator.getExistedLogins().get(0);
        }

        String password = new ConfigContainer().getProperty("AT_DEFAULT_CRED_PASSWORD");
        RegisterDTO registerDTO = new RegisterDTO(login, password);

        HashMap<String, String> failedRegisterData = given()
                .when()
                .body(registerDTO)
                .post("/api/register")
                .then()
                .extract()
                .body()
                .jsonPath()
                .get("info");

        Assertions.assertEquals("Login already exist", failedRegisterData.get("message"));
        Assertions.assertEquals("fail", failedRegisterData.get("status"));
    }
}
