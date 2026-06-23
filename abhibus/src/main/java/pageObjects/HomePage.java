package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By source = By.xpath("//input[@placeholder='Leaving From']");

    By destination = By.xpath("//input[@placeholder='Going To']");

    By date = By.xpath("//input[contains(@placeholder,'Onward')]");

    By searchButton = By.xpath("//button[contains(text(),'Search')]");


    public void enterSource(String city) {

        driver.findElement(source).sendKeys(city);
    }

    public void enterDestination(String city) {

        driver.findElement(destination).sendKeys(city);
    }

    public void selectDate() {

        driver.findElement(date).click();

        // choose date logic
    }

    public void clickSearch() {

        driver.findElement(searchButton).click();
    }
}