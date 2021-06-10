package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Waiters;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends Waiters {

    public static final String UPDATE_MOOD_BUTTON_CSS = "#LinkUpdate";

    /**
     * Click on update mood button rate your happiness modal page.
     *
     * @return the rate your happiness modal page
     */
    @Step("Click update mood button")
    public RateYourHappinessModalPage clickOnUpdateMoodButton() {
        waitForElementLocated(By.cssSelector(UPDATE_MOOD_BUTTON_CSS), 10);
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new RateYourHappinessModalPage();
    }
}