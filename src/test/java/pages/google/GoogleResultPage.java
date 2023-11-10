package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultPage {
    private WebDriver driver;

    public GoogleResultPage (WebDriver driver) { this.driver = driver; }

    private WebElement getFirstLink(){ return driver.findElement(By.xpath("(//h3)[1]")); }

    public void clickOnFirstLink(){
        getFirstLink().click();
    }
}
