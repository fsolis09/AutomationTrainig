/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author fsolis-as
 */
public class ProfilePage extends BasePage{
    
    @FindBy(id="ctl00_Main_CurrentAdsButton")
    WebElement currentAdsLinkBtn;
    
    @FindBy(id="ctl00_Main_InactiveAdsButton")
    WebElement inactiveLinkBtn;
    
    @FindBy(id="ctl00_Main_SavedAdsButton")
    WebElement savedBooksLinkBtn;
    
    @FindBy(id="ctl00_Main_ActivationAdsButton")
    WebElement adsWaitingLinkBtn;
    
    @FindBy(id="ctl00_Main_ProfileLink")
    WebElement mainProfileLinkBtn;
    
    List<WebElement>categoriesProfile;
    
    @FindBy(id="ctl00_TopMenuRepeater_ctl02_MenuLink")
    WebElement profileTabOption;
    
    
    public ProfilePage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver, this);   
    }  
    
    public boolean verifyProfilePageLoad(){
        return(
                waitForElementEnabled(currentAdsLinkBtn)&&
                waitForElementEnabled(inactiveLinkBtn)&&
                waitForElementEnabled(savedBooksLinkBtn)&&
                waitForElementEnabled(adsWaitingLinkBtn)&&
                waitForElementEnabled(mainProfileLinkBtn)
                );
    }
    
    public void clickOnProfileTab(){
        clickOnElement(profileTabOption);
    }
    
     public boolean verifyTabTittle(String expectedTittle){
       String currentTittle = getTittleFromTab();
       return(currentTittle.equals(expectedTittle));
    } 
}
