package com.pizza.telran.data;

public class AccessConstant {
    public static final String BASE_USER =  "user";

    public static final String BASE_ADMIN =  "admin";

    public static final String BASE_PASSWORD =  "1";

    public static final String RANDOM_USER =  new GenerateRandomData().generateFirstName();

    public static final String RANDOM_PASSWORD =  new GenerateRandomData().generateLastName();
}
