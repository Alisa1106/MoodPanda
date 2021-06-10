package steps;

import io.qameta.allure.Step;
import pages.FeedPage;
import pages.LoginPage;
import pages.MyDiaryPage;

public class MyDiarySteps {

    private final MyDiaryPage myDiaryPage;
    private final LoginPage loginPage;
    private final FeedPage feedPage;

    public MyDiarySteps() {
        myDiaryPage = new MyDiaryPage();
        loginPage = new LoginPage();
        feedPage = new FeedPage();
    }

    /**
     * Gets mood status.
     *
     * @return the mood status
     */
    @Step("Get latest mood status text")
    public String getMoodStatus() {
        return myDiaryPage.getMoodStatusText();
    }

    /**
     * Gets mood date.
     *
     * @return the mood date
     */
    @Step("Get mood date text")
    public String getMoodDate() {
        return myDiaryPage.getMoodDateText();
    }

    /**
     * Send and get hug text string.
     *
     * @param login    the login
     * @param password the password
     * @return the string
     */
    @Step("Login and send hug then get hug`s message text")
    public String sendAndGetHugText(String login, String password) {
        loginPage
                .openPage()
                .login(login, password);
        myDiaryPage
                .openPage()
                .clickSendHugButton();
        return myDiaryPage.getHugText();
    }
}