/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static org.apache.regexp.RETest.test;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PostPage;
import pages.NavigationPage;
import pages.LoginPage;

/**
 *
 * @author fsolis-as
 */
public class PostTest extends BaseTest{
    
    PostPage postPage;
    LoginPage loginPage;
    NavigationPage navigationPage;
    
    @BeforeMethod
    public void initPostPage(){
        navigationPage = new NavigationPage(basePage.getDriver());
        postPage = navigationPage.ClickInPostTab();
    }
    
      
    @Test
    public void verifyIfPostAndAdPageLoadedCorrectly(){
        loginPage = navigationPage.ClickInLogin();
        loginPage.login("fsolisch09","fsolisch09*");
        postPage.clickPostAndAdTab();
        assertTrue(postPage.verifyLoadsPostPage());
        navigationPage.getTittleFromTab();
        assertTrue(postPage.verifyTabTittle("Post an Ad"));
        loginPage.logout();
    }
    
    @Test
    public void verifyThatLoginPageIsDisplayedWhenTheUserIsNotLoged(){
        navigationPage.getTittleFromTab();
        assertTrue(postPage.verifyTabTittle("Login"));
    }
     
    
}
