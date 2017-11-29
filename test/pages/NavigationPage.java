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
public class NavigationPage extends BasePage{
    
    @FindBy (id="ctl00_LoginView_LoginLink")
    WebElement loginLink;
    
    @FindBy (id="ctl00_LoginView_RegisterLink")
    WebElement registerLink;
    
    @FindBy (id="ctl00_BrowseAllLink")
    WebElement browseCategories;
    
    @FindBy (id="ctl00_TopMenuRepeater_ctl00_MenuLink")
    WebElement homeTab;
    
    @FindBy (id="ctl00_TopMenuRepeater_ctl01_MenuLink")
    WebElement postAnAdTab;
    
    @FindBy (id="ctl00_TopMenuRepeater_ctl02_MenuLink")
    WebElement myAdsProfileTab;
    
    @FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton")
    WebElement antiquesColleciblesLabelCategory;
    
    @FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_TopCategoryButton")
    WebElement artCraftslabelCategory;
    
    @FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton")
    WebElement autoCategorylabel;
    
    @FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl03_TopCategoryButton")
    WebElement electronicCategoryLabel;
    
    @FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl04_TopCategoryButton")
    WebElement gardenCategoryLabel;
    
    @FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl05_TopCategoryButton")
    WebElement homeCategoryLabel;
    
    @FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl06_TopCategoryButton")
    WebElement musicCategoryLabel;

    
     public NavigationPage (WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver, this);
    }
        
    public LoginPage ClickInLogin(){
        clickOnElement(loginLink); 
        return new LoginPage(driver);
    }
    
    public RegisterPage ClickInRegister(){
        clickOnElement(registerLink); 
        return new RegisterPage(driver);
    }
    
    public BrowseCategoriesPage ClickInCategories(){
        clickOnElement(browseCategories); 
        return new BrowseCategoriesPage(driver);
    }
    
    public HomePage ClickInHometab(){
        clickOnElement(homeTab);
        return new HomePage(driver);
    }
    
    public PostPage ClickInPostTab(){
        clickOnElement(postAnAdTab);
        return new PostPage(driver);
    }
    
    public ProfilePage ClickInProfileTab(){
        clickOnElement(myAdsProfileTab);
        return new ProfilePage(driver);
    }
    
    public void clickOnAntiquesCollectCategory(){
        clickOnElement(antiquesColleciblesLabelCategory);
    }
    
    public void clickOnArtCraftCategory(){
       clickOnElement(artCraftslabelCategory);
    }
    
    public void clickOnAutoCategory(){
       clickOnElement(autoCategorylabel);
    }
}
