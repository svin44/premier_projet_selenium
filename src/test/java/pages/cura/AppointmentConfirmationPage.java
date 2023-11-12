package pages.cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppointmentConfirmationPage {

    /**
     * Driver used to find Element
     */
    private WebDriver driver;
    public AppointmentConfirmationPage(WebDriver driver) { this.driver = driver; }

    /**
     * URL of the page
     */
    public static String url = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";

    /**
     * Methods on the page */

    /**
     * Locators : used for getting element and verifying their presence
     */
    public static By appointmentConfirmationMessageXpath = By.id("//h2[contains(text(), 'Appointment')]");
    public static By appointmentFacilityConfirmationXpath = By.id("facility");
    public static By appointmentApplyConfirmationXpath = By.id("hospital_readmission");
    public static By appointmentProgramConfirmationXpath = By.id("program");
    public static By appointmentDateConfirmationXpath = By.id("visit_date");
    public static By appointmentCommentConfirmationXpath = By.id("comment");

    /**
     * Getters for elements of the page
     */
    public WebElement getAppointmentConfirmationMessage(){ return driver.findElement(appointmentConfirmationMessageXpath); }
    public WebElement getAppointmentFacilityConfirmation(){ return driver.findElement(appointmentFacilityConfirmationXpath); }
    public WebElement getAppointmentApplyConfirmation(){ return driver.findElement(appointmentApplyConfirmationXpath); }
    public WebElement getAppointmentProgramConfirmation(){ return driver.findElement(appointmentProgramConfirmationXpath); }
    public WebElement getAppointmentDateConfirmation(){ return driver.findElement(appointmentDateConfirmationXpath); }
    public WebElement getAppointmentCommentConfirmation(){ return driver.findElement(appointmentCommentConfirmationXpath); }

}
