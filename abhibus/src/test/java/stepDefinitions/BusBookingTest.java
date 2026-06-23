package stepDefinitions;

import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;

public class BusBookingTest extends Base {

    @Test

    public void searchBus() throws Exception{
    	 initializeDriver();

        HomePage hp = new HomePage(driver);

        hp.enterSource("Delhi");

        Thread.sleep(2000);

        hp.enterDestination("Lucknow");

        hp.selectDate();

        hp.clickSearch();

        SearchResultPage sr =
        new SearchResultPage(driver);

        Thread.sleep(3000);

        sr.applyACFilter();

        Thread.sleep(2000);

        sr.getCheapestBus();

        tearDown();
    }
}
    /*
	private void setup() {
		// TODO Auto-generated method stub
		
	}
} 



package stepDefinitions;

import org.testng.annotations.Test;
import base.Base;

public class BusBookingTest extends Base {

    @Test
    public void test() {

        setup();

        System.out.println("Browser Opened");

        tearDown();
    }
}
*/