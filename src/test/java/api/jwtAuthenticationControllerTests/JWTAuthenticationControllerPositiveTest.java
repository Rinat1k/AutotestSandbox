package api.jwtAuthenticationControllerTests;

import api.BaseTest;
import api.dtos.UserDTO;
import api.specifications.Specifications;
import api.dtos.SuccessLoginDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JWTAuthenticationControllerPositiveTest extends BaseTest {
    @Test
    @DisplayName("Positive login test")
    public void positiveLoginTest() {
        SuccessLoginDTO successLogin = given()
                .body(new UserDTO("string", "string"))
                .when()
                .post(BASE_URI + "/api/login")
                .then()
                .extract()
                .response()
                .as(SuccessLoginDTO.class);

        Assertions.assertNotEquals(successLogin.getToken(), null);
        Assertions.assertEquals(3, successLogin.getToken().split("\\.").length);
    }
}
