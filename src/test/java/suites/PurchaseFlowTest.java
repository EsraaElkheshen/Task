package suites;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.ProductPage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PurchaseFlowTest extends TestBase {
    HomePage homePage;
    AccountPage accountPage;
    ProductPage productPage;

    @BeforeClass
    public void beforeClass() {
        homePage = new HomePage(driver);
        testDataReader.selectDataSet("Register");
        
    }

    @Test(priority = 1)
    public void verifiyValidLogin() {
        homePage.signIn();
        accountPage = new AccountPage(driver);
        accountPage.login(testDataReader.getDataCollector().get("email"),
                testDataReader.getDataCollector().get("password"));
    }

    @Test(priority = 2, dependsOnMethods = {"verifiyValidLogin"})
    public void verifyPurchaseFlow() {
        productPage = new ProductPage(driver);
        productPage.selectWomanSubCategory(testDataReader.getDataCollector().get("productName"));
        productPage.addToCart();
        productPage.confirmOrder();
        productPage.backToOrder();
        Assert.assertTrue(productPage.getResultText("Bank wire"));


    }
}
