package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public WebDriver driver;
    public Actions action;
    public WebDriverWait wait;
    Select select;
    Alert alert;
    JavascriptExecutor js;


    public PageBase(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) driver;
    }


    public void clickButton(By element) {
        js.executeScript("arguments[0].click();", driver.findElement(element));
    }

    public boolean isDisplay(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public void selectByVisibaleText(By element, String Value) {
        select = new Select(driver.findElement(element));
        select.selectByVisibleText(Value);
    }

    public void selectByIndex(By element, int Value) {
        select = new Select(driver.findElement(element));
        select.selectByIndex(Value);
    }

    public void selectByText(By element, String Value) {
        select = new Select(driver.findElement(element));
        select.selectByValue(Value);
    }

    public void clickOnButton(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();

    }

    public void sendText(By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    public void sendText(By element, Keys key) {
        driver.findElement(element).sendKeys(key);
    }

    public void clearText(By element) {
        driver.findElement(element).clear();
    }

    public void uploadFile(By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    public void Alert() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getText(By element) {

        return driver.findElement(element).getText();
    }

    public void hoverMouse(By element) {

        action.moveToElement(driver.findElement(element)).build().perform();
    }

    public void scrollViewElement(By element) {
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
    }

}
