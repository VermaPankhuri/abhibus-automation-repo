package pageObjects;

import org.openqa.selenium.*;
import java.util.*;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver){

        this.driver=driver;
    }

    By acFilter = By.xpath("//label[contains(text(),'AC')]");

    By prices = By.xpath("//span[@class='fare']");

    By busNames = By.xpath("//h5");

    By timings = By.xpath("//span[@class='departure-time']");


    public void applyACFilter(){

        driver.findElement(acFilter).click();
    }


    public void getCheapestBus(){

        List<WebElement> fareList = driver.findElements(prices);

        int min = Integer.MAX_VALUE;
        int index = 0;

        for(int i=0;i<fareList.size();i++){

            int price = Integer.parseInt(
                fareList.get(i).getText().replace("₹","")
            );

            if(price<min){

                min=price;
                index=i;
            }
        }

        String bus =
        driver.findElements(busNames).get(index).getText();

        String time =
        driver.findElements(timings).get(index).getText();

        System.out.println("Bus Name : " + bus);
        System.out.println("Fare : " + min);
        System.out.println("Departure : " + time);
    }
}
