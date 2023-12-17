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
    public String generateEmail() {
        return faker.internet().emailAddress();
    }
    public String generateMobilePhone() {
        return faker.phoneNumber().cellPhone();
    }
    public Integer generateRandomNumberInRange(Integer min, Integer max) {
        return faker.number().numberBetween(min, max);
    }
}
