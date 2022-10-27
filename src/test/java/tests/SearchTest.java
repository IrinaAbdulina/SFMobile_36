package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest extends CoreTestCase {

    @Test
    public void testSearch() {
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement searchInit = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/fragment_feed_header",
                "Error1"
        );

        searchInit.click();

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Error2"
        );

        searchInput.sendKeys("Java");

        WebElement expectedResult = mainPO.waitForElementPresent(
                "xpath://*[./*[contains(@text, 'Island of Indonesia, Southeast Asia')]]",
                "Error3"
        );

        expectedResult.click();

    }
}
