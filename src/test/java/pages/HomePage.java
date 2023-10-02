package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementHelper;

public class HomePage {

    ElementHelper elementHelper;

    By kesfet = By.id("trendyol.com:id/textViewHomepageTab");
    By searchBar = By.id("trendyol.com:id/edittext_search_view");
    By firstOfferKey = By.id("trendyol.com:id/textViewSearchSuggestionText");


    public HomePage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkHomePageKesfet(){
        elementHelper.checkElement(kesfet);
    }

    public void searchKey(String key){
        elementHelper.click(searchBar);
        elementHelper.sendKeys(searchBar,key);
        elementHelper.click(firstOfferKey);
    }


}
