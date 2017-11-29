/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProfilePage;
import pages.NavigationPage;
import pages.LoginPage;

/**
 *
 * @author fsolis-as
 */
public class ProfileTest extends BaseTest{
    
    ProfilePage profilePage;
    NavigationPage navigationPage;
    LoginPage loginPage;
    
    @BeforeMethod
     public void initProfilePage(){
        navigationPage = new NavigationPage(basePage.getDriver());
        profilePage = navigationPage.ClickInProfileTab();
    }
     
    @Test
    public void verifyIfProfilePageLoadedCorrectly(){
        loginPage = navigationPage.ClickInLogin();
        loginPage.login("fsolisch09","fsolisch09*");
        profilePage.clickOnProfileTab();
        assertTrue(profilePage.verifyProfilePageLoad());
        navigationPage.getTittleFromTab();
        assertTrue(profilePage.verifyTabTittle("My Ads"));
        loginPage.logout();
    }
    
    @Test
    public void verifyThatProfilePageIsDisplayedWhenTheUserIsNotLoged(){
        navigationPage.getTittleFromTab();
        assertTrue(profilePage.verifyTabTittle("Login"));
    }
    
}
