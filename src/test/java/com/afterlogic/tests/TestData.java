package com.afterlogic.tests;

import com.github.javafaker.Faker;

import static com.afterlogic.utils.RandomUtils.getRandomMessage;

public class TestData {

    Faker faker = new Faker();

    String companyName = faker.company().name(),
            userName = faker.name().firstName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            message = getRandomMessage();
}