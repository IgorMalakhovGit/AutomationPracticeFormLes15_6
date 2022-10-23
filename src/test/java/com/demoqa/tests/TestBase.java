package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.utils.Month;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

public class TestBase {
    String gender = "Male",
            subjects = "Arts",
            hobbies = "Reading",
            picturePath = "Img1_1Test.jpg",
            picture = "Img1_1Test.jpg",
            state = "Haryana",
            city = "Panipat",
            stateAndCity = state + " " + city;

    Faker faker = new Faker(new Locale("pl"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullName =firstName + " " + lastName,
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(1, 28)),
            month = String.valueOf(Month.getRandomMonth()),
            year = String.valueOf(faker.number().numberBetween(1990, 2000)),
            birthDay = day + " " + month + "," + year,
            currentAddress = faker.address().fullAddress();


    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }
}
