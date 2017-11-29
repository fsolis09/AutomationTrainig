/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

/**
 *
 * @author fsolis-as
 */
public class LoginPage extends BasePage {
    
    @FindBy (id="ctl00_Main_LoginConrol_UserName")
    WebElement userNameTextBox;
    
    @FindBy (id="ctl00_Main_LoginConrol_Password")
    WebElement passworTextBox;
    
    @FindBy (id="ctl00_Main_LoginConrol_LoginButton")
    WebElement loginButton;
    
    @FindBy (xpath="//table[@id='ctl00_Main_LoginConrol']//table//tr[4]/td") 
    WebElement failedLoginMessage;
    
    @FindBy (id="ctl00_LoginView_MemberName")
    WebElement userNameDisplayed;
    
    @FindBy (id="ctl00_LoginView_MemberLoginStatus")
    WebElement logoutLabel;        
    
    public LoginPage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver, this);   
    }

     public boolean verifyLoadsLogin() {
         
        return(
            waitForElementEnabled(userNameTextBox)&&
            waitForElementEnabled(passworTextBox)
        );
    }
     
    public boolean verifyTabTittle(String expectedTittle){
       String currentTittle = getTittleFromTab();
       return(currentTittle.equals(expectedTittle));
    } 
    
    public boolean verifyFailedMessage(String expectedMessage){
         String currentMessage = getTextFromElement(failedLoginMessage);
         return(currentMessage.equals(expectedMessage));
    }   
    
    public void login(String userName, String password){
        typeOnElement(userNameTextBox, userName);
        typeOnElement(passworTextBox, password);
        clickOnElement(loginButton);
    }
    
    public boolean verifyUserName(String expectedUserName){
        String currentUser = getTextFromElement(userNameDisplayed);
        return(currentUser.equals(expectedUserName));
    }
    
    public void logout(){
        clickOnElement(logoutLabel);
    }
    
}
