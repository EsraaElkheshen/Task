package suites;

import Pages.AccountPage;
import Pages.HomePage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistartionTest extends TestBase {
    HomePage homePage;
    AccountPage accountPage;

    @BeforeClass
    public void beforeClass() {
        homePage = new HomePage(driver);

    }

    @Test(priority = 1)
    public void verifyValidRegisterUser() {
        homePage.signIn();
        accountPage = new AccountPage(driver);
        testDataReader.selectDataSet("Register");
        accountPage.createNewAccount(testDataReader.getDataCollector().get("email"),
                testDataReader.getDataCollector().get("firstname"),
                testDataReader.getDataCollector().get("lastname"),
                testDataReader.getDataCollector().get("password"),
                testDataReader.getDataCollector().get("address"),
                testDataReader.getDataCollector().get("city"),
                testDataReader.getDataCollector().get("state"),
                testDataReader.getDataCollector().get("code"),
                testDataReader.getDataCollector().get("mobile"),
                testDataReader.getDataCollector().get("alias"));
        Assert.assertTrue(accountPage.isMsgDisplay());
    }


//    @Test(priority = 1)
//    public void verifyValidRegisterUser() {
//        Home_Page.signIn();
//        NewAccount_Page.createNewAccount("Esraa440@gmail.com", "Esraa", "esraa", "12345678", "3str", "test",
//                "Alabama", "12345", "01090119064", "eses");
//        Assert.assertTrue(NewAccount_Page.isMsgDisplay());
//    }


}
