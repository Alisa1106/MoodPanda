package pages;

import constants.IUrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Waiters;

import static com.codeborne.selenide.Selenide.*;

public class MyDiaryPage extends Waiters implements IUrlConstants {

    public static final String MOOD_STATUS_CSS = ".badge.pull-right";
    public static final String MOOD_UPDATE_DATE_CSS = ".col-xs-8";
    public static final String SEND_HUG_BUTTON_CSS = ".btnd-sm";
    public static final String HUG_CSS = "#media-comment0";
    public static final String CONTENT_CONTAINER_CSS = ".row-offcanvas";

    /**
     * Open page my diary page.
     *
     * @return the my diary page
     */
    @Step("Open my diary page")
    public MyDiaryPage openPage() {
        open(MOOD_PANDA_MY_DIARY_PAGE_URL);
        waitForElementLocated(By.cssSelector(CONTENT_CONTAINER_CSS), 10);
        return this;
    }

    /**
     * Gets mood state text.
     *
     * @param label the label
     * @return the mood state text
     */
    public String getMoodStateText(String label) {
        waitForElementLocated(By.cssSelector(CONTENT_CONTAINER_CSS), 10);
        return $$(label).get(0).getText();
    }

    /**
     * Gets mood status text.
     *
     * @return the mood status text
     */
    public String getMoodStatusText() {
        return getMoodStateText(MOOD_STATUS_CSS);
    }

    /**
     * Gets mood date text.
     *
     * @return the mood date text
     */
    public String getMoodDateText() {
        return getMoodStateText(MOOD_UPDATE_DATE_CSS);
    }

    /**
     * Click send hug button my diary page.
     *
     * @return the my diary page
     */
    @Step("Click Send hug button")
    public MyDiaryPage clickSendHugButton() {
        $$(SEND_HUG_BUTTON_CSS).get(0).click();
        return this;
    }

    /**
     * Gets hug text.
     *
     * @return the hug text
     */
    @Step("Get hug author name")
    public String getHugText() {
        return $(HUG_CSS).getText();
    }
}