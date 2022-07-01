package Pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends PageBase {
    By txt_Email = By.id("email_create");
    By txt_emailAddress = By.xpath("//div//input[@id='email']");
    By btn_newAccount = By.xpath("//button[@id='SubmitCreate']/span");
    By btn_Gender = By.xpath("//input[@id='id_gender2']");
    By txt_firstName = By.id("customer_firstname");
    By txt_lastName = By.id("customer_lastname");
    By txt_Password = By.id("passwd");
    By txt_Address = By.id("address1");
    By txt_City = By.id("city");
    By txt_State = By.id("id_state");
    By txt_zipCode = By.id("postcode");
    By txt_Country = By.id("id_country");
    By txt_Mobile = By.id("phone_mobile");
    By txt_addressAlias = By.id("alias");
    By btn_Register = By.xpath("//button[@id='submitAccount']/span");
    By txt_Msg = By.xpath("//p[text()='Welcome to your account. Here you can manage all of your personal information and orders.']");
    By btn_signOut = By.xpath("//a[@class='logout']");
    By btn_signIn = By.xpath("//button[@id='SubmitLogin']/span");

    public AccountPage(WebDriver driver) {

        super(driver);
    }

    //create New Account
    public void createNewAccount(String email, String firstname, String lastname,
                                 String password, String address, String city, String state, String code, String mobile,
                                 String alias) {
        sendText(txt_Email, email);
        clickOnButton(btn_newAccount);
        clickOnButton(btn_Gender);
        sendText(txt_firstName, firstname);
        sendText(txt_lastName, lastname);
        sendText(txt_Password, password);
        sendText(txt_Address, address);
        sendText(txt_City, city);
        //selectByVisibaleText(txt_State,"Alabama");
        selectByVisibaleText(txt_State, state);
        sendText(txt_zipCode, code);
        //selectByVisibaleText(txt_Country,"United States");
        sendText(txt_Mobile, mobile);
        clearText(txt_addressAlias);
        sendText(txt_addressAlias, alias);
        clickOnButton(btn_Register);
    }

    public boolean isMsgDisplay() {

        return isDisplay(txt_Msg);
    }

    // log out from page
    public void logout() {

        clickOnButton(btn_signOut);
    }

    // Login With New User
    public void login(String email, String password) {
        sendText(txt_emailAddress, email);
        sendText(txt_Password, password);
        clickOnButton(btn_signIn);
    }

}
