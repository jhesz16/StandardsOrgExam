package Helpers;

import Driver.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class GlobalHelpers {

    public static WebDriver driver;

    public GlobalHelpers() {
        driver = Setup.getDriver();
        ShadowHelpers.driver = driver;
    }


    public static void clickObj(String locator) {

        WebElement obj = getObj(locator);
        try {
            obj.click();
        } catch (Exception e) {
            obj = getObj(locator);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            obj.click();
        }

        try {
            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
        } catch (Exception e) {

        }
        System.out.println(locator + " clicked.");
    }

    public static void clickObj_FailIfWithAlert(String locator) {
        getObj(locator).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Thread.sleep(3000);
            String message = driver.switchTo().alert().getText();
            if (message != "") {
                System.out.println(message);
                assert false;
            }
        } catch (Exception e) {
            System.out.println("PASS");
        }
    }

    public static WebElement getObject(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement obj = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            obj = driver.findElement(By.xpath(locator));
            obj.isDisplayed();
            obj.isEnabled();
        } catch (Exception e) {
        }
        return obj;
    }

    public static WebElement getObjectQuick(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement obj = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            obj = driver.findElement(By.xpath(locator));
            obj.isDisplayed();
            obj.isEnabled();
        } catch (Exception e) {
        }
        return obj;
    }

    public static void hoverObject(String locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getObj(locator)).build().perform();
        System.out.println(locator + " hovered.");
    }

    public static WebElement getObj(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement obj = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            obj = driver.findElement(By.xpath(locator));
            obj.isDisplayed();
            obj.isEnabled();
        } catch (Exception e) {
            System.out.println("Locator: " + locator + " not found.");
            assert false;
        }

        System.out.println(locator + " is displayed and enabled.");
        return obj;
    }

    public static void waitForObjToDisappear(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement obj = null;
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
        } catch (Exception e) {
            System.out.println("Locator: " + locator + " still found.");
            assert false;
        }


        System.out.println(locator + " is displayed and enabled.");
    }

    public static WebElement getObj_Negative(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement obj = null;
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
            //obj = Driver.findElement(By.xpath(locator));
            obj.isDisplayed();
            obj.isEnabled();
            System.out.println("Locator: " + locator + " not found.");
            assert false;
        } catch (Exception e) {
        }


        return obj;
    }

    public static void setValObj(String locator, String value) {
        try {
            getObj(locator).clear();
            getObj(locator).sendKeys(value);

        } catch (ElementNotInteractableException e) {
            getObj(locator).click();
            getObj(locator).sendKeys(value);

        }
    }

    public static void selectValObj(String locator, String value) {
        clickObj(locator);
        clickObj("//*[text()='" + value + "']");
    }

    public static boolean validateObj(String locator) {
        return getObject(locator).isDisplayed();
    }

    public static void checkIfLoading() {
        String locator = "//div[@class='loading-mask']";
        if (getObjectQuick(locator) == null) {
            return;
        }
        while (validateObj(locator)) {
        }
    }

    public static List<WebElement> getObjects(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        List<WebElement> obj = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            obj = driver.findElements(By.xpath(locator));
        } catch (Exception e) {
        }
        return obj;

    }

    public static void switchToLastTab() {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tabs2.size() - 1));
    }

}
