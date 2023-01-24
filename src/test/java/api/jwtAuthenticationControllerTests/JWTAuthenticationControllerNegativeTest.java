package api.jwtAuthenticationControllerTests;

import api.BaseTest;
import api.dtos.UserDTO;
import api.specifications.Specifications;
import api.dtos.FailedLoginDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JWTAuthenticationControllerNegativeTest extends BaseTest {

    @Test
    public void negativeLoginTest() {
        Specifications.install(Specifications.requestSpecification(BASE_URI),
                Specifications.responseSpecification(401));

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
