package pages.cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.VerifyInDriver;

public class Profile {

    private WebDriver driver;
    public Profile(WebDriver driver) {
        this.driver = driver;
    }
    public static String url = "https://katalon-demo-cura.herokuapp.com/profile.php#profile";
    private VerifyInDriver verify;

    /**
     * Methods on the page
     * */

    /**
     * Locators : used for getting element and verifying their presence
     *     pour trouver un Xpath relatif
     *     //*[@id=""]
     *     //*[text()=""]
     */
    public By logoutButtonXpath = By.xpath("//a[@class='btn btn-default']");

    //Getters
    public WebElement getLogoutButton() { return driver.findElement(By.xpath("//a[@class='btn btn-default']"));}

}
