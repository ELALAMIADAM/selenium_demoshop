package com.logwire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.logwire.pf.RegisterPage;
import com.logwire.pom.CartPage;
import com.logwire.pom.CheckoutCompletedPage;
import com.logwire.pom.CheckoutPage;
import com.logwire.pom.HomePage;
import com.logwire.pom.ItemPage;
import com.logwire.pom.LoginPage;

public class ProductTest {
    WebDriver driver;
    HomePage hp ;
    RegisterPage rg ;
    LoginPage lp;
    ItemPage ip;
    CartPage cp;
    CheckoutPage chp;
    CheckoutCompletedPage ccp;
    @BeforeEach 
    public void setUp(){
        // driver = new ChromeDriver();
        URL gridUrl = null;
        try {
            gridUrl = new URL("http://127.1.0.1:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions cho = new ChromeOptions();
        driver = new RemoteWebDriver(gridUrl, cho);
        hp = new HomePage(driver);
        rg = new RegisterPage(driver);
        lp = new LoginPage(driver);
        ip = new ItemPage(driver);
        cp = new CartPage(driver);
        chp = new CheckoutPage(driver);
        ccp = new CheckoutCompletedPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterEach 
    public void tearDown(){
        if(driver !=null ){
            driver.quit();
            driver = null;
        }
    }

    @Test 
    public void ParcoursAchat(){
        hp.ClickRegisterLink();
        assertTrue(driver.getCurrentUrl().contains("/register"));

        rg.CheckGenderMale();
        String email = "adamalalmi"+Math.floor(Math.random()*1100)+"@gmail.com";
        String password = "HalloMallo";
        rg.EnterData("Adam"+Math.floor(Math.random()*1000), "Adam"+Math.floor(Math.random()*1000), email, password);
        assertEquals("https://demowebshop.tricentis.com/registerresult/1", driver.getCurrentUrl());
        rg.ClickContinue();
        assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        hp.ClickLogout();
        hp.ClickLogin();
        assertTrue(driver.getCurrentUrl().contains("/login"));
        lp.EnterEmail(email);
        lp.EnterPassword(password);
        lp.CheckRememberMe();
        lp.ClickLoginButton();
        assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(hp.AddToCart())).get(0).click();
        assertTrue(ip.getTitleItem().contains("25 Virtual Gift Card"));

        ip.EnterNameRecip(password);
        ip.EnterEmailRecip(email);
        ip.ClickAdd2Cart();
        assertTrue(ip.getMessageSuccess().contains("The product has been added to your shopping cart"));
        ip.ClickCart();
        assertTrue(driver.getCurrentUrl().contains("/cart"));

        cp.ClickTerms();
        cp.ClickCheckout();
        assertTrue(driver.getCurrentUrl().contains("/onepagecheckout"));

        chp.EnterCompany("logwire");
        chp.EnterCountry("Argentina");
        chp.EnterAddress1("dmwapdaw");
        chp.EnterAddress2("dwaodk[wa");
        chp.EnterCity("rabat");
        chp.Enterstate("hmida");
        chp.EnterFax("0929302930");
        chp.EnterZip("231321");
        chp.EnterPhoneNumber("09293029301");
        chp.Entercontinue_button();

        chp.SelectCreditCard();
        chp.Entercontinue1_button();

        chp.EnterCardholderName("halala");
        chp.EnterCardholderNb("424242424242");
        chp.ENtercard_code("123");
        chp.Entercontinue2_button();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(chp.Entercontinue3_button())).get(0).click();

        // assertEquals("https://demowebshop.tricentis.com/checkout/completed/",driver.getCurrentUrl());
        chp.ContinueButtonConfirm();
        assertEquals("https://demowebshop.tricentis.com/",driver.getCurrentUrl());

    }
}
















