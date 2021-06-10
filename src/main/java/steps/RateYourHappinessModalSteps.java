package steps;

import io.qameta.allure.Step;
import pages.*;

public class RateYourHappinessModalSteps {

    private final LoginPage loginPage;
    private final FeedPage feedPage;
    private final RateYourHappinessModalPage rateYourHappinessModalPage;
    private final MoodUpdatedModalPage moodUpdatedModalPage;
    private final MyDiaryPage myDiaryPage;

    public RateYourHappinessModalSteps() {
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
        moodUpdatedModalPage = new MoodUpdatedModalPage();
        myDiaryPage = new MyDiaryPage();
    }

    /**
     * Update mood rate your happiness modal steps.
     *
     * @param email     the email
     * @param password  the password
     * @param moodValue the mood value
     * @return the rate your happiness modal steps
     */
    @Step("Login and update mood")
    public RateYourHappinessModalSteps updateMood(String email, String password, int moodValue) {
        loginPage
                .openPage()
                .login(email, password)
                .clickOnUpdateMoodButton()
                .updateMood(moodValue);
        return this;
    }

    /**
     * Choose mood time rate your happiness modal steps.
     *
     * @param email    the email
     * @param password the password
     * @param day      the day
     * @param hours    the hours
     * @param minutes  the minutes
     * @return the rate your happiness modal steps
     */
    @Step("Login and choose day and time")
    public RateYourHappinessModalSteps chooseMoodTime(String email, String password, String day, String hours, String minutes) {
        loginPage
                .openPage()
                .login(email, password)
                .clickOnUpdateMoodButton()
                .chooseDay(day)
                .chooseTime(hours, minutes);
        return this;
    }

    /**
     * Click update mood button and go to my diary my diary page.
     *
     * @return the my diary page
     */
    @Step("Click Update mood button and go to my diary page")
    public MyDiaryPage clickUpdateMoodButtonAndGoToMyDiary() {
        rateYourHappinessModalPage
                .clickOnUpdateMoodToButton()
                .clickGoToMyDiaryButton();
        return new MyDiaryPage();
    }
}