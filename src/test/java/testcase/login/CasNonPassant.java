package testcase.login;

import factory.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.cura.BurgerMenu;
import pages.cura.LoginPage;
import pages.cura.MakeAppointmentPage;
import utils.Verify;
import utils.VerifyInDriver;

public class CasNonPassant extends BaseTest {

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
    public void burgerMenuButtons ()  {
        loginPage.navigateToPage();
        //verification des éléments du burger menu
        burgerMenu.verifyElementsifLogout();
        burgerMenu.getHomeBurgerButton().click();
    }

    @Test (dataProvider = "not-passing-login")
    public void withoutFieldsRequiredTest(String username, String password) {
        loginPage.navigateToPage();
        loginPage.fillForm(
                null,
                "ThisIsNotAPassword"
        );
        loginPage.submitForm();
        verify.elementIsPresent(loginPage.loginRequiredMessageXpath);
        verify.elementIsNotPresent(MakeAppointmentPage.makeAppointmentTitleXpath);
    }

    @DataProvider(name = "not-passing-login")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {null, "ThisIsNotAPassword"}
                , {"John Doe", null}
                , {"Blabla", "Blublu"}
                , {null, null}};
    }
}



