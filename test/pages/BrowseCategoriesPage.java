/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author fsolis-as
 */
public class BrowseCategoriesPage extends BasePage {
    
    @FindBy(id="ctl00_Main_SearchTermTextBox")
    WebElement searchFieldCategory; 
    
    @FindBy(id="ctl00_Main_CategoryDropDown_CategoryList")
    WebElement categoriesDropDownList;
    
    @FindBy(id="ctl00_Main_SearchButton")
    WebElement searchButton;
    
   
    public BrowseCategoriesPage(WebDriver otherDriver) {
    super(otherDriver);
    PageFactory.initElements(driver, this);   
    }  
        
        
        
    public boolean verifySearchFieldsLoad(){
        return(
            waitForElementEnabled(searchFieldCategory)&&
            waitForElementEnabled(categoriesDropDownList)&&
            waitForElementEnabled(searchButton)
            );
    }       
}
