package pages.cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Dates;

public class MakeAppointmentPage {

    /**
     * Driver used to find Element
     */
    private WebDriver driver;
    public MakeAppointmentPage(WebDriver driver) { this.driver = driver; }

    /**
     * Methods on the page
     */

    public void fillAppointmentForm(String apply,String facility,String program,String date, String comment) throws InterruptedException {

        Select selectFacility = new Select(driver.findElement(By.id("combo_facility")));

        if (apply.equals("Yes")){
            getApplyButton().click();
        };
        if (facility != null){
            selectFacility.selectByVisibleText(facility);
        };
        if (program.equals("Medicaid")){
            getMedicaidButton().click();
        };
        if (program.equals("Medicare")) {
            getMedicareButton().click();
        };
        if (program.equals("None")){
            getNoneButton().click();
        };
        if (date != null) getDate().sendKeys(date);
        if (comment != null) getComment().sendKeys(comment);
        Thread.sleep(5000);
    }

    public void submitAppointmentForm(){getbookAppointmentButton().click();}

    /**
     * Locators : used for getting element and verifying their presence
     */

    public static By makeAppointmentTitleXpath = By.xpath("//h2[contains(text(), 'Make Appointment')]");
    public static By facilitySelectXpath = By.id("combo_facility");
    public static By optionTokyo = By.xpath("//*[@id=\"combo_facility\"]/option[1]");
    public static By optionHongKong = By.xpath("//*[@id=\"combo_facility\"]/option[2]");
    public static By optionSeoul = By.xpath("//*[@id=\"combo_facility\"]/option[3]");
    public static By applyButtonXpath = By.id("chk_hospotal_readmission");
    public static By medicareButtonXpath = By.id("radio_program_medicare");
    public static By medicaidButtonXpath = By.id("radio_program_medicaid");
    public static By noneButtonXpath = By.id("radio_program_none");
    public static By dateXpath = By.id("txt_visit_date");
    public static By commentXpath = By.id("txt_comment");
    public static By bookAppointmentButtonXpath = By.id("btn-book-appointment");

    /**
     * Getters for elements of the page
     */
    public WebElement getfacilitySelection(){ return driver.findElement(By.id("combo_facility"));}
    public WebElement getOptionTokyo(){ return driver.findElement(By.xpath("//*[@id=\"combo_facility\"]/option[1]"));}
    public WebElement getOptionHongkong(){ return driver.findElement(By.xpath("//*[@id=\"combo_facility\"]/option[2]"));}
    public WebElement getOptionSeoul(){ return driver.findElement(By.xpath("//*[@id=\"combo_facility\"]/option[3]"));}
    public  WebElement getApplyButton(){return  driver.findElement(By.id("chk_hospotal_readmission"));}
    public  WebElement getMedicareButton(){return  driver.findElement(By.id("radio_program_medicare"));}
    public  WebElement getMedicaidButton(){return  driver.findElement(By.id("radio_program_medicaid"));}
    public  WebElement getNoneButton(){return  driver.findElement(By.id("radio_program_none"));}
    public  WebElement getDate(){return  driver.findElement(By.id("txt_visit_date"));}
    public WebElement getComment(){return  driver.findElement(By.id("txt_comment"));}
    public WebElement getbookAppointmentButton(){ return driver.findElement(By.id("btn-book-appointment")); }


}
