package pages;

import constants.IUrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Waiters;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends Waiters implements IUrlConstants {

    public static final String EMAIL_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    public static final String PASSWORD_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    public static final String LOGIN_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonLogin";

    /**
     * Open page login page.
     *
     * @return the login page
     */
    @Step("Open login page")
    public LoginPage openPage() {
        open(MOOD_PANDA_LOGIN_URL);
        return this;
    }

    /**
     * Login feed page.
     *
     * @param email    the email
     * @param password the password
     * @return the feed page
     */
    @Step("Fill in {email} and {password} in login fields and click Login button")
    public FeedPage login(String email, String password) {
        waitForElementLocated(By.cssSelector(EMAIL_INPUT_CSS), 10);
        $(EMAIL_INPUT_CSS).sendKeys(email);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return new FeedPage();
    }
}