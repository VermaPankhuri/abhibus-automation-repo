package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    // Global driver
    public static WebDriver driver;

    // Properties file object
    public static Properties prop;


    // Load config file
    public Properties loadProperties() throws IOException {

        prop = new Properties();

        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                + "/src/main/resources/data.properties");

        prop.load(fis);

        fis.close();

        return prop;
    }


    // Browser setup
    public WebDriver initializeDriver() throws IOException {

        // Read data.properties
        prop = loadProperties();

        String browser = prop.getProperty("browser");

        // Chrome browser
        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);

        } else {

            System.out.println("Only Chrome browser supported");
        }

        // Wait
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        // Open website
        driver.get(prop.getProperty("url"));

        return driver;
    }


    // Close browser
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}
