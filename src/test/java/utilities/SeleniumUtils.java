package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SeleniumUtils {

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ignored) {
        }
    }

    public static void clear(WebElement element){
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
    }

}