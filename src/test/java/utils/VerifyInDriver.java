package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class VerifyInDriver {

    private WebDriver driver;
    private WebDriverWait longWait;
    private WebDriverWait shortWait;

    public VerifyInDriver(WebDriver driver) {
        this.driver = driver;
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public void elementIsPresent(By locator){
        try {
            longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (TimeoutException e){
            Assert.fail("Element was not found");
        }
    }

    public void elementIsNotPresent(By locator){
        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Assert.fail("Element was found but shouldn't be visible");
        }catch (TimeoutException ignored){}
    }
}
