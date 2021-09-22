package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;
    FeedbackPage feedbackPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks visibility of search field")
    public void checkSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User checks visibility of search button")
    public void checkSearchButtonVisibility() {
        homePage.isSearchButtonVisible();
    }

    @When("User type {string} in search field")
    public void enterKeywordInSearchField(final String keyword) {
        homePage.enterTextInSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks that all products in search results page contain {string}")
    public void checkAllProductsInSearchResultsPageContainKeyword(final String keyword) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getProductCards().get(60));
        assertTrue(searchResultsPage.getProductCards().stream().allMatch(u -> u.getText().toLowerCase().contains(keyword)));

    }

    @And("User checks that URL contains {string}")
    public void checkThatURLContainsSearchWord(String keyword) {
        assertTrue(searchResultsPage.getCurrentUrl().contains(keyword));
    }

    @And("User checks cart icon visibility")
    public void checkCartIconVisibility() {
        homePage.isCartIconVisible();
    }

    @And("User clicks on first product")
    public void choseFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickOnFirstProduct();
    }


    @And("User clicks Add to Cart button in product page")
    public void clickAddToCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());
        productPage.clickAddToCartButton();
    }

    @Then("User checks that amount of products in cart are {string}")
    public void checksAmountOfProductsInCart(final String expectedAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCounterInCart());
        assertEquals(homePage.getAmountOfProductInCart(), expectedAmount);
    }

    @And("User clicks on the cart icon")
    public void clicksOnTheCartIcon() {
        homePage.clickCartIcon();
    }

    @And("User clicks remove from cart button")
    public void clickRemoveFromCartButton() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getRemoveFromCartButton());
        cartPage.clickRemoveFromCartButton();
    }

    @And("User clicks on text: Sign in")
    public void clickSignIn() {
        homePage.clickSignIn();
    }

    @Then("User checks visibility of captcha")
    public void checkCaptchaVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCaptcha());
        assertTrue(homePage.isCaptchaVisible());
    }

    @And("User clicks on text register in header")
    public void clickRegister() {
        homePage.clickRegisterButton();
    }


    @And("User clicks on Yes or No radiobutton in second point")
    public void clickRadiobuttonInSecondPoint() {
        feedbackPage = pageFactoryManager.getFeedbackPage();
        feedbackPage.clickYesRadioButton();
    }

    @When("User clicks on Send button")
    public void clickSendButton() {
        feedbackPage.clickSend();
    }

    @Then("Warning about necessary pointing of value level should be displayed")
    public void isWarningPointValueVisible() {
        assertTrue(feedbackPage.isWarningValueLevelVisible());
    }

    @And("User clicks on value level in first point")
    public void clickValueLevelInFirstPoint() {
        feedbackPage = pageFactoryManager.getFeedbackPage();
        feedbackPage.clickValueRadioButton();
    }

    @Then("Warning about necessary pointing Yes or No in second point should be displayed")
    public void isWarningInSecondPointVisible() {
        assertTrue(feedbackPage.isWarningSecondPointVisible());
    }

    @And("User clicks on textbox")
    public void clickOnTextbox() {
        feedbackPage = pageFactoryManager.getFeedbackPage();
        feedbackPage.clickOnTextbox();
    }

    @And("User enter {string} text")
    public void enterTextFeedback(final String text) {
        feedbackPage.enterText(text);
    }

    @And("User checks visibility of header")
    public void checksHeaderVisibility() {
        homePage.isHeaderVisible();
    }

    @And("User checks visibility of footer")
    public void checksFooterVisibility() {
        homePage.isFooterVisible();
    }

    @When("User clicks catalog of category")
    public void clickCatalogOfCategory() {
        homePage.clickCatalogButton();
    }

    @Then("User checks visibility of catalog")
    public void checkCatalogVisibility() {
        assertTrue(homePage.isCatalogOfCategoryVisible());
    }

    @After
    public void tearDown() {
        driver.close();
    }


}
