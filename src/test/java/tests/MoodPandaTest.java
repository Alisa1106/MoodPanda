package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest implements ITestData {

    public static final int MOOD_VALUE = 9;
    public static final String YOUR_HUG = "\uD83D\uDC3CHugs - You";

    /**
     * Update mood test.
     * This method verify that mood is update
     *
     */
    @Test(description = "Verify that mood is update")
    public void updateMoodTest() {
        rateYourHappinessModalSteps.updateMood(LOGIN, PASSWORD, MOOD_VALUE)
                .clickUpdateMoodButtonAndGoToMyDiary();
        Assert.assertEquals(myDiarySteps.getMoodStatus(), (String.valueOf(MOOD_VALUE)));
    }

    /**
     * Update mood with time test.
     * This method verify that the mood is update by date and time
     *
     * @param day     the day
     * @param hours   the hours
     * @param minutes the minutes
     * @param result  the result
     */
    @Test(description = "Verify that the mood is update by date and time", dataProvider = "Time data", dataProviderClass = ITestData.class)
    public void updateMoodWithTimeTest(String day, String hours, String minutes, String result) {
        rateYourHappinessModalSteps
                .chooseMoodTime(LOGIN, PASSWORD, day, hours, minutes)
                .clickUpdateMoodButtonAndGoToMyDiary();
        Assert.assertEquals(myDiarySteps.getMoodDate(), result);
    }

    /**
     * Hugs test.
     * This method verify that hug is send
     */
    @Test(description = "Verify that hug is send")
    public void hugsTest() {
        Assert.assertEquals(myDiarySteps.sendAndGetHugText(LOGIN, PASSWORD), YOUR_HUG);
    }
}