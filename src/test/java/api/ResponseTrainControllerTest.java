package api;

import api.pojos.CarBrandsData;
import api.specifications.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ResponseTrainControllerTest {

    private final static String baseURI = "http://85.192.34.140:8080";

    @Test
    public void checkMazdaExist() {

        Specifications.install(Specifications.requestSpecification(baseURI),
                Specifications.responseSpecification(200));

        List<CarBrandsData> carBrandsData = given().when()
                .get("/api/easy/carBrands")
                .then().extract().body()
                .jsonPath().getList("$", CarBrandsData.class);

        Assertions.assertTrue(carBrandsData.stream().anyMatch(x -> x.getBrand().equals("Mazdagit ")));

    }

}
