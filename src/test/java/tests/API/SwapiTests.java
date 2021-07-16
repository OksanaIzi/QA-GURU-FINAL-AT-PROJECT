package tests.API;

import Specs.Specs;
import annotations.Layer;
import annotations.Microservice;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import models.PersonExtended;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("rest")
@Owner("Izibekova")
@DisplayName("Проверка информации о персонажах")
public class SwapiTests {


    @Test
    @Microservice("АПИ")
    @Feature("Получение информации о персонажах")
    @Tag("api")
    @DisplayName("Проверка получения информации о первом герое")
    public void successGetUsersList(){
        Specs.request
                .when()
                .get("/people/")
                .then()
                .log().status()
                .statusCode(200)
                .body("results[0].name", equalTo("Luke Skywalker"));
    }

    @Test
    @Microservice("АПИ")
    @Feature("Получение информации о персонажах")
    @Tag("api")
    @DisplayName("Проверка получения информации о росте героя")
    public void successGetListUserCheckName(){
        PersonExtended data = given()
                .baseUri("https://swapi.dev")
                .basePath("/api")
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/people")
                .then()
                .log().body()
                .extract().as(PersonExtended.class);
        assertEquals("172", data.getResults().get(0).getHeight());
        assertEquals("C-3PO", data.getResults().get(1).getName());
    }

    @Test
    @Microservice("АПИ")
    @Feature("Получение информации о персонажах")
    @Tag("api")
    @DisplayName("Проверка получения информации об общем кол-ве персонажей на сервисе")
    public void successGetListUserCheckCount(){
        PersonExtended data = given()
                .baseUri("https://swapi.dev")
                .basePath("/api")
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/people")
                .then()
                .log().body()
                .extract().as(PersonExtended.class);
        assertEquals("82", data.getCount());
    }

    @Test
    @Microservice("АПИ")
    @Feature("Получение информации о персонажах")
    @Tag("api")
    @DisplayName("Проверка корректной ссылки")
    public void successGetListUserCheckURL(){
        PersonExtended data = given()
                .baseUri("https://swapi.dev")
                .basePath("/api")
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/people")
                .then()
                .log().body()
                .extract().as(PersonExtended.class);
        assertEquals("https://swapi.dev/api/people/1/", data.getResults().get(0).getUrl());
    }


    @Test
    @Microservice("АПИ")
    @Feature("Получение информации о персонажах")
    @Tag("api")
    @DisplayName("Проверка получения информации массе героя")
    public void successGetListUserMass(){
        PersonExtended data = given()
                .baseUri("https://swapi.dev")
                .basePath("/api")
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/people")
                .then()
                .log().body()
                .extract().as(PersonExtended.class);
        assertEquals("32", data.getResults().get(2).getMass());
    }

}
