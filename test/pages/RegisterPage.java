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

/**
 *
 * @author fsolis-as
 */
public class RegisterPage extends BasePage {
    
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstNameRequired")
  WebElement firstNameRequiredLabel;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastNameRequired")
  WebElement lastNameRequiredLabel;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_EmailRequired")
  WebElement emailRequiredLabel;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserNameRequired")
  WebElement userNameRequiredLabel;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordRequired")
  WebElement passwordRequiredLabel;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPasswordRequired")
  WebElement confirmPasswordRequiredLabel;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_QuestionRequired")
  WebElement questionRequiredLabel;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_AnswerRequired")
  WebElement answerRequiredLabel;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")
  WebElement firtsNameField;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")
  WebElement lastNameField;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")
  WebElement emailField;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")
  WebElement userNameField;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")
  WebElement passwordField;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")
  WebElement confirmPasswordField;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")
  WebElement securityQuestionField;
  
  @FindBy (id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")
  WebElement answerQuestionField;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton")
  WebElement submitButton;
  
  @FindBy(id="ctl00_Main_InfoLabel")
  WebElement infoLabelExistingUser;
  
  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordCompare")
  WebElement infoPasswordCompare;

  @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_EmailRequiredFormat")
  WebElement infoWrongEmailFormat;
  
    public RegisterPage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver, this);   
    }

    public boolean verifyFieldsLoad(){
        return(
            waitForElementEnabled(firtsNameField)&&
            waitForElementEnabled(lastNameField)&&
            waitForElementEnabled(emailField)&&
            waitForElementEnabled(userNameField)&&
            waitForElementEnabled(passwordField)&&
            waitForElementEnabled(confirmPasswordField)&&
            waitForElementEnabled(securityQuestionField)&&
            waitForElementEnabled(answerQuestionField)
        );  
    }
    
    public boolean verifyRequiredFieldsLabels(){
        return(
                waitForElementEnabled(firstNameRequiredLabel)&&
                waitForElementEnabled(lastNameRequiredLabel)&&
                waitForElementEnabled(emailRequiredLabel)&&
                waitForElementEnabled(userNameRequiredLabel)&&
                waitForElementEnabled(passwordRequiredLabel)&&
                waitForElementEnabled(confirmPasswordRequiredLabel)&&
                waitForElementEnabled(questionRequiredLabel)&&
                waitForElementEnabled(answerRequiredLabel)
                );
    }
    public boolean verifyTabTittle(String expectedTittle){
       String currentTittle = getTittleFromTab();
       return(currentTittle.equals(expectedTittle));
    } 
    
    public void clickSubmitButton(){
        clickOnElement(submitButton);
    }
    
    public void registerUser(String usrFirstName, String userLastName,String usrMail, String usrName, String usrPassWord, String usrConfirmPass, String usrQuestion, String usrAnswer){
        typeOnElement(firtsNameField, usrFirstName);
        typeOnElement(lastNameField, userLastName);
        typeOnElement(emailField, usrMail);
        typeOnElement(userNameField, usrName);
        typeOnElement(passwordField, usrPassWord);
        typeOnElement(confirmPasswordField, usrConfirmPass);
        typeOnElement(securityQuestionField, usrQuestion);
        typeOnElement(answerQuestionField, usrAnswer);
        clickOnElement(submitButton);
    }
    
    public boolean verifyExitingUser(String expectedMessage){
        String currentMessage = getTextFromElement(infoLabelExistingUser);
        return(currentMessage.equals(expectedMessage));
    }
    
    public boolean verifyMatchPassword(String expectedMessage){
        String currentMessage = getTextFromElement(infoPasswordCompare);
        return (currentMessage.equals(expectedMessage));
    }
    
     public boolean verifyEmailFormat(String expectedMessage){
        String currentMessage = getTextFromElement(infoWrongEmailFormat);
        return (currentMessage.equals(expectedMessage));
    }
    
}
