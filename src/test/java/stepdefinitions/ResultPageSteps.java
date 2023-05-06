package stepdefinitions;

import io.cucumber.java.en.And;
import pages.ResultPage;
import utilities.DriverManager;

public class ResultPageSteps {
    ResultPage resultPage = new ResultPage(DriverManager.getDriver());

    @And("user taps Filter on Result Page")
    public void userTapsFilterOnResultPage() {
        resultPage.clickFilter();
    }

    @And("user taps Order on Result Page")
    public void userTapsOrderOnResultPage() {
        resultPage.clickOrder();
    }

    @And("user taps second product on Result Page")
    public void userTapsSecondProductOnResultPage() {
        resultPage.clickSecondProduct();
    }
}
