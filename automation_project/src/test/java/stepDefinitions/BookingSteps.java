package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchBusPage;

import java.time.Duration;

/* */
/*public class SearchBusStep {

    private WebDriver driver;
    private SearchBusPage searchBusPage;

@Given("user opens abhibus website")
    public void openSite() {
        page = new AbhiBusPage(Base.initDriver());
        page.openSite();
    }

    @When("user selects source and destination")
    public void selectCities() {
        page.selectSource("Hyderabad");
        page.selectDestination("Bangalore");
    }

    @When("user selects journey date")
    public void selectDate() {
        page.selectDate();
    }

    @When("user clicks search")
    public void clickSearch() {
        page.clickSearch();
    }

    @Then("user applies AC filter")
    public void applyFilter() {
        page.applyACFilter();
    }

    @Then("user gets bus list")
    public void getBusDetails() {
        page.printBusDetails();
    } */


          @Given("User opens Abhibus website")
    public void user_opens_abhibus_website() {
        // Get the WebDriver instance initialized by ScenarioHook
        this.driver = hooks.ScenarioHook.driver;

        // Wait for the search form container to be present (SPA needs time to render)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.id("search-form-container")));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("abhibus"),
                "Failed to open AbhiBus website. Current URL: " + currentUrl);
        System.out.println("AbhiBus website opened successfully. URL: " + currentUrl);

        // Initialize page object after page is loaded
        searchBusPage = new SearchBusPage(driver);
    }

    @When("User enters {string} in Leaving From")
    public void user_enters_in_leaving_from(String source) {
        searchBusPage.enterLeavingFrom(source);
        System.out.println("Entered source city: " + source);
    }

    @When("User enters {string} in Going To")
    public void user_enters_in_going_to(String destination) {
        searchBusPage.enterGoingTo(destination);
        System.out.println("Entered destination city: " + destination);
    }

    @When("User selects travel date")
    public void user_selects_travel_date() {
        searchBusPage.selectTravelDate();
        System.out.println("Travel date selected successfully.");
    }

    @When("User clicks Search")
    public void user_clicks_search() {
        searchBusPage.clickSearchButton();
        System.out.println("Search button clicked.");
    }

    @Then("Bus results should appear")
    public void bus_results_should_appear() {
        boolean resultsDisplayed = searchBusPage.areBusResultsDisplayed();
        Assert.assertTrue(resultsDisplayed, "Bus results are not displayed on the page.");
        System.out.println("Bus results are displayed successfully.");
    }

    @When("User selects AC filter")
    public void user_selects_ac_filter() {
        searchBusPage.selectAcFilter();
        System.out.println("AC filter step executed.");
    }

    @When("User selects Cheapest first filter")
    public void user_selects_cheapest_first_filter() {
        searchBusPage.selectCheapestFirstFilter();
        System.out.println("Cheapest first filter step executed.");
    }

    @When("User selects departure time filter")
    public void user_selects_departure_time_filter() {
        searchBusPage.selectDepartureTimeFilter();
        System.out.println("Departure time filter step executed.");
    }
}