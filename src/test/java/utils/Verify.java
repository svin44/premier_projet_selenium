package utils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Verify {

    public static void elementText(WebElement element, String expectedText){
        Assert.assertEquals(element.getText(), expectedText);
    }
}
