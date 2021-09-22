package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(@href,'cart.')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//i[@id='gh-cart-n']")
    private WebElement counterInCart;

    @FindBy(xpath = "//li/span/a[contains(text(),'Sign')]")
    private WebElement signIn;

    @FindBy(xpath = "//h1[contains(text(),'Please verify')]")
    private WebElement captcha;

    @FindBy(xpath = "//a[contains(text(),'register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//button[@class='gh-control']")
    private WebElement catalogButton;

    @FindBy(xpath = "//div[@id='gh-sbc-o']")
    private WebElement catalogOfCategory;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void isSearchButtonVisible() {
        searchButton.isDisplayed();
    }

    public void enterTextInSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void isCartIconVisible() {
        cartIcon.isDisplayed();
    }

    public WebElement getCounterInCart() {
        return counterInCart;
    }

    public String getAmountOfProductInCart() {
        return counterInCart.getText();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickSignIn() {
        signIn.click();
    }

    public WebElement getCaptcha() {
        return captcha;
    }

    public boolean isCaptchaVisible() {
        return captcha.isDisplayed();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }
    public void clickCatalogButton() {
        catalogButton.click();
    }

    public boolean isCatalogOfCategoryVisible() {
        return catalogOfCategory.isDisplayed();
    }
}

