package testcase.login;

import factory.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.cura.BurgerMenu;
import pages.cura.LoginPage;
import pages.cura.MakeAppointmentPage;
import utils.VerifyInDriver;

public class CasPassant extends BaseTest {

    private LoginPage loginPage;
    private VerifyInDriver verify;
    private BurgerMenu burgerMenu;

    @BeforeMethod
    private void injectDriver() {
        loginPage = new LoginPage(driver);
        verify = new VerifyInDriver(driver);
        burgerMenu = new BurgerMenu(driver);
    }

    @Test
    // test de connexion , vérification des éléments du burger menu, et déconnexion
    public void validLogin() throws InterruptedException {
        loginPage.navigateToPage();

        loginPage.fillForm(
                "John Doe",
                "ThisIsNotAPassword"
        );
        loginPage.submitForm();
        verify.elementIsPresent(MakeAppointmentPage.makeAppointmentTitleXpath);
        verify.elementIsNotPresent(loginPage.loginRequiredMessageXpath);

        //verification des éléments du burger menu
        burgerMenu.verifyElementsifLoged();

        //se déconnecter à la fin du test et verifier la déconnexion sur la page du login
        burgerMenu.getLogoutBurgerButton().click();
        burgerMenu.getButtonBurgerMenu().click();
        burgerMenu.getLoginBurgerButton().click();
    }
}

