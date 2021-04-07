package tests.pageobjectscenarios;

import com.github.javafaker.Faker;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {
    Faker faker = new Faker();

    private String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10),
            gender = "Female",
            birthDay = "13",
            birthMonth = "August",
            birthYear = "1985",
            subjects = "Biology",
            hobby = "Music",
            picture = "1.jpg",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";

    public RegistrationFormPage openPage () {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }


    public RegistrationFormPage fillForm () {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        setDate(birthYear, birthMonth, birthDay);
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("./src/test/java/../resources/"+ picture));
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        return this;
    }

    public void setDate (String birthYear, String birthMonth, String birthDay){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(String.format("[aria-label='Choose Tuesday, %s %sth, %s']", birthMonth, birthDay, birthYear)).click();

    }

    public void checkData () {
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
                text("13 August,1985"),
                text(subjects),
                text(hobby),
                text(picture),
                text(address),
                text(state + " " + city));


    }


}
