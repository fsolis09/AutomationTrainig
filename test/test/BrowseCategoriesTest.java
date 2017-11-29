/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.testng.annotations.Test;
import pages.NavigationPage;
import pages.BrowseCategoriesPage;
import pages.LoginPage;

/**
 *
 * @author fsolis-as
 */
public class BrowseCategoriesTest extends BaseTest {
    
    BrowseCategoriesPage categoriesPage;
    NavigationPage navigationPage;
    LoginPage loginPage;
    
    
    
     public void initCategoryBrowsePage(){
        navigationPage = new NavigationPage(basePage.getDriver());
        categoriesPage = navigationPage.ClickInCategories();
    }
     
     
    @Test
    public void verifyThatSearchFieldIsDisplayedWhenClickedOnAntiquesCollect(){
        initCategoryBrowsePage();
        navigationPage.clickOnAntiquesCollectCategory();
        categoriesPage.verifySearchFieldsLoad();
    }
    
    @Test
    public void verifyThatSearchFieldIsDisplayedWhenClickedOnArtCraftCategory(){
        initCategoryBrowsePage();
        navigationPage.clickOnArtCraftCategory();
        categoriesPage.verifySearchFieldsLoad();
    }
    
    @Test
    public void verifyThatSearchFieldIsDisplayedWhenClickedOnAutoCategory(){
        initCategoryBrowsePage();
        navigationPage.clickOnArtCraftCategory();
        categoriesPage.verifySearchFieldsLoad();
    }
}
