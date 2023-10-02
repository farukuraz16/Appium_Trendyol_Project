package utilities;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }

    public static WebDriver createDriver(String browser, String url, int implictyWait) {
        WebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "android":
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("udid", "emulator-5554");
                //capabilities.setCapability( "app", "/Users/faruk/Downloads/trendyol.com-6.28.2.682-free-www.apksum.com.apk");
                capabilities.setCapability( "appActivity", "com.trendyol.common.splash.impl.ui.SplashActivity");
                capabilities.setCapability( "appPackage", "trendyol.com");
                capabilities.setCapability("noReset", true);

                try {
                    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "ios":
                capabilities.setCapability("platformName", "iOS");
                try {
                    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                throw new RuntimeException("Invalid browser type provided!");
        }
        driverThread.set(driver);
        if (!browser.equals("android") && !browser.equals("ios")) {
            driver.get(url);
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implictyWait));
        return driver;
    }
}
