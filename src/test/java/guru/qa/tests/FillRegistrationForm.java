package guru.qa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class FillRegistrationForm extends TestBase {
    Faker faker = new Faker();
    String name = faker.name().firstName();

    @Test
    void testForm() {
        step("открыть страницу с формой", () -> {
            open("https://demoqa.com/automation-practice-form");
        });

        step("заполнить поле First Name", () -> {
            $("[id=firstName]").setValue("Kot");
        });

        step("заполнить поле Last Name", () -> {
            $("[id=lastName]").setValue("Kotov");
        });

        step("заполнить поле Email", () -> {
            $("[id=userEmail]").setValue("kot@gmail.com");
        });

        step("установить значение на радиобаттоне", () -> {
            $(".custom-control-label").click();
        });

        step("заполнить поле Mobile", () -> {
            $("[id=userNumber]").setValue("9235696703");
        });

        step("установить дату рождения в датапикере Date of Birth", () -> {
            $("[id=dateOfBirthInput]").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("1989");
            $(".react-datepicker__day--018:not(.react-datepicker__day--outside-month)").click();
        });

        step("заполнить поле Subjects", () -> {
            $("#subjectsInput").setValue("English").pressEnter();
            $("#subjectsInput").setValue("Maths").pressEnter();
        });

        step("выбрать чекбоксы в разделе Hobbies", () -> {
            $("[id=hobbiesWrapper]").$(byText("Reading")).click();
            $("[id=hobbiesWrapper]").$(byText("Music")).click();
        });

        step("загрузить картинку в разделе Picture", () -> {
            $("[id=uploadPicture]").uploadFile(new File("src/test/resources/picture/2.png"));
            $("[id=uploadPicture]").uploadFromClasspath("picture/2.png");
        });

        step("заполнить поле Current Address", () -> {
            $("[id=currentAddress]").setValue("Marksa").scrollTo();
        });

        step("выбрать State в разделе State and City", () -> {
            $("#state").click();
            $("#stateCity-wrapper").$(byText("Haryana")).click();
        });

        step("выбрать City в разделе State and City", () -> {
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Panipat")).click();
        });

        step("кликнуть кнопку Submit", () -> {
            $("[id=submit]").click();
        });

        step("проверка", () -> {
            $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        });

        step("проверка личных данных в таблице", () -> {
            $(".table-responsive").shouldHave(text("Kot Kotov"));
            $(".table-responsive").shouldHave(text("kot@gmail.com"));
        });

    }
}
