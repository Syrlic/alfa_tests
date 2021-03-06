package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Project;
import helper.AllureAttachments;
import helper.DriverSettings;
import helper.DriverUtils;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;

@Tag("properties")
public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
     //   DriverSettings.configure();
            Configuration.startMaximized = true;

    }

//    @AfterEach
//    public void addAttachments() throws InterruptedException {
//        String sessionId = DriverUtils.getSessionId();
//
//        AllureAttachments.addScreenshotAs("Last screenshot");
//        AllureAttachments.addPageSource();
//        AllureAttachments.addBrowserConsoleLogs();
//
//        Selenide.closeWebDriver();
//
//        if (Project.isVideoOn()) {
//            AllureAttachments.addVideo(sessionId);
//        }
//    }
}
