package test;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import pages.HomePage;
import pages.LoginPage;
import pages.NavigationPage;


public class LoginTest extends BaseTest {
    
    LoginPage loginPage;
    NavigationPage navigationPage;
    
    public void initLoginPage(){
        navigationPage = new NavigationPage(basePage.getDriver());
        loginPage = navigationPage.ClickInLogin();
    }


   @Test
    public void testVerifyThatLoginPageIsDisplayedWhenUserClickLoginLink() throws Exception {
        initLoginPage();
        navigationPage.getTittleFromTab();
        assertTrue(loginPage.verifyTabTittle("Login")); 
    }

    @Test
    public void testVerifyThatUserIsNotAbleToLoginWithInvalidCredentials() throws Exception {
        initLoginPage();
        navigationPage.ClickInLogin();
        loginPage.login("fsolisch09","fsolisch09");
        assertTrue(loginPage.verifyFailedMessage("Your login attempt was not successful. Please try again."));
    }

   @Test
    public void testVerifyThatUserIsAbleToLoginWithValidCredentials() throws Exception {
       initLoginPage();
       navigationPage.ClickInLogin();
       loginPage.login("fsolisch09","fsolisch09*");
       assertTrue(loginPage.verifyUserName("fsolisch09"));
       loginPage.logout();
    }
}
