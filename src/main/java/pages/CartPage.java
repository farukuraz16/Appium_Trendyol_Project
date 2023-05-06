package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementHelper;

public class CartPage {

    ElementHelper elementHelper;

    By productInCart = By.id("trendyol.com:id/textViewBrandName");
    By deleteButton = By.id("trendyol.com:id/imageViewDeleteProduct");
    By deletePopupButton = By.id("trendyol.com:id/textViewBasketRemoveAction");
    By deleteMessage = By.id("trendyol.com:id/textViewMessage");


    public CartPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkProduct() {
        elementHelper.checkElement(productInCart);
    }

    public void clickDelete() {
        elementHelper.click(deleteButton);
    }

    public void clickDeletePopup() {
        elementHelper.click(deletePopupButton);
    }

    public void checkDeleteMessage(String expectedMessage){
        String actualMessage = elementHelper.findElement(deleteMessage).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

}
