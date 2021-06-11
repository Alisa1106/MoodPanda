package utils;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public abstract class Waiters {

    /**
     * Wait for element located.
     *
     * @param element the element
     * @param timeout the timeout
     */
    public void waitForElementLocated(By element, int timeout) {
        $(element).shouldBe(Condition.visible, Duration.ofSeconds(timeout));
    }
}