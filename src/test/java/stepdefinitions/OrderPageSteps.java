package stepdefinitions;

import io.cucumber.java.en.And;
import pages.OrderPage;
import utilities.DriverManager;

public class OrderPageSteps {
    OrderPage orderPage = new OrderPage(DriverManager.getDriver());

    @And("user taps {string} option on Order Page")
    public void userTapsOptionOnOrderPage(String highRate) {

        orderPage.clickHighRate(highRate);
    }
}
