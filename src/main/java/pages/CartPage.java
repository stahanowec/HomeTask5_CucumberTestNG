package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement removeFromCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickRemoveFromCartButton() {
        removeFromCartButton.click();
    }

    public WebElement getRemoveFromCartButton() {
        return removeFromCartButton;
    }
}
