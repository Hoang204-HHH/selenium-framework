package tests;

import framework.pages.CartPage;
import framework.pages.InventoryPage;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(groups = {"regression"}, description = "Add first item to cart")
    public void testAddFirstItemToCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addFirstItemToCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 1, "Cart badge should show 1 item");
    }

    @Test(groups = {"regression"}, description = "Open cart after adding first item")
    public void testGoToCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addFirstItemToCart();
        CartPage cartPage = inventoryPage.goToCart();
        Assert.assertEquals(cartPage.getItemCount(), 1, "Cart should contain 1 item");
    }
}
