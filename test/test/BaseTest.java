/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import automation.ConfigTag;
import pages.BasePage;
import org.testng.annotations.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author fsolis-as
 */
public class BaseTest {
    
    protected URL nodeUrl;
    protected BasePage basePage;
    protected ThreadLocal<RemoteWebDriver> remoteDriver = null;
    protected WebDriver localDriver = null;
    
      
      
    @BeforeTest
    @Parameters(value={"baseUrl"})
    public void printStartingExecution(String baseUrl) throws MalformedURLException {
        System.out.println("Starting Testing Execution");
        nodeUrl=new URL ("http://localhost:4444/wd/hub");
        ConfigTag.appURL=baseUrl;
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println("Executing Class: "+this.getClass().getName());    
    }
    
    @BeforeMethod
    @Parameters(value={"mode","browser","platform"})
    public void setUpDriver(String mode, String browser,String plataform) throws MalformedURLException{
        
        if (mode.equalsIgnoreCase("Remote")){
           System.out.println("Creating remote Driver");
           remoteDriver = new ThreadLocal<>();
           remoteDriver.set (createRemoteDriver(browser, plataform));
        }
        else {
            System.out.println("Creating local Driver");
            localDriver = createLocalDriver(browser, plataform);
        }
        
        basePage = new BasePage(getdriver(mode));
        basePage.goToPage("/default.aspx");
    }
    
    @Parameters(value={"browser","platform"})
    public RemoteWebDriver createRemoteDriver(String browser,String plataform) throws MalformedURLException{
        RemoteWebDriver driver;
        DesiredCapabilities capabilities;
      
        switch (browser){
            
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setPlatform(Platform.WINDOWS);
                driver = new RemoteWebDriver(nodeUrl, capabilities);
                break;
                
            default: //Default Chrome
                capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(Platform.WINDOWS);
                driver = new RemoteWebDriver(nodeUrl, capabilities);
                break;
        }
       return driver;
    }
    
    @Parameters(value={"browser","platform"})
    public WebDriver createLocalDriver (String browser,String plataform) throws MalformedURLException{
        WebDriver driver; 
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver","C:\\Selenium\\drivers\\firefox\\geckodriver.exe");
                driver = new FirefoxDriver();
                //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
                 
            default://Chrome default
                System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chrome\\chromedriver.exe");
                driver = new ChromeDriver();
                //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);     
                break;
        }
        return driver;
    }
    
    public WebDriver getdriver(String mode){
        if (mode.equals("Remote")){
            return remoteDriver.get();
        }else{
            return localDriver;
        }
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("Deleting Driver");
        basePage.closeDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
         System.out.println("Completing execution class: "+this.getClass().getName());
    }
    
    @AfterTest
    public void afterTest() {
        System.out.println("Completing Test Execution");
    }
    
}
