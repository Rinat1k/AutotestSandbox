package api.responseTrainControllerTests;

import api.BaseTest;
import api.dtos.CarBrandsDTO;
import api.specifications.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ResponseTrainControllerPositiveTest extends BaseTest {
    @Test
    public void checkMazdaExist() {

        Specifications.install(Specifications.requestSpecification(BASE_URI),
                Specifications.responseSpecification(200));

        List<CarBrandsDTO> carBrandsData = given().when()
                .get("/api/easy/carBrands")
                .then().extract().body()
                .jsonPath().getList("$", CarBrandsDTO.class);

        LOGGER.info(carBrandsData);
        Assertions.assertTrue(carBrandsData.stream().anyMatch(x -> x.getBrand().equals("Mazda")));

    }

}
