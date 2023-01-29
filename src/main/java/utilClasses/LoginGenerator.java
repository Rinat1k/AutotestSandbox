package utilClasses;

import api.dtos.UserLoginsDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static io.restassured.RestAssured.given;

public final class LoginGenerator {

    public static String generate() {
        String generatedLogin = "";
        boolean loginIsExist = true;
        while (loginIsExist) {
            generatedLogin = getValueForLogin();
            String finalGeneratedLogin = generatedLogin;
            loginIsExist = getExistedLogins().stream().anyMatch(x -> x.equals(finalGeneratedLogin));
        }
        return generatedLogin;
    }

    private static String getValueForLogin() {
        String currentTime =
                DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss").format(LocalDateTime.now());
        return "AT_Random_User_Login_" + currentTime;
    }

    public static List<String> getExistedLogins() {
        var userLoginsDTO = given()
                .when()
                .get("/api/users")
                .then()
                .statusCode(200)
                .extract()
                .as(UserLoginsDTO.class);
        return userLoginsDTO.getUserLogins();
    }
}
