package com.pizza.telran.api.tests;

import com.pizza.telran.data.GenerateRandomData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class ApiTestHelpers {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    public static int PIZZAS_AMOUNT = 0;
    public static int CAFES_AMOUNT = 0;
    @BeforeClass
    public void setupRequestSpecification() {
        requestSpecification = RestAssured.given()
                .baseUri("http://pizza.telran-edu.de:2222/")
                .contentType(ContentType.JSON)
                .when();
        responseSpecification = RestAssured.expect()
                .statusCode(200)
                .response();
    }
    @BeforeMethod
    public int getPizzasAmount() {
        Response response = (Response) given(requestSpecification)
                .get("api/pizzas")
                .then()
                .spec(responseSpecification)
                .extract();
       return PIZZAS_AMOUNT = response.jsonPath().getList("id").size();
    }
    @BeforeMethod
    public int getCafesAmount() {
        Response response = (Response) given(requestSpecification)
                .get("api/cafes")
                .then()
                .spec(responseSpecification)
                .extract();
        return CAFES_AMOUNT = response.jsonPath().getList("id").size();
    }
    public int generateRandomId(int numberLimit){
        return new GenerateRandomData().generateRandomNumberInRange(1, numberLimit);
    }
    public int generateIntFakeId(int from, int to){
        return new GenerateRandomData().generateRandomNumberInRange(from, to);
    }
    public String generateStringFakeId(){
        return new GenerateRandomData().generateIngredients();
    }
}
