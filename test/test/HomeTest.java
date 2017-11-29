/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.apache.commons.exec.ExecuteException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.HomePage;

/**
 *
 * @author fsolis-as
 */
public class HomeTest extends BaseTest{
    
    HomePage homePage;
    
    public void initPage(){
    homePage = new HomePage(basePage.getDriver());        
    }
    
    @Test
    public void VerifyIfHomeIsDisplayedCorrectly() throws Exception { 
       initPage(); 
       assertTrue(homePage.verifyLoads()); 
    }
    
    @Test
    public void VerifyHomePageLoadedFromHomeTabClick ()throws ExecuteException {
       initPage(); 
       String currentTittle = homePage.getTittleFromTab();
       assertEquals(currentTittle, "Welcome"); 
    }
    
    
}
