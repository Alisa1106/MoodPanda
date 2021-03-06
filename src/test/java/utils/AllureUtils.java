package utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.Objects;

class AllureUtils {
    /**
     * Take screenshot byte [ ].
     *
     * @return the byte [ ]
     * @throws IOException the io exception
     */
    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] takeScreenshot() throws IOException {
        return FileUtils.readFileToByteArray(Objects.requireNonNull(Screenshots.takeScreenShotAsFile()));
    }
}