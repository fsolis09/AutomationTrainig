/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;
import automation.ConfigTag;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author fsolis-as
 */
public class BasePage {
    
protected WebDriver driver; 
private String baseUrl ;

     
public BasePage(WebDriver otherDriver) {
driver = otherDriver;
baseUrl=ConfigTag.appURL;
}  
        
public boolean waitForElementVisible(WebElement element)
{
    try {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    } catch (Exception e) {
        return false;
    }
}

public boolean goToPage (String path){
 try {
        driver.get(baseUrl + path );
        return true;
    } catch (Exception e) {
        return false;
    }

}

public boolean typeOnElement(WebElement element, String text)
{
    try {
        element.clear();
        element.sendKeys(text);
        return true;
    }catch (Exception e) {
        return false;
    }
}

public String getTextFromElement(WebElement element){

    try {
        return element.getText();
    } catch (Exception e) {
        return null;
    }
}

public boolean clickOnElement(WebElement element){
    try {
        element.click();
        return true;
    } catch (Exception e) {
        return false;
    }
}

public boolean waitForElementNotVisible(WebElement element){
    try {
         WebDriverWait wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.invisibilityOf(element));
         return true;
    } catch (Exception e) {
        return false;
    }
}
 
protected boolean waitForElementEnabled(WebElement element){
    try {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return true;
    } catch (Exception e) {
        return false;
    }
}
 public WebElement findElement (By search){
     try {
        return driver.findElement(search);
    } catch (Exception e) {
        return null;
    }
 }
 
 public String getTittleFromTab (){
     try {
         return driver.getTitle();
     } catch (Exception e) {
         return "";
     }
 }
 
 public void closeDriver(){
     driver.quit();
 }
 
 public WebDriver getDriver(){
    return driver;
 }
}

