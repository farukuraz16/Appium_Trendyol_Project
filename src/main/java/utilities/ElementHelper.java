package utilities;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {

    private WebDriver driver;
    private WebDriverWait wait;


    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void yazdir(By element) {
        List<WebElement> elements = driver.findElements(element);
        for (WebElement elem : elements) {
            System.out.println(elem.getText());

        }
    }

    public WebElement findElement(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            return scroll(locator).get(0);
        }
    }

    /*eski metot
    public WebElement findElement(By locator) {
        return  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }*/


    public List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void checkElement(By locator) {
        findElement(locator);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public String getText(By locator) {
        System.out.println("findElement().getText() = " + findElement(locator).getText());
        return findElement(locator).getText();
    }

    public void clickListElement(By locator, String text) {
        boolean check = false;
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        for (WebElement element : elements) {
            if (element.getAttribute("value").contains(text)) {
                element.click();
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    public void pressEnter (){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
    }
    public void sendKeys(By locator, String text) {
       findElement(locator).sendKeys(text);
    }



/*
 public void scroll(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        RemoteWebElement element =(RemoteWebElement)driver.findElement(locator);
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", element.getId());
        js.executeScript("mobile: scroll", scrollObject);
    }
 */

        /*
        while (true) {
            if (driver.findElements(vercitasLocate).size() > 0) {
                driver.findElement(vercitasLocate).click();
                break;
            } else {
                Dimension size = driver.manage().window().getSize();
                int startX = size.getWidth() / 2;
                int startY = size.getHeight() / 2;
                int endY = (int) (startY * 0.2); // Kaydırma işlemi sonrası 20% kadar yukarıya kaydır
                Duration duration = Duration.ofMillis(500); // Kaydırma süresi (ms)
                TouchAction action = new TouchAction(driver);
                action.press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(duration))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                // Beklemek için biraz zaman tanı
                Thread.sleep(2000);
            }
         */



    /* eski metot...
    public void clickElementWithText(By locator, String text){
        boolean check = false;
        List<WebElement> elementList = findElements(locator);
        for (WebElement elem:elementList) {
            if (elem.getText().equals(text)){
                check = true;
                elem.click();
                break;
            }
        }

        Assert.assertTrue(check,"listede element yok!");
    }
*/
    public void clickElementWithText(By locator, String text) {
        int i = 0;
        boolean check = false;
        findElement(locator);
        while (i < 6) {
            List<WebElement> elementList = findElements(locator);
            for (WebElement elem : elementList) {
                if (elem.getText().equals(text)) {
                    check = true;
                    elem.click();
                    break;
                }
            }
            if (check) {
                break;
            } else {
                scrollDown();
                i++;
            }
        }
        Assert.assertTrue(check, "Listede istediğin textteki elamanı bulamadım!!!");
    }


    public List<WebElement> scroll(By by) {
        int i = 0;
        String previusPageSource = ".";
        while (checkElementEnabled(by) && i < 5 && checkEndOfPage(previusPageSource)) {
            i++;
            previusPageSource = driver.getPageSource();
            scrollDown();
        }
        return driver.findElements(by);
    }

    public boolean checkEndOfPage(String previusPageSource) {
        return !previusPageSource.equals(driver.getPageSource());
    }

    public boolean checkElementEnabled(By by) {

        return driver.findElements(by).isEmpty();
    }


    public void scrollDown() {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;
        int endx = driver.manage().window().getSize().getWidth() / 2;
        int endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endx, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(List.of(scroll));
    }


    public void checkElementWithText(By locator, String text) {
        int i = 0;
        boolean check = false;
        while (i < 6) {
            List<WebElement> elementList = findElements(locator);
            for (WebElement elem : elementList) {
                if (elem.getText().equals(text)) {
                    check = true;
                    Assert.assertTrue(elem.getText().equals(text));
                    break;
                }
            }
            if (check) {
                break;
            } else {
                scrollDown();
                i++;
            }
        }
        Assert.assertTrue(check, "Listede istediğin textteki elamanı bulamadım!!!");
    }

    public boolean checkElementWithText2(By locator, String text) {
        int i = 0;
        boolean check = false;
        while (i < 6) {
            List<WebElement> elementList = findElements(locator);
            for (WebElement elem : elementList) {
                if (elem.getText().equals(text)) {
                    check = true;
                    Assert.assertTrue(elem.getText().equals(text));
                    break;
                }
            }
            if (check) {
                break;
            } else {
                scrollDown();
                i++;
            }
        }
        return check;
    }

}
