package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentHelper.*;
import static helpers.DriverHelper.configureDriver;

public class TestBase {

    @BeforeAll
    static void setUp(){
        configureDriver();
    }

    @AfterEach
    public void addAttachments(){
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (System.getProperty("video.storage") != null)
            attachVideo();
        closeWebDriver();
    }
}