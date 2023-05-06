package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementHelper;

public class OrderPage {

    ElementHelper elementHelper;

    By radioButton = By.id("trendyol.com:id/radioButtonSortingTypeItem");


    public OrderPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickHighRate(String highRate) {
        elementHelper.clickElementWithText(radioButton, highRate);}
}