package pages.cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.VerifyInDriver;

public class BurgerMenu {

    private WebDriver driver;

    public BurgerMenu(WebDriver driver) {
        this.driver = driver;
    }

    public static String url = "https://katalon-demo-cura.herokuapp.com/";

    private VerifyInDriver verify;

    /**
     * Methods on the page
     */

    public void navigateToPage() {
        driver.navigate().to(url);
    }

    public void verifyElementsifLoged() {
        verify = new VerifyInDriver(driver);
        getButtonBurgerMenu().click();
        verify.elementIsPresent(homeBurgerMenuXpath);
        verify.elementIsPresent(historyBurgerMenuXpath);
        verify.elementIsPresent(profileBurgerMenuXpath);
        verify.elementIsPresent(logoutBurgerMenuXpath);
    }

    public void verifyElementsifLogout(){
        verify = new VerifyInDriver(driver);
        getButtonBurgerMenu().click();
        verify.elementIsPresent(homeBurgerMenuXpath);
        verify.elementIsPresent(loginBurgerMenuXpath);
    }

    /**
     * Locators : used for getting element and verifying their presence
     *     pour trouver un Xpath relatif
     *     //*[@id=""]
     *     //*[text()=""]
     */
    public By buttonBurgerMenuXpath = By.xpath("//i[@class='fa fa-bars']");
    public By homeBurgerMenuXpath = By.xpath("//a[normalize-space()='Home']");
    public By loginBurgerMenuXpath = By.xpath("//a[normalize-space()='Login']");
    public By logoutBurgerMenuXpath = By.xpath("//a[normalize-space()='Logout']");

    public By historyBurgerMenuXpath = By.xpath("//a[normalize-space()='History']");
    public By profileBurgerMenuXpath = By.xpath("//a[normalize-space()='Profile']");


    //Getters
    public WebElement getButtonBurgerMenu() { return driver.findElement(buttonBurgerMenuXpath);}
    public WebElement getHomeBurgerButton() {return driver.findElement(homeBurgerMenuXpath);}
    public WebElement getLoginBurgerButton() {return driver.findElement(loginBurgerMenuXpath);}
    public WebElement getLogoutBurgerButton() {return driver.findElement(logoutBurgerMenuXpath);}
    public WebElement getHistoryBurgerButton() {return driver.findElement(historyBurgerMenuXpath);}
    public WebElement getProfileBurgerButton() {return driver.findElement(profileBurgerMenuXpath);}
}
