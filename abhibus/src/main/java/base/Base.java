/*package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    public static WebDriver driver;

    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.abhibus.com");
    }

    public void tearDown() {

        driver.quit();
    }
} */


package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    // Driver accessible in all classes
    public static WebDriver driver;

    // Explicit wait
    public static WebDriverWait wait;

    // Read config file
    public static Properties properties;


    // Load properties file
    public Properties loadProperties() throws IOException {

        properties = new Properties();

        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                + "/src/main/resources/data.properties");

        properties.load(fis);

        fis.close();

        return properties;
    }


    // Browser setup + open website
    public WebDriver initializeDriver() throws IOException {

        properties = loadProperties();

        String browser = properties.getProperty("browser");


        // Chrome browser setup
        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-notifications");

            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);

        } else {

            throw new IllegalArgumentException(
                    "Only Chrome browser is supported");
        }


        // Wait settings
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));


        // Open Abhibus website
        driver.get(properties.getProperty("url"));

        return driver;
    }


    // Close browser
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}