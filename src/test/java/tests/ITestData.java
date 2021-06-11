package tests;

import org.testng.annotations.DataProvider;

public interface ITestData {

    String LOGIN = "alicemodpanda@mailinator.com";
    String PASSWORD = "123456";

    @DataProvider(name = "Time data")
    static Object[][] inputForCalculator() {
        return new Object[][]{
                {"Reset3day", "12", ":00", "3 days ago"},
                {"Reset2day", "13", ":15", "2 days ago"},
                {"ResetYesterday", "07", ":30", "1 day ago"},
        };
    }
}