package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utilities.DriverManager;

public class CartPageSteps {
    CartPage cartPage = new CartPage(DriverManager.getDriver());
    @Then("user should see the product on the Cart Page")
    public void userShouldSeeTheProductOnTheCartPage() {
        cartPage.checkProduct();
    }

    @When("user taps Delete button on Cart Page")
    public void userTapsDeleteButtonOnCartPage() {
        cartPage.clickDelete();
        
    }

    @And("user taps Popup Delete button on Cart Page")
    public void userTapsPopupDeleteButtonOnCartPage() {
        cartPage.clickDeletePopup();
    }

    @Then("user should see the message {string} on Cart Page")
    public void userShouldSeeTheMessageOnCartPage(String deleteMessage) {
cartPage.checkDeleteMessage(deleteMessage);
    }
}
