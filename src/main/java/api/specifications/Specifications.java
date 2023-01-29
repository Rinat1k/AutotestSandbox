package api.specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public static RequestSpecification requestSpecification(String uri) {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static void install(RequestSpecification requestSpecification) {
        RestAssured.requestSpecification = requestSpecification;
    }

}
