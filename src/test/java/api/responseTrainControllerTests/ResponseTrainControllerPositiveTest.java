package api.responseTrainControllerTests;

import api.BaseTest;
import api.dtos.CarBrandsDTO;
import api.specifications.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ResponseTrainControllerPositiveTest extends BaseTest {
    @Test
    @DisplayName("Mazda exist test")
    public void mazdaExistTest() {
        List<CarBrandsDTO> carBrandsData = given().when()
                .get("/api/easy/carBrands")
                .then().extract().body()
                .jsonPath().getList("$", CarBrandsDTO.class);

        LOGGER.info(carBrandsData);
        Assertions.assertTrue(carBrandsData.stream().anyMatch(x -> x.getBrand().equals("Mazda")));
    }

}
