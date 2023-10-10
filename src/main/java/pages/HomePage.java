package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ElementHelper;
import utilities.Log;

public class HomePage {

    ElementHelper elementHelper;


    By subscriptionTitle = By.id("com.dmall.mfandroid:id/llPersonalInfoGuest");
    By searchBar = By.id("com.dmall.mfandroid:id/tvHomeSearchBar");
    By firstOfferKey = By.id("trendyol.com:id/textViewSearchSuggestionText");


    public HomePage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkHomePageKesfet(){
        elementHelper.checkElement(subscriptionTitle);
    }

    public void searchKey(String key){
        elementHelper.click(searchBar);
        elementHelper.sendKeys(searchBar,key);
        elementHelper.click(firstOfferKey);
    }


}
