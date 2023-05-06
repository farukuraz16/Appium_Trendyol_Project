package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementHelper;

public class FilterPage {

    ElementHelper elementHelper;

    By freeShippingFilter = By.id("trendyol.com:id/filterName");
    By checkBox = By.id("trendyol.com:id/checkBoxSpecialFilter");
    By listProducts = By.id("trendyol.com:id/btnApplyFilter");

    public FilterPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickFreeShipping(String freeShipping) {
        elementHelper.clickElementWithText(freeShippingFilter, freeShipping);
        elementHelper.click(checkBox);
    }

    public void listAllResults() {
        elementHelper.click(listProducts);
    }


}


