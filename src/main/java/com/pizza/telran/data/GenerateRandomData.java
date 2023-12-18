package com.pizza.telran.data;

import com.github.javafaker.Faker;

public class GenerateRandomData {
    Faker faker = new Faker();
    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }
    public String generateAddress() {
        return faker.address().streetAddress();
    }
    public String generateCompanyName() {
        return faker.name().username();
    }
    public String generateCityOfCafe() {
        return faker.address().cityName();
    }
    public String generateEmail() {
        return "a"+Integer.toString(faker.number().numberBetween(1, 10000))+"@ya.com";
    }
    public String generateMobilePhone() {
        return faker.phoneNumber().cellPhone();
    }
    public Integer generateRandomNumberInRange(Integer min, Integer max) {
        return faker.number().numberBetween(min, max);
    }
    public String generateIngredients() {
        return faker.food().ingredient()+", "+ faker.food().ingredient()+", "+ faker.food().ingredient()+".";
    }
}
