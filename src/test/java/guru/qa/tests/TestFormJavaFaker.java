package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestFormJavaFaker extends TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    //Генерация рандомного firstname с помощью javafaker
    Faker faker = new Faker();
    String name = faker.name().firstName();


    @Test
    void testForm() {
        //открыть страницу с формой
        registrationForm.openPage();

        //заполнить поле "First Name"
        registrationForm.fillInFirstName(name)
                .fillInLastName("Kotov");

        //заполнить поле "Email"
        registrationForm.fillInEmail("kot@gmail.com");

        //установить значение на радиобаттоне
        registrationForm.selectGender();

        //заполнить поле "Mobile"
        registrationForm.indicatePhoneNumber("9234874848");

        //установить дату рождения в датапикере "Date of Birth"
        registrationForm.calendar.selectDate("18", "May", "1989");

        //заполнить поле Subjects
        registrationForm.selectSubjects("English")
                .selectSubjects("Math");

        //выбрать чекбоксы в разделе "Hobbies"
        registrationForm.checkHobbies("Reading")
                .checkHobbies("Music");

        //загрузить картинку в разделе Picture
        registrationForm.uploadPicture("picture/2.png");

        //заполнить поле Current Address
        registrationForm.fillInAddress("Omsk.Marksa");

        //выбрать State в разделе "State and City"
        registrationForm.selectState("Haryana");

        //выбрать City в разделе "State and City"
        registrationForm.selectCity("Panipat");

        //кликнуть кнопку "Submit"
        registrationForm.clickSubmit();

        //проверка
        registrationForm.checkTable("Thanks for submitting the form");

        //проверка личных данных в таблице
        registrationForm.checkResultFullName(name + " Kotov")
                .checkResultEmail("kot@gmail.com");
    }


}
