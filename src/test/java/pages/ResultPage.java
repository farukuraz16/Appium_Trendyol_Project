package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementHelper;

public class ResultPage {

    ElementHelper elementHelper;

    By filterButton = By.id("trendyol.com:id/layout_search_filter");
    By orderButton = By.id("trendyol.com:id/layout_search_order");
    By secondProduct = By.id("trendyol.com:id/productCardViewRightProduct");

    public ResultPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickFilter(){
        elementHelper.click(filterButton);
    }
    public void clickOrder(){
        elementHelper.click(orderButton);
    }
    public void clickSecondProduct(){
        elementHelper.click(secondProduct);
    }


}
