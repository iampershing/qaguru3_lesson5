package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;

@Feature("QA.Guru Homework")
@Story("Homework")
public class SelenideGitHubTests extends TestBase {

    @Test
    @Issue("JIRA-123321")
    @DisplayName("Selenide - Check That Homework for Lecture 3 Exist")
    @Description("Verification that homework have been completed")
    @Tag("GitHub")
    @Owner("Sergei P")
    @Severity(SeverityLevel.CRITICAL)
    public void assertThatLectureThreeHomeworkExistSelenide() {
        open(URL);
        $(".header-search-input").click();
        $(".header-search-input").setValue(USER);
        $(".header-search-input").pressEnter();
        $(byText("Users")).click();
        $(".user-list").shouldHave(text(USER));
        $(byLinkText(USER)).click();
        $(withText(NAME)).should(exist);
    }
}
