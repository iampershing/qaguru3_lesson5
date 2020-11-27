package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeEach
    void setUp() {
        Configuration.startMaximized = true;
        Selenide.clearBrowserCookies();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }

    @AfterEach
    void cleanUp() {
        Selenide.closeWebDriver();
    }

    public String URL = "https://github.com/",
            USER = "iampershing",
            NAME = "qaguru3_lesson5";

    public class BaseSteps {
        @Step("Open Main Page")
        public void openUrl() {
            open(URL);
        }

        @Step("Search for Repository")
        public void searchForRepository() {
            $(".header-search-input").click();
            $(".header-search-input").setValue(USER);
            $(".header-search-input").pressEnter();
        }

        @Step("Search for User")
        public void searchForUser() {
            $(byText("Users")).click();
            $(".user-list").shouldHave(text(USER));
        }

        @Step("Open User Page")
        public void openUserPage() {
            $(byLinkText(USER)).click();
        }

        @Step("Assert That Homework Exist")
        public void assertThatHomeworkExist() {
            $(withText(NAME)).should(exist);
        }
    }
}
