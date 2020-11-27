package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    void setUp() {
        Configuration.startMaximized = true;
        Selenide.clearBrowserCookies();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }

    public String URL = "https://github.com/",
            USER = "iampershing",
            NAME = "qaguru3_lesson5";
}
