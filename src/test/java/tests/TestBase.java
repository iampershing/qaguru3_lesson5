package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TestBase {

    BaseSteps steps = new BaseSteps();

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
            NAME = "qaguru3_lesson5",
            REPO = "UserForEducation/testrepository",
            TITLE = randomAlphanumeric(32),
            DESC = randomAlphanumeric(256);

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

        @Step("Login to Github")
        public void login() {
            $("[href='/login']").click();
            $("#login_field").val("UserForEducation");
            $("#password").val("EduPass123");
            $("[name='commit']").click();
        }

        @Step("Search for specific repository")
        public void searchForSpecificRepository() {
                $(".header-search-input").click();
                $(".header-search-input").setValue(REPO);
                $(".header-search-input").pressEnter();
        }

        @Step("Open repository")
        public void openRepository() {
                $(byLinkText(REPO)).click();
        }

        @Step("Open issue tab")
        public void openIssueTab() {
                $("[data-tab-item='issues-tab']").click();
                $(".js-cookie-consent-accept").click();
        }

        @Step("Click on Submit new Issue")
        public void clickOnSubmitNewIssue() {
                $x("//span[contains(text(),'New issue')]").should(enabled).click();
        }

        @Step("Fill the Title and Body form")
        public void fillTheTitleAndBodyForm() {
                $("#issue_title").should(visible).val(TITLE);
                $("#issue_body").should(visible).val(DESC);
        }

        @Step("Assign user")
        public void assignUser() {
                $(byText("assign yourself")).click();
        }

        @Step("Assign labels")
        public void assignLabels() {
                $(byText("Labels")).click();
                $("#label-filter-field").val("bug");
                $(".label-select-menu-item").$(byText("bug")).click();
                $(".label-select-menu-item").pressEscape();
        }

        @Step("Submit the issue")
        public void submitTheIssue() {
                $(byText("Submit new issue")).click();
        }

        @Step("Verify that issue Exist")
        public void verifyThatIssueExist() {
                $("[data-tab-item='issues-tab']").click();
                $(byText(TITLE)).should(exist);
        }

        @Step("Delete the issue")
        public void deleteTheIssue() {
                $(byText(TITLE)).click();
                $(byText("Delete issue")).click();
                $("[name='verify_delete']").click();
        }

        @Step("Verify that issue Deleted")
        public void verifyThatIssueDeleted() {
                $("[data-tab-item='issues-tab']").click();
                $(byText(TITLE)).shouldNot(visible);
        }
    }
}
