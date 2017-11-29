package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.NavigationPage;

/**
 *
 * @author fsolis-as
 */
public class RegisterTest extends BaseTest {
    
    
    RegisterPage registerPage;
    NavigationPage navigationPage;
    
    @BeforeMethod
     public void initRegisterPage(){
        navigationPage = new NavigationPage(basePage.getDriver());
        registerPage = navigationPage.ClickInRegister();
    }
    
    @Test
    public void verifyThatRegisterPageIsDisplayedWhenClickingOnRegisterLink() throws Exception {   
        navigationPage.ClickInRegister();
        assertTrue(registerPage.verifyFieldsLoad());
        navigationPage.getTittleFromTab();
        assertTrue(registerPage.verifyTabTittle("Register"));
    }
  
    @Test
    public void verifyThatAllTheMandatoryMessagesAreDisplayedWhenAllMandatoryFieldsAreEmptyAfterClickSubmitButton() throws Exception {
        navigationPage.ClickInRegister();
        registerPage.clickSubmitButton();
        assertTrue(registerPage.verifyRequiredFieldsLabels());      
    }
    
  
    @Test
    public void verifyThatErrorMessageIsDisplayedWhenCreatingUserWithUserNameThatIsAlreadyTaken() throws Exception {
        navigationPage.ClickInRegister();
        registerPage.registerUser("Fernando","Solis","fernandosolis09@gmail.com","fsolisch09","fsolisch09*","fsolisch09*","first 3 letters of alphabet?","abc");
        registerPage.clickSubmitButton();
        assertTrue(registerPage.verifyExitingUser("User name already exists. Please enter a different user name."));
    }

  
  @Test
  public void verifyThatErrorMessageIsDisplayedWhenSendingDifferentPasswordsOnPasswordAndConfirmPasswordFields() throws Exception {
       navigationPage.ClickInRegister();
       registerPage.registerUser("Gerardo", "Solis", "nfsch09@gmail.com", "nfsch", "nfsch$456", "nfsch$987", "last 3 letters of alphabet?", "xyz");
       registerPage.clickSubmitButton();
       assertTrue(registerPage.verifyMatchPassword("The password and confirmation password must match."));
    }
  
    @Test
    public void verifyThatErrorMessageIsDisplayedWhenSendingInvalidEmailOnEmailField() throws Exception {  
       navigationPage.ClickInRegister();
       registerPage.registerUser("Gefnano","solis","nfsch09@hotmail","nfsch09","gef$123456","gef$123456","Big Animal On the Earth?","Whale");
       registerPage.clickSubmitButton();
       assertTrue(registerPage.verifyEmailFormat("A valid email is required."));
    }
    
}
