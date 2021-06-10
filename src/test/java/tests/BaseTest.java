package tests;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.MyDiarySteps;
import steps.RateYourHappinessModalSteps;
import utils.ScreenshotTestListener;

import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({ScreenshotTestListener.class})
public class BaseTest {

    RateYourHappinessModalSteps rateYourHappinessModalSteps;
    MyDiarySteps myDiarySteps;

    /**
     * Sets up.
     * This method performed before the test method
     *
     * @param context the context
     */
    @BeforeMethod
    public void setUp(ITestContext context) {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 15_000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        initSteps();
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver());
    }

    /**
     * Close browser.
     * This method performed after test method
     */
    @AfterMethod
    public void closeBrowser() {
        getWebDriver().quit();
    }

    /**
     * Init steps.
     */
    public void initSteps() {
        rateYourHappinessModalSteps = new RateYourHappinessModalSteps();
        myDiarySteps = new MyDiarySteps();
    }
}