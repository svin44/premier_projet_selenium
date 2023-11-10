package pages.cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    /**
     * Driver used to find Element
     */
    private WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    /**
     * URL of the page
     */
    public static String url = "https://katalon-demo-cura.herokuapp.com/profile.php#login";

    /**
     * Methods on the page
     */
    public void navigateToPage(){
        driver.navigate().to(url);
    }

    public void fillForm(String username, String password){
        if (username != null) getUsernameField().sendKeys(username);
        if (password != null) getPasswordField().sendKeys(password);
    }

    public void submitForm(){getLoginButton().click();
    }

    public void log(String username, String password){
        driver.navigate().to(url);
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }

    /**
     * Locators : used for getting element and verifying their presence
     *     pour trouver un Xpath relatif
     *     //*[@id=""]
     *     //*[text()=""]
     */
    public By usernameXpath = By.id("txt-username");
    public By passwordXpath = By.id("txt-password");
    public By loginButtonXpath = By.id("btn-login");
    public By loginRequiredMessageXpath = By.xpath("//p[contains(text(), 'Login failed! Please ensure the username and password are valid.')]");

    /**
     * Getters for elements of the page
     */
    private WebElement getUsernameField(){ return driver.findElement(By.id("txt-username")); }
    private WebElement getPasswordField(){ return driver.findElement(By.id("txt-password")); }
    private WebElement getLoginButton(){ return driver.findElement(By.id("btn-login")); }
    public WebElement getFieldRequiredError(){ return driver.findElement(loginRequiredMessageXpath); }

}
