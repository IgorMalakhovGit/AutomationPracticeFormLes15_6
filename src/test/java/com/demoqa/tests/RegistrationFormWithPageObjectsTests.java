package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.components.ResultsModal;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ResultsModal resultsModal = new ResultsModal();

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phone)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbiesInTheCheckbox(hobbies);
        registrationFormPage.uploadFile(picturePath)
                .setCurrentAddress(currentAddress)
                .setStateOnTheSelect(state)
                .setCityOnTheSelect(city)
                .clickOnButtonSubmit();
        resultsModal.checkVisible();
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", birthDay)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", stateAndCity);
    }
}
