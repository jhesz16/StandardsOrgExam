package Helpers;

import Driver.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadowHelpers {

    public static WebDriver driver;
    public ShadowHelpers() {
        driver = Setup.getDriver();
    }


    public static WebElement getShadowObject(String shadowRootLocator,String docQuerySelector)
    {
        WebElement root = GlobalHelpers.getObj(shadowRootLocator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (WebElement) jsExecutor.executeScript("return "+docQuerySelector, root);
    }

    public static void clickShadowObject(String shadowRootLocator,String docQuerySelector) throws InterruptedException {
        Thread.sleep(1000);
        WebElement obj = getShadowObject(shadowRootLocator,docQuerySelector);
        try {
            obj.click();
        }
        catch (Exception e)
        {
            obj = getShadowObject(shadowRootLocator,docQuerySelector);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(shadowRootLocator)));
            obj.click();
        }

        try {
            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
        } catch (Exception e) {

        }
        System.out.println(shadowRootLocator + " clicked.");
    }
}
