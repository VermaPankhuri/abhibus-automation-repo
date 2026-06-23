package hooks;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.Base;
import io.cucumber.java.Before;

public class ScenarioHook extends Base {

    RemoteWebDriver remoteDriver;

    @Before
    public void setup() {

        try {
            String browser = this.getBrowser();

            // Chrome Browser Setup
            if (browser.equals("chrome")) {

                ChromeOptions options = new ChromeOptions();
                options.setCapability("platformName", "Windows");

                remoteDriver = new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        options
                );
            }

            // Edge Browser Setup
            else if (browser.equals("edge")) {

                EdgeOptions options = new EdgeOptions();
                options.setCapability("platformName", "Windows");

                remoteDriver = new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        options
                );
            }

            // Set Driver in Base class
            setDriver(remoteDriver);

            // Implicit Wait
            getDriver().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}