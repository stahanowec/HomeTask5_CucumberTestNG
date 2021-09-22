package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='s-item__info clearfix']//h3[@class='s-item__title']")
    private List<WebElement> productCards;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getProductCards() {
        return productCards;
    }

    public void clickOnFirstProduct() {
        productCards.get(0).click();
    }

}
