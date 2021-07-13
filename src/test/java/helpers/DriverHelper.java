package helpers;

import com.codeborne.selenide.Configuration;
import config.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class DriverHelper {

    public static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());

    public static void configureDriver(){

        Configuration.browser = driverConfig.webBrowser();
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;
        Configuration.browserVersion = driverConfig.webBrowserVersion();

        if (!driverConfig.webRemoteDriverUrl().equals("")) {
            String user = driverConfig.webRemoteDriverUser();
            String password = driverConfig.webRemoteDriverPassword();
            Configuration.remote = String.format(driverConfig.webRemoteDriverUrl(), user, password);
            System.out.println(String.format(driverConfig.webRemoteDriverUrl(), user, password));
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}