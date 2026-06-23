package base;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class Base {

    public static void main(String[] args) throws Exception {
        Base base = new Base();

        System.out.println(base.getUrl());
        System.out.println(base.getBrowser());
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver1) {
        driver = driver1;
    }

    public String getUrl() throws Exception {
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(
                "path_of_properties_file");

        prop.load(fis);

        String url = prop.getProperty("url");
        return url;
    }

    public String getBrowser() throws Exception {
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(
                "path_of_properties_file");

        prop.load(fis);

        String browser = prop.getProperty("browser");
        return browser;
    }
}