package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import utilities.DriverManager;


public class HomePageSteps {

    HomePage homePage = new HomePage(DriverManager.getDriver());



    @Given("user should see Home Page")
    public void userShouldSeeHomePage() {
        homePage.checkHomePageKesfet();
    }

    @When("user search {string} on Home Page")
    public void userSearchOnHomePage(String key) {
        homePage.searchKey(key);
    }
}
