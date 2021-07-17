package Specs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;

public class Specs {
    public static RequestSpecification request = with()
            .baseUri("https://swapi.dev")
            .basePath("/api")
            .filter(customLogFilter().withCustomTemplates())
            .log().uri()
            .contentType(ContentType.JSON);
}
