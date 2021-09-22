package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedbackPage extends BasePage{

    @FindBy(xpath = "(//div[@class='field']//input[@type='radio'])[1]")
    private WebElement yesRadioButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='rating-selector']//div[contains(@class,'text-danger')]")
    private WebElement warningValuePoint;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    private WebElement valueRadioButton;

    @FindBy(xpath = "//div[@id='q1']//div[contains(@class,'text-danger')]")
    private WebElement warningYesOrNoPoint;

    @FindBy(xpath = "//textarea[contains(@class,'textbox')]")
    private WebElement textbox;

    public FeedbackPage(WebDriver driver) {
        super(driver);
    }

    public void clickYesRadioButton() {
        yesRadioButton.click();
    }

    public void clickSend() {
        sendButton.click();
    }

    public boolean isWarningValueLevelVisible() {
        return warningValuePoint.isDisplayed();
    }

    public void clickValueRadioButton() {
        valueRadioButton.click();
    }

    public boolean isWarningSecondPointVisible() {
        return warningYesOrNoPoint.isDisplayed();
    }

    public void clickOnTextbox() {
        textbox.click();
    }

    public void enterText(final String text) {
        textbox.sendKeys(text);
    }
}
