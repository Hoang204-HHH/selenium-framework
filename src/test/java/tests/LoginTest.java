package tests;

import framework.config.ConfigReader;
import framework.pages.InventoryPage;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"}, description = "Valid login should open inventory page")
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = loginPage.login(
                ConfigReader.getInstance().getUsername(),
                ConfigReader.getInstance().getPassword()
        );
        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page should be loaded");
    }

    @Test(groups = {"regression"}, description = "Locked user should see error message")
    public void testLockedUserLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginExpectingFailure(
                "locked_out_user",
                ConfigReader.getInstance().getPassword()
        );
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed");
    }
}