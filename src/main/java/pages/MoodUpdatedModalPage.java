package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Waiters;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdatedModalPage extends Waiters {

    public static final String GO_TO_MY_DIARY_BUTTON_CSS = ".ButtonMyDiary";

    /**
     * Click go to my diary button my diary page.
     *
     * @return the my diary page
     */
    @Step("Click Go to my diary button")
    public MyDiaryPage clickGoToMyDiaryButton() {
        waitForElementLocated(By.cssSelector(GO_TO_MY_DIARY_BUTTON_CSS), 10);
        $(GO_TO_MY_DIARY_BUTTON_CSS).click();
        return new MyDiaryPage();
    }
}