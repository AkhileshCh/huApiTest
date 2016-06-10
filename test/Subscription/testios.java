/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subscription;

import io.appium.java_client.TouchAction;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.python.modules.thread.thread;
import org.testng.annotations.*;

/**
 *
 * @author akhileshChauhan This test case will do the basic login test ( one
 * with the valid user and one with the invalid user ) and make user User Logout
 * basically a simple login and logout
 */
public class testios {

//WebDriver driver;
    IOSDriver driver;

    public static void main(String[] args) throws MalformedURLException, Exception {
        testios test = new testios();
        test.setUp();
        test.ValidLoginAndLogout();
    }

    public void setUp() throws MalformedURLException, InterruptedException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // capabilities.setCapability("platformVersion", "9.2.1 (13D15)"); 
        // capabilities.setCapability("deviceName", "iPhone 6");
        //  capabilities.setCapability("platformName","iOS");
        //  capabilities.setCapability("app", "/Users/cdp/Desktop/HUM.ipa");

//Create RemoteWebDriver instance and connect to the Appium server
        //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    public void invalidLogin() throws Exception {
        for (int i = 0; i < 10; i++) {
            WebElement signbymail = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
            signbymail.click();
            WebElement email = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]"));
            email.sendKeys("Aksh@gmail.com");
            WebElement password = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]"));
            password.sendKeys("test1234");
            WebElement signin = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
            signin.click();
            Thread.sleep(3000);
            Alert OKAlert = driver.switchTo().alert();
            String Alertmessge = OKAlert.getText();
            System.out.println(Alertmessge);
            OKAlert.accept();
            WebElement close = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
            close.click();
        }

    }

    public void ValidLoginAndLogout() throws Exception {
        String Xapth_Accnt = "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]";
        boolean IslogedIN = isElementPresent(Xapth_Accnt);
        if (IslogedIN == true) {
            WebElement myaccount = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]"));
            myaccount.click();
            WebElement editaccount = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
            editaccount.click();
            WebElement Logoutbtn = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
            Logoutbtn.click();
            //Alert OKAlert = driver.switchTo().alert();
            WebElement logouttxt = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
            String Logouttxt = logouttxt.getText();
            System.out.println(Logouttxt);
            WebElement logout = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]"));
            logout.click();
        } 
            for (int i = 0; i < 10; i++) {
                WebElement signbymail = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
                signbymail.click();
                WebElement email = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]"));
                email.sendKeys("roger1@test.com");
                WebElement password = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]"));
                password.sendKeys("password");
                WebElement signin = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
                signin.click();
                Thread.sleep(7000);
                WebElement feed = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]"));
                feed.click();
                Thread.sleep(10000);
                // TouchAction act = new TouchAction(driver);
                //act.press(100,550).moveTo(500,100).release().perform();
                Dimension dimensions = driver.manage().window().getSize();
                Double screenHeightStart = dimensions.getHeight() * 0.5;
                int scrollStart = screenHeightStart.intValue();
                System.out.println("s=" + scrollStart);
                Double screenHeightEnd = dimensions.getHeight() * 0.2;
                int scrollEnd = screenHeightEnd.intValue();
                System.out.println(scrollEnd);
                for (int j = 0; j < 20; j++) {
                    driver.swipe(0, scrollStart, 0, -70, 10);
                    System.out.println(j);
                }
                WebElement myaccount = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]"));
                myaccount.click();
                WebElement editaccount = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
                editaccount.click();
                WebElement Logoutbtn = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
                Logoutbtn.click();
                //Alert OKAlert = driver.switchTo().alert();
                WebElement logouttxt = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
                String Logouttxt = logouttxt.getText();
                System.out.println(Logouttxt);
                WebElement logout = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]"));
                logout.click();
            }

        

    }

    public void registerUserLoginAndLogout() throws Exception {
        for (int i = 0; i < 10; i++) {
            WebElement register = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
            register.click();
            WebElement firstname = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]"));
            firstname.sendKeys("Aksh Chauhan");
            WebElement email = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]"));
            email.sendKeys("roger123456@test.com");
            WebElement password = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]"));
            password.sendKeys("password");
            WebElement gender = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]"));
            gender.click();
            driver.hideKeyboard("pressKey", "Done");
            WebElement Register = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]"));
            Register.click();
            Thread.sleep(3000);
            WebElement myaccount = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]"));
            myaccount.click();
            WebElement editaccount = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
            editaccount.click();
            WebElement Logoutbtn = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
            Logoutbtn.click();
            //Alert OKAlert = driver.switchTo().alert();
            WebElement logouttxt = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
            String Logouttxt = logouttxt.getText();
            System.out.println(Logouttxt);
            WebElement logout = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]"));
            logout.click();
            WebElement signbymail = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
            signbymail.click();
            WebElement Loginemail = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]"));
            Loginemail.sendKeys("roger123456@test.com");
            WebElement Loginpassword = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]"));
            Loginpassword.sendKeys("password");
            WebElement signin = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
            signin.click();
            Thread.sleep(3000);
            WebElement feed = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]"));
            feed.click();
            Thread.sleep(10000);
            driver.swipe(100, 100, 100, 10000, 10000);

            WebElement myaccount_reg = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]"));
            myaccount_reg.click();
            WebElement editaccount_reg = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
            editaccount_reg.click();
            WebElement Logout_btn = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
            Logout_btn.click();
            //Alert OKAlert = driver.switchTo().alert();
            WebElement logout_txt = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
            String Logout_txt = logout_txt.getText();
            System.out.println(Logout_txt);
            WebElement logoutreg = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]"));
            logoutreg.click();
        }

    }

    @AfterClass
    public void teardown() {
        //close the app
        driver.quit();
    }

    public boolean isElementPresent(String Xpath) {
        boolean present;
        try {
            WebElement myaccnt = driver.findElement(By.xpath(Xpath));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }
}



