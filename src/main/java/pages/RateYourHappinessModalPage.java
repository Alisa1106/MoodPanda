package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.Waiters;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModalPage extends Waiters {

    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String UPDATE_MOOD_TO_BUTTON_CSS = ".ButtonUpdate";
    public static final String CHOOSE_DAY_CSS = ".%s.btn-xs";
    public static final String HOURS_DROPDOWN_CSS = "#ddlHistoricHour";
    public static final String SELECT_TIME_CSS = "select option[value ='%s']";
    public static final String MINUTES_DROPDOWN_CSS = "#ddlHistoricMinute";

    /**
     * Update mood rate your happiness modal page.
     *
     * @param moodValue the mood value
     * @return the rate your happiness modal page
     */
    @Step("Update mood to {moodValue}")
    public RateYourHappinessModalPage updateMood(int moodValue) {
        waitForElementLocated(By.cssSelector(SLIDER_CSS), 10);
        $(SLIDER_CSS).click();
        int defaultMoodValue = 5;
        Keys direction = null;
        if (moodValue > defaultMoodValue) {
            direction = Keys.ARROW_RIGHT;
        } else if (moodValue < defaultMoodValue) {
            direction = Keys.ARROW_LEFT;
        }
        if (moodValue != defaultMoodValue) {
            for (int i = 0; i < Math.abs(moodValue - defaultMoodValue); i++) {
                $(SLIDER_CSS).sendKeys(direction);
            }
        }
        return this;
    }

    /**
     * Choose day rate your happiness modal page.
     *
     * @param day the day
     * @return the rate your happiness modal page
     */
    @Step("Choose day: {day}")
    public RateYourHappinessModalPage chooseDay(String day) {
        $(String.format(CHOOSE_DAY_CSS, day)).click();
        return this;
    }

    /**
     * Choose time rate your happiness modal page.
     *
     * @param hours   the hours
     * @param minutes the minutes
     * @return the rate your happiness modal page
     */
    @Step("Choose time: {hours} {minutes}")
    public RateYourHappinessModalPage chooseTime(String hours, String minutes) {
        $(HOURS_DROPDOWN_CSS).click();
        $(String.format(SELECT_TIME_CSS, hours)).click();
        $(MINUTES_DROPDOWN_CSS).click();
        $(String.format(SELECT_TIME_CSS, minutes)).click();
        return this;
    }

    /**
     * Click on update mood to button mood updated modal page.
     *
     * @return the mood updated modal page
     */
    @Step("Click Update mood to button")
    public MoodUpdatedModalPage clickOnUpdateMoodToButton() {
        $(UPDATE_MOOD_TO_BUTTON_CSS).click();
        return new MoodUpdatedModalPage();
    }
}