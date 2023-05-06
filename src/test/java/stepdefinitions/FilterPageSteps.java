package stepdefinitions;

import io.cucumber.java.en.And;
import pages.FilterPage;
import utilities.DriverManager;

public class FilterPageSteps {
    FilterPage filterPage = new FilterPage(DriverManager.getDriver());

    @And("user taps {string} on Filter Page")
    public void userTapsOnFilterPage(String freeShipping) {
        filterPage.clickFreeShipping(freeShipping);
    }

    @And("user taps ÜRÜNLERİ LİSTELE button on Filter Page")
    public void userTapsÜRÜNLERİLİSTELEButtonOnFilterPage() {
        filterPage.listAllResults();
    }
}
