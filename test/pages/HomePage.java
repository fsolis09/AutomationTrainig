/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;


import java.util.List;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author fsolis-as
 */
public class HomePage extends BasePage{
    
    @FindBy(xpath=".//*[@id='col_main_right']/h3")
    WebElement browseCategoryTittle;
    
    @FindBy (id="ctl00_LoginView_LoginLink")
    WebElement loginLink;
    
    @FindBy (id="ctl00_LoginView_RegisterLink")
    WebElement registerLink;
    
    @FindBys({
        @FindBy(xpath="//table[@id='ctl00_Main_CategoryBrowser_TopCategoryList']//a[contains(@id,'ctl00_Main_CategoryBrowser_TopCategoryList')]")
    })
    List<WebElement> categories;
    
    @FindBy(id="ctl00_LoginView_MemberName")
    WebElement usrName;
    
    public HomePage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver, this);
    }
    
    
    public boolean verifyLoads() {
        return(
            waitForElementEnabled(loginLink)&&
            waitForElementEnabled(browseCategoryTittle)&&
            waitForElementEnabled(registerLink)
        );
    }
    
   
    
    @Parameters(value={"user"})
    public boolean verifyUsr(String user) { 
    return(
        waitForElementVisible(usrName)&&
        getTextFromElement(usrName).equals(user)
    );

    }
    
    public boolean verifyLoadsCategories(){
        boolean contentResult=true;
        for (int index=1;index<=categories.size();index++){
            contentResult = contentResult && waitForElementEnabled(categories.get(index));
        }
        return contentResult;
    }   
    
       
}
