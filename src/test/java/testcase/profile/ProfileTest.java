package testcase.profile;

import factory.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.cura.*;
import utils.Dates;
import utils.Verify;
import utils.VerifyInDriver;

public class ProfileTest extends BaseTest {

    private LoginPage loginPage;
    private VerifyInDriver verify;
    private Verify verifyText;
    private BurgerMenu burgerMenu;
    private Profile profile;

    @BeforeMethod
    private void injectDriver() {
        loginPage = new LoginPage(driver);
        verify = new VerifyInDriver(driver);
        burgerMenu = new BurgerMenu(driver);
        profile = new Profile(driver);
    }

    @Test
    public void burgerMenuButtonsAndLogout() {
        loginPage.log("John Doe", "ThisIsNotAPassword");

        //aller sur la page de profile
        burgerMenu.getButtonBurgerMenu().click();
        burgerMenu.getProfileBurgerButton().click();

        //verifier le burger menu sur la page profile
        burgerMenu.verifyElementsifLoged();

        //test de la déconnexion et vérification sur la page login
        profile.getLogoutButton().click();
        burgerMenu.getButtonBurgerMenu().click();
        burgerMenu.getLoginBurgerButton().click();
    }
}
