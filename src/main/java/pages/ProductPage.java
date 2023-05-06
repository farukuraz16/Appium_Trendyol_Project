package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementHelper;

public class ProductPage {

    ElementHelper elementHelper;

    By addToCart = By.id("trendyol.com:id/primaryButton");
    By approveAddToCart = By.id("trendyol.com:id/buttonAddToBasketOrChooseVariant");
    By sizeButton = By.id("trendyol.com:id/textViewValue");


    public ProductPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void addToCart() {
        elementHelper.click(addToCart);
    }
    public void addToCartAgain() {
        elementHelper.click(approveAddToCart);
    }

    public void chooseSize(String size) {
        elementHelper.clickElementWithText(sizeButton, size);
    }

}
