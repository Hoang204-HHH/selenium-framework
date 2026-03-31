package framework.pages;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;

    @FindBy(css = ".cart_item .inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(css = ".cart_button")
    private List<WebElement> removeButtons;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getItemCount() {
        return cartItems == null ? 0 : cartItems.size();
    }

    public CartPage removeFirstItem() {
        if (removeButtons != null && !removeButtons.isEmpty()) {
            waitAndClick(removeButtons.get(0));
        }
        return this;
    }

    public List<String> getItemNames() {
        return itemNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
