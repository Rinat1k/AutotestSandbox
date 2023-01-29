package api.jwtAuthenticationControllerTests;

import api.BaseTest;
import api.dtos.UserDTO;
import api.specifications.Specifications;
import api.dtos.FailedLoginDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JWTAuthenticationControllerNegativeTest extends BaseTest {
    @Test
    @DisplayName("Negative login test")
    public void negativeLoginTest() {
        FailedLoginDTO failedLogin = given()
                .body(new UserDTO("failed login", "failed password"))
                .when()
                .post(BASE_URI + "/api/login")
                .then()
                .extract()
                .response()
                .as(FailedLoginDTO.class);

        Assertions.assertTrue(failedLogin.getError().equalsIgnoreCase("Unauthorized"));
    }
}
