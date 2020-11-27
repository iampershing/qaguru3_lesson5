package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("QA.Guru Homework")
@Story("Homework")
public class LambdaGitHubTests extends TestBase {

    @Test
    @Issue("JIRA-123321")
    @DisplayName("Using Lambda - Check That Homework for Lecture 5 Exist")
    @Description("Verification that homework have been completed")
    @Tag("GitHub")
    @Owner("Sergei P")
    @Severity(SeverityLevel.TRIVIAL)
    public void assertThatLectureFiveHomeworkExistUsingLambda() {
        step("Open GitHub page", (step) -> {
            open(URL);
        });
        step("Search for repository", (step) -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(USER);
            $(".header-search-input").pressEnter();
        });
        step("Search for the user", (step) -> {
            $(byText("Users")).click();
            $(".user-list").shouldHave(text(USER));
        });
        step("Open user page", (step) -> {
            $(byLinkText(USER)).click();
        });
        step("Assert that homework exist", (step) -> {
            $(withText(NAME)).should(exist);
        });
    }
}
