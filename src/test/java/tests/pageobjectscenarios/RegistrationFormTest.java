package tests.pageobjectscenarios;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest {

    RegistrationFormPage RegistrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test
    void successfulFillTest() {
        RegistrationFormPage
                .openPage()
                .fillForm()
                .checkData();


    }
}
