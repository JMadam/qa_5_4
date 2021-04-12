package tests.pageobjectscenarios;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test
    void successfulFillTest() {
        registrationFormPage
                .openPage()
                .fillForm()
                .checkData();


    }
}
