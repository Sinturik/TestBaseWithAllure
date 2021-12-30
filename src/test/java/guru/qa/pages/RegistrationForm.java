package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    private SelenideElement
            firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            resultTable = $(".table-responsive"),
            emailInput = $("[id=userEmail]"),
            clickRadiobutton = $(".custom-control-label"),
            phoneInput = $("[id=userNumber]"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("[id=hobbiesWrapper]"),
            addressInput = $("[id=currentAddress]"),
            selectFileButton = $("[id=uploadPicture]"),
            stateField = $("#state"),
            stateFromDropdown = $("#stateCity-wrapper"),
            cityField = $("#city"),
            cityFromDropdown = $("#stateCity-wrapper"),
            submitButton = $("[id=submit]"),
            tableTitle = $("[id=example-modal-sizes-title-lg]");

    public CalendarComponent calendar = new CalendarComponent();

    //метод открыть страницу
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    //метод заполнить поле first name
    public RegistrationForm fillInFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    //метод заполнить поле last name
    public void fillInLastName(String lastName) {
        lastNameInput.setValue(lastName);

    }

    //метод заполнить поле email
    public void fillInEmail(String email) {
        emailInput.setValue(email);
    }

    //метод выбрать пол
    public void selectGender() {
        clickRadiobutton.click();
    }

    //метод указать номер мобильного телефона
    public void indicatePhoneNumber(String phoneNumber) {
        phoneInput.setValue(phoneNumber);
    }


    //методы заполнения поля Subjects
    public RegistrationForm selectSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    //метод выбрать чекбоксы для раздела Hobbies
    public RegistrationForm checkHobbies(String hobby) {
        hobbiesInput.$(byText(hobby)).click();
        return this;
    }

    //метод заполнить адрес
    public void fillInAddress(String address) {
        addressInput.setValue(address).scrollTo();
    }

    //метод загрузить картинку
    public void uploadPicture(String fileName) {
        selectFileButton.uploadFile(new File("src/test/resources/" + fileName));
        selectFileButton.uploadFromClasspath(fileName);
    }

    //метод выбрать штат
    public void selectState(String state) {
        stateField.click();
        stateFromDropdown.$(byText(state)).click();
    }

    //метод выбрать город
    public void selectCity(String city) {
        cityField.click();
        cityFromDropdown.$(byText(city)).click();
    }

    //метод нажать кнопку Submit
    public void clickSubmit() {
        submitButton.click();
    }

    //метод проверки наличия результирующей таблицы
    public void checkTable(String title) {
        tableTitle.shouldHave(text(title));
    }

    //проверка личных данных в таблице
    public RegistrationForm checkResultFullName(String fullName) {
        resultTable.shouldHave(text(fullName));
        return this;
    }

    public void checkResultEmail(String email) {
        resultTable.shouldHave(text(email));
    }

}
