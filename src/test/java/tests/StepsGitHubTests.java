package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("QA.Guru Homework")
@Story("Homework")
public class StepsGitHubTests extends TestBase {

    @Test
    @DisplayName("Using Steps - Check That Homework for Lecture 5 Exist")
    @Description("Verification that homework have been completed")
    @Tag("GitHub")
    @Owner("Sergei P")
    @Severity(SeverityLevel.TRIVIAL)
    public void assertThatLectureFiveHomeworkExistUsingSteps() {
        BaseSteps steps = new BaseSteps();
        steps.openUrl();
        steps.searchForRepository();
        steps.searchForUser();
        steps.openUserPage();
        steps.assertThatHomeworkExist();
    }
}
