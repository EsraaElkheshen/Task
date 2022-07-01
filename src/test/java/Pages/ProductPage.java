package Pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends PageBase {
    By btn_Woman = By.xpath("//Li//a[text()='Women']");
    By btn_searchProduct = By.cssSelector(".right-block .product-name");
    //By txt_result = By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']//h1[text()='Blouse']");
    By btn_viewScreen = By.xpath("//img[@title='Blouse']");
    By btn_addCart = By.xpath("//div[@class='button-container']//span[text()='Add to cart']");
    By btn_proceedCheckOut = By.xpath("//a[@title='Proceed to checkout']");
    By btn_firstProceedToCheckOut = By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order&step=1']");
    By btn_secondProceedToCheckOut = By.xpath("//button[@name='processAddress']");
    By btn_agreeTermService = By.xpath("//div[@id='uniform-cgv']");
    By btn_thirdProceedToCheckOut = By.xpath("//button[@name='processCarrier']");
    By btn_payBankWire = By.xpath("//a[@title='Pay by bank wire']");
    By btn_confirmOrder = By.xpath("//button[@type='submit' and @class='button btn btn-default button-medium']");
    By btn_confirmMessage = By.xpath("//strong[text()='Your order on My Store is complete.']");
    By txt_orderReferenece = By.xpath("//div[@class='box']");
    By btn_backOrder = By.xpath("//a[@title='Back to orders']//i");
    By txt_result = By.xpath("//tbody//tr[@class='first_item ']");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By getProduct(String productName) {
        return By.xpath("//li//a[text()='" + productName + "']");

    }

    // Select “Blouses” Subcategory in “Women” Category
    public void selectWomanSubCategory(String product) {
        hoverMouse(btn_Woman);
        clickOnButton(getProduct(product));

    }

    // Select resulted product
    public void navigateToSelectProduct() {
        clickOnButton(btn_searchProduct);
    }

    //public boolean isResultDisplay() {
    //  return isDisplay(txt_result);
    //}

    // Follow checkout procedure
    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btn_viewScreen)));
        scrollViewElement(btn_viewScreen);
        hoverMouse(btn_viewScreen);
        clickOnButton(btn_addCart);
        clickOnButton(btn_proceedCheckOut);
        clickOnButton(btn_firstProceedToCheckOut);
        clickOnButton(btn_secondProceedToCheckOut);
        scrollViewElement(btn_agreeTermService);
        clickOnButton(btn_agreeTermService);
        clickOnButton(btn_thirdProceedToCheckOut);
    }

    // pay with BankWire and confirm order
    public void confirmOrder() {
        clickOnButton(btn_payBankWire);
        clickOnButton(btn_confirmOrder);

    }

    public String getReferneceText() {
        return getText(txt_orderReferenece);
    }

    public boolean getResultText(String value) {
        return getText(txt_result).contains(value);
    }


    public boolean isconfirmationMessageDisplay() {
        return isDisplay(btn_confirmMessage);
    }

    //Validate order was placed from order history page.
    public void backToOrder() {
        scrollViewElement(btn_backOrder);
        clickOnButton(btn_backOrder);
    }

}





