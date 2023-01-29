package api.userControllerTests;

import api.BaseTest;
import org.junit.jupiter.api.DisplayName;
import utilClasses.LoginGenerator;
import api.dtos.RegisterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilClasses.ConfigContainer;


import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class UserRegisterPositiveTest extends BaseTest {
    @Test
    @DisplayName("User register positive test")
    public void userRegisterPositiveTest() {
        String login = LoginGenerator.generate();
        String password = new ConfigContainer().getProperty("AT_DEFAULT_CRED_PASSWORD");
        RegisterDTO registerDTO = new RegisterDTO(login, password);

        LinkedHashMap<String, String> registerResponse = given()
                .when()
                .body(registerDTO)
                .post("/api/register")
                .then()
                .extract()
                .body()
                .jsonPath()
                .get("register_data");

        Assertions.assertEquals(registerResponse.get("login"), login);
        Assertions.assertEquals(registerResponse.get("pass"), password);
    }
}
