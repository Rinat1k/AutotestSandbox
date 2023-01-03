package api;

import api.dtos.CarBrandsDTO;
import api.specifications.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilClasses.ConfigContainer;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ResponseTrainControllerTest {

    private final static String baseURI = new ConfigContainer().getProperty("baseURI");

    @Test
    public void checkMazdaExist() {

        Specifications.install(Specifications.requestSpecification(baseURI),
                Specifications.responseSpecification(200));

        List<CarBrandsDTO> carBrandsData = given().when()
                .get("/api/easy/carBrands")
                .then().extract().body()
                .jsonPath().getList("$", CarBrandsDTO.class);

        System.out.println("Response: " + carBrandsData);
        Assertions.assertTrue(carBrandsData.stream().anyMatch(x -> x.getBrand().equals("Mazda")));

    }

}
