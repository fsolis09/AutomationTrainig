/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 *
 * @author fsolis-as
 */
public class PostPage extends BasePage{
    
    @FindBy(id="ctl00_Main_PostAdWizard_SubcategoriesList_ctl00_CategoryButton")
    WebElement antiquesCollectPostLabelCategory;
    
    @FindBy(id="ctl00_Main_PostAdWizard_SubcategoriesList_ctl01_CategoryButton")
    WebElement artCraftLabelCategory;
            
    @FindBy(id="ctl00_Main_PostAdWizard_SubcategoriesList_ctl02_CategoryButton")
    WebElement autoLabelCategory;
    
    @FindBy(id="ctl00_Main_PostAdWizard_SubcategoriesList_ctl03_CategoryButton")
    WebElement electroniclabelCategory;
    
    @FindBy(id="ctl00_Main_PostAdWizard_SubcategoriesList_ctl04_CategoryButton")
    WebElement gardenLabelCategory;
    
    @FindBy(id="ctl00_Main_PostAdWizard_SubcategoriesList_ctl05_CategoryButton")
    WebElement homeLabelCategory;
    
    @FindBy(id="ctl00_Main_PostAdWizard_SubcategoriesList_ctl06_CategoryButton")
    WebElement musicLabelCategory;
    
    List<WebElement> postCategories;
    
    @FindBy(id="ctl00_TopMenuRepeater_ctl01_MenuLink")
    WebElement postTabOption;
    
    
    public PostPage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver, this);   
    }  
 
    public boolean verifyLoadsPostPage(){
        return(
                waitForElementEnabled(antiquesCollectPostLabelCategory)&&
                waitForElementEnabled(artCraftLabelCategory)&&
                waitForElementEnabled(autoLabelCategory)&&
                waitForElementEnabled(electroniclabelCategory)&&
                waitForElementEnabled(gardenLabelCategory)&&
                waitForElementEnabled(homeLabelCategory)&&
                waitForElementEnabled(musicLabelCategory)
                );
    }
    
    public void clickPostAndAdTab(){
        clickOnElement(postTabOption);
    }
    
    public boolean verifyTabTittle(String expectedTittle){
       String currentTittle = getTittleFromTab();
       return(currentTittle.equals(expectedTittle));
    } 
}

