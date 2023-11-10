package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    protected void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--start-fullscreen");
        //driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterMethod
    protected void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
