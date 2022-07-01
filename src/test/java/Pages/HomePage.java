package Pages;


import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends PageBase {


    By btn_signInMenu = By.xpath("//a[@class='login']");


    public HomePage(WebDriver driver) {

        super(driver);
    }

    public void signIn() {

        clickOnButton(btn_signInMenu);
    }

}
