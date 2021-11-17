package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static config.Project.config;

public class CalculateCreditTests extends TestBase {

    @Test
    @Description("Positive test fill out the online form")
    @DisplayName("Alfa tests")
    void getCreditFillFormTest() {

        step("Open main page " + config.webUrl(), () -> {
            open(config.webUrl());
        });
        step("Scroll to Get Credit and click on", () -> {
            $("img[alt='Кредит наличными']").scrollTo().click();
        });
        step("Fill out family name", () -> {
            $("input[name='fullName']").scrollTo();
            $("input[name='fullName']").setValue("Харуцкий").pressTab().pressTab();
            sleep(2000);
        });
        step("Fill out first names", () -> {
         //   $("input[name='firstName']").scrollTo();
            $("input[name='firstName']").setValue("Семен").pressTab();
        });
        step("Fill out middle names", () -> {
            $("input[name='middleName']").setValue("Анатольевич").pressTab();
        });
        step("Select gender if displaying", () -> {
            sleep(2000);
                $("button[data-test-id='sex-m']").scrollTo().click();
        });
        step("Fill out phone", () -> {
            $("input[name='phone']").setValue("9032334955");
        });
        step("Fill out email", () -> {
            $("input[name='email']").setValue("osiposilev@yandex.ru");
        });
        step("Click on checkbox", () -> {
            SelenideElement selenideElement = $("input[name='sopdConfirmed']").sibling(1).scrollTo();
            sleep(2000);
            selenideElement.click();
        });
        step("Click on Continued to step 2", () -> {
            $$("button[data-test-id='submit-button']").find(text("Продолжить")).click();
        });
        step("Chech Gosuslugi selecor at the step 2", () -> {
            sleep(2000);
            if ($(withText("Я помню пароль от личного кабинета Госуслуг")).isDisplayed()) {
                $$("button[type=button]").find(text("Нет")).click();
            }
        });
        step("Verify that step 2 is open", () -> {
            sleep(2000);
            $("h4.heading").shouldHave(text("Паспортные данные гражданина РФ"));
        });
        step("Fill out passport series", () -> {
            $("input[name='passportSeries']").scrollTo().setValue("2503");
        });
        step("Fill out passport number", () -> {
            $("input[name='passportNumber']").setValue("482796");
        });
        step("Fill out passport date", () -> {
            $("input[name='passportIssueDate']").setValue("12122019");
        });
        step("Fill out passport office code", () -> {
            $("input[name='passportOfficeCode']").scrollTo().setValue("362778").pressEnter();
        });
        step("Fill out passport office", () -> {
            sleep(2000);
            $(".passport-office").$("input[name='passportOffice']")
                    .append("ОВД").append(" Московской области").append(" город Зеленогорск");
        });
        step("Fill out birth date", () -> {
            $("input[name='birthDate']").click();
            $("input[name='birthDate']").append("03").append("04").append("1998");

        });
        step("Fill out birth place", () -> {
            $("input[name='passportBirthPlace']").setValue("Ленинградская область город Выборг");
        });
        step("Fill out registration place", () -> {
            $("input[name='registrationRegionCode']").setValue("Санкт-Петербург");
            $("div[data-for=registrationRegionCode]").$(withText("Санкт-Петербург")).click();
        });
        step("Fill out work region", () -> {
            $("input[name='workRegionCode']").setValue("Москва");
            $("div[data-for=workRegionCode]").$(withText("Москва")).click();
        });
        step("Fill out work company name", () -> {
            $("input[name='workCompanyName']").setValue("ООО \"СБЕРБАНК-ТЕЛЕКОМ\"");
            $("div[data-for=workCompanyName]").$(withText("СБЕРБАНК-ТЕЛЕКОМ")).click();
        });
        step("Fill out salary", () -> {
            $("input[name='income']").setValue("50000").pressEnter();
        });
        step("Click on continued", () -> {
            $("button[type='submit']").click();
        });
        step("Verify that step 3 is open", () -> {
            sleep(2000);
            $("h4.heading").shouldHave(text("Дополнительные сведения о работе"));
        });
        step("Select work experience", () -> {
            sleep(1500);
            $("div[data-test-id=workStartDateBucket]").click();
            $$("div.menu-item").find(text("Более 1 года")).click();
          });
        step("Select work position", () -> {
            sleep(2000);
            $("input[name=workPost]").setValue("Бухгалтер");
            $$("div.menu-item").find(text("Бухгалтер")).click();
        });
        step("Input work phone number", () -> {
            $("input[name=workPhone]").setValue("3574893392").pressEnter();
        });
        step("Select education rate", () -> {
            sleep(1000);
            $("div[data-test-id=education]").click();
            $$("div.menu-item").find(text("Высшее")).click();
        });
        step("Select marital status", () -> {
            $("div[data-test-id=maritalStatus]").click();
            $$("div.menu-item").find(text("Не женат")).click();
        });
        step("Input contact name", () -> {
            $("input[name=contactFirstName]").setValue("Семен").pressEnter();
            $$("div.menu-item").find(text("Семен")).click();
        });
        step("Input mobile phone number", () -> {
            $("input[name=contactMobilePhone]").setValue("9171775642");
        });
        step("Click on continued", () -> {
            sleep(1000);
            $("button[type='submit']").click();
        });
        step("Verify that step 4 is opened", () -> {
            $("h4.heading").shouldHave(text("У вас есть кредиты в других банках?"));
        });
        step("Click on No credit in other banks", () -> {
            $$("button[type='button']").find(text("Нет")).click();
        });
        step("Select credit purpose", () -> {
            $("div[data-test-id=creditPurpose]").click();
            $$("div.menu-item").find(text("Покупка автомобиля")).click();
        });
        step("Input credit sum", () -> {
            $("input[name=creditSum]").setValue("2000000").pressEnter();
        });
        step("Select payment day", () -> {
            $("div[data-test-id=paymentDay]").click();
            $$("div.menu-item").find(text("20  числа каждого месяца")).click();
        });
        step("Select credit form", () -> {
            $$("button[type='button']").find(text("5 лет")).click();
        });
        step("Click on continued", () -> {
            $("button[type='submit']").click();
        });
        step("Verify that step 5 is opened", () -> {
            $("h4.heading").shouldHave(text("Город получения кредита"));
        });
        step("Input city to fetch a credit", () -> {
            $("input[name=gettingCity]").setValue("Москва").pressEnter();
            $$("div.menu-item").find(text("Москва")).click();
        });
        step("Select secondary document", () -> {
            $("button[type='button']")
                    .$(withText("Второй документ, удостоверяющий личность")).click();
            $$("div.menu-item").find(text("ИНН физического лица")).click();
        });
        step("Select additional income", () -> {
            $("div[data-test-id=hasAdditionalIncome]")
                    .$$("button[type='button']").find(text("Нет")).click();
        });
        step("Select has no pension", () -> {
            $("div[data-test-id=hasPension]")
                    .$$("button[type='button']").find(text("Нет")).click();
        });
        step("Input code word", () -> {
            $("input[name=codeWord]").setValue("4giveme");
        });
        step("Click on submit request", () -> {
            $("button[type='submit']").click();
        });
        step("Verify that step 5 is opened", () -> {
            $(".check-mobile-phone")
                    .$("h4.heading").shouldHave(text("Введите одноразовый пароль из SMS"));
        });

    }

    @Test
    @Description("Positive test fill out the online form")
    @DisplayName("Alfa tests")
    void calculateMortgageTest(){

        step("Open main page " + config.webUrl(), () -> {
            open(config.webUrl());

        });
        step("Scroll to mortgage tab ", () -> {
            $("div[data-test-id=tabs-list-tabTitle-1]").scrollTo().click();
        });
        step("Select property value", () -> {
            ElementsCollection sliders = $$("input[type=range]");
            sliders.get(1).scrollTo().click();
            actions().moveToElement(sliders.get(1)).moveByOffset(-159, 0).click().perform();
       //     $(byText("Наше предложение")).scrollIntoView(true);

            sleep(5000);
        });

    }

}
