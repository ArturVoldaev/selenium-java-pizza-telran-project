package com.pizza.telran.api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest extends ApiTestHelpers {
    @Test
    public void getListOfPizzasTest() {
        Response response = (Response) given(requestSpecification)
                .get("api/pizzas")
                .then()
                .spec(responseSpecification)
                .body("it.size()", equalTo(PIZZAS_AMOUNT))
                .extract();
    }
    @Test
    public void getPizzaByIdParamTest() {
        Response getPizzaId = (Response) given(requestSpecification)
                .get("api/pizzas");

        int id = (int) getPizzaId.jsonPath().getList("id").get(generateRandomId(PIZZAS_AMOUNT) - 1);

        Response response = (Response) given(requestSpecification)
                .get("api/pizzas/{id}", id)
                .then()
                .body("id", equalTo(id))
                .spec(responseSpecification)
                .extract();
    }
    @Test
    public void getListOfCafesTest() {
        Response response = (Response) given(requestSpecification)
                .get("api/cafes")
                .then()
                .spec(responseSpecification)
                .body("it.size()", equalTo(CAFES_AMOUNT))
                .extract();
    }
    @Test
    public void getCafeByIdParamTest() {
        Response getCafeId = (Response) given(requestSpecification)
                .get("api/cafes");

        int id = (int) getCafeId.jsonPath().getList("id").get(generateRandomId(PIZZAS_AMOUNT) - 1);

        Response response = (Response) given(requestSpecification)
                .get("api/cafes/{id}", id)
                .then()
                .body("id", equalTo(id))
                .spec(responseSpecification)
                .extract();
    }
    @Test
    public void getCafeWithWrongIdParamTest() {
       int idCafe = generateIntFakeId(10000, 50000);
        Response response = (Response) given(requestSpecification)
                .get("api/cafes/{id}", idCafe)
                .then()
                .body("error", equalTo("Internal Server Error"))
                .statusCode(500)
                .extract();
    }
    @Test
    public void getCafeWithStringParamTest() {
        String idCafe = generateStringFakeId();
        Response response = (Response) given(requestSpecification)
                .get("api/cafes/{id}", idCafe)
                .then()
                .body("error", equalTo("Bad Request"))
                .statusCode(400)
                .extract();
    }
    @Test
    public void getPizzaWithWrongIdParamTest() {
        int idPizza = generateIntFakeId(10000, 50000);
        Response response = (Response) given(requestSpecification)
                .get("api/pizzas/{id}", idPizza)
                .then()
                .body("error", equalTo("Internal Server Error"))
                .statusCode(500)
                .extract();
    }
    @Test
    public void getPizzaWithStringParamTest() {
        String idPizza = generateStringFakeId();
        Response response = (Response) given(requestSpecification)
                .get("api/pizzas/{id}", idPizza)
                .then()
                .body("error", equalTo("Bad Request"))
                .statusCode(400)
                .extract();
    }
}
