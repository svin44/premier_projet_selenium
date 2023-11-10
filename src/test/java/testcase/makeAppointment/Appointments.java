package testcase.makeAppointment;

import factory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.cura.AppointmentConfirmationPage;
import pages.cura.BurgerMenu;
import pages.cura.LoginPage;
import pages.cura.MakeAppointmentPage;
import utils.Dates;
import utils.Verify;
import utils.VerifyInDriver;

public class Appointments extends BaseTest {
    private LoginPage loginPage;
    private MakeAppointmentPage makeAppointmentPage;
    private AppointmentConfirmationPage appointmentConfirmationPage;
    private VerifyInDriver verify;
    private Verify verifyText;
    private BurgerMenu burgerMenu;

    @BeforeMethod
    private void injectDriver() {
        loginPage = new LoginPage(driver);
        makeAppointmentPage = new MakeAppointmentPage(driver);
        appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        verify = new VerifyInDriver(driver);
        burgerMenu = new BurgerMenu(driver);
    }

    //test de la prise de rdv avec verification du burger menu sur la page de prise de rdv et de confirmation de rdv
    @Test
    public void burgerMenuButtons() throws InterruptedException{
        loginPage.log("John Doe", "ThisIsNotAPassword");
        //remplir le formulaire
        makeAppointmentPage.fillAppointmentForm(
                "No",
                "Hongkong CURA Healthcare Center",
                "Medicaid",
                Dates.getToday(),
                "ceci est un test");
        //verifier le burger menu sur la page de la prise de rdv
        burgerMenu.verifyElementsifLoged();

        //soumettre le formulaire
        makeAppointmentPage.submitAppointmentForm();

        //verification des éléments du burger menu sur la page de confirmation du rdv
        burgerMenu.verifyElementsifLoged();

        //se déconnecter à la fin du test et verifier la déconnexion sur la page du login
        burgerMenu.getLogoutBurgerButton().click();
        burgerMenu.getButtonBurgerMenu().click();
        burgerMenu.getLoginBurgerButton().click();
    }

    //test de l'ensemble des cas de figure de prise de rdv
    @Test(dataProvider = "all-cases-appointment")
    public void appointmentTest(String apply, String facility, String program,String date, String comment) throws InterruptedException {
        loginPage.log("John Doe", "ThisIsNotAPassword");
        makeAppointmentPage.fillAppointmentForm(
                apply,
                facility,
                program,
                date,
                comment);
        makeAppointmentPage.submitAppointmentForm();

        Verify.elementText(appointmentConfirmationPage.getAppointmentApplyConfirmation(), apply);
        Verify.elementText(appointmentConfirmationPage.getAppointmentFacilityConfirmation(), facility);
        Verify.elementText(appointmentConfirmationPage.getAppointmentProgramConfirmation(), program);
        Verify.elementText(appointmentConfirmationPage.getAppointmentDateConfirmation(),  date);
        Verify.elementText(appointmentConfirmationPage.getAppointmentCommentConfirmation(), comment);
    }

    @DataProvider(name = "all-cases-appointment")
    public Object[][] dataProviderAppointment() {
        return new Object[][]{
                {"No", "Hongkong CURA Healthcare Center", "Medicaid", Dates.getToday(), "ceci est un test"}
                , {"Yes", "Hongkong CURA Healthcare Center", "Medicaid", Dates.getToday(), "ceci est un test"}
                , {"No", "Hongkong CURA Healthcare Center", "Medicaid", Dates.getToday(), ""}
                , {"Yes", "Hongkong CURA Healthcare Center", "Medicaid", Dates.getToday(), ""}
                , {"No", "Tokyo CURA Healthcare Center", "Medicaid", Dates.getToday(), "ceci est un test"}
                , {"Yes", "Tokyo CURA Healthcare Center", "Medicaid", Dates.getToday(), "ceci est un test"}
                , {"No", "Tokyo CURA Healthcare Center", "Medicaid", Dates.getToday(), ""}
                , {"Yes", "Tokyo CURA Healthcare Center", "Medicaid", Dates.getToday(), ""}
                , {"No", "Seoul CURA Healthcare Center", "Medicaid", Dates.getToday(), "ceci est un test"}
                , {"Yes", "Seoul CURA Healthcare Center", "Medicaid", Dates.getToday(), "ceci est un test"}
                , {"No", "Seoul CURA Healthcare Center", "Medicaid", Dates.getToday(), ""}
                , {"Yes", "Seoul CURA Healthcare Center", "Medicaid", Dates.getToday(), ""}
                , {"No", "Hongkong CURA Healthcare Center", "Medicare", Dates.getToday(), "ceci est un test"}
                , {"Yes", "Hongkong CURA Healthcare Center", "Medicare", Dates.getToday(), "ceci est un test"}
                , {"No", "Hongkong CURA Healthcare Center", "Medicare", Dates.getToday(), ""}
                , {"Yes", "Hongkong CURA Healthcare Center", "Medicare", Dates.getToday(), ""}
                , {"No", "Tokyo CURA Healthcare Center", "Medicare", Dates.getToday(), "ceci est un test"}
                , {"Yes", "Tokyo CURA Healthcare Center", "Medicare", Dates.getToday(), "ceci est un test"}
                , {"No", "Tokyo CURA Healthcare Center", "Medicare", Dates.getToday(), ""}
                , {"Yes", "Tokyo CURA Healthcare Center", "Medicare", Dates.getToday(), ""}
                , {"No", "Seoul CURA Healthcare Center", "Medicare", Dates.getToday(), "ceci est un test"}
                , {"Yes", "Seoul CURA Healthcare Center", "Medicare", Dates.getToday(), "ceci est un test"}
                , {"No", "Seoul CURA Healthcare Center", "Medicare", Dates.getToday(), ""}
                , {"Yes", "Seoul CURA Healthcare Center", "Medicare", Dates.getToday(), ""}
                , {"No", "Hongkong CURA Healthcare Center", "None", Dates.getToday(), "ceci est un test"}
                , {"Yes", "Hongkong CURA Healthcare Center", "None", Dates.getToday(), "ceci est un test"}
                , {"No", "Hongkong CURA Healthcare Center", "None", Dates.getToday(), ""}
                , {"Yes", "Hongkong CURA Healthcare Center", "None", Dates.getToday(), ""}
                , {"No", "Tokyo CURA Healthcare Center", "None", Dates.getToday(), "ceci est un test"}
                , {"Yes", "Tokyo CURA Healthcare Center", "None", Dates.getToday(), "ceci est un test"}
                , {"No", "Tokyo CURA Healthcare Center", "None", Dates.getToday(), ""}
                , {"Yes", "Tokyo CURA Healthcare Center", "None", Dates.getToday(), ""}
                , {"No", "Seoul CURA Healthcare Center", "None", Dates.getToday(), "ceci est un test"}
                , {"Yes", "Seoul CURA Healthcare Center", "None", Dates.getToday(), "ceci est un test"}
                , {"No", "Seoul CURA Healthcare Center", "None", Dates.getToday(), ""}
                , {"Yes", "Seoul CURA Healthcare Center", "None", Dates.getToday(), ""}};
    }
}

