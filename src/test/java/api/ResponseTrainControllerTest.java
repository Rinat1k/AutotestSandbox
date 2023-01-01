package api;

import api.specifications.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import api.pojos.CarBrandsData;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    private final static String baseURI = "http://85.192.34.140:8080";

    @Test
    public void checkNameUsersAvatar() {

        Specifications.install(Specifications.requestSpecification(baseURI),
                Specifications.responseSpecification(200));


    }

}
