package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private WebDriver driver;
    public GoogleSearchPage (WebDriver driver) { this.driver = driver; }
    public static String url = "https://www.google.fr/";

    private WebElement getSearchBox(){ return driver.findElement(By.name("q")); }
    private WebElement getAcceptCookies(){ return driver.findElement(By.xpath("//*[text()='Tout accepter']")); }

    public void search(String research){
        driver.navigate().to(url);
        getAcceptCookies().click();
        getSearchBox().sendKeys(research);
        getSearchBox().submit();
    }
}
