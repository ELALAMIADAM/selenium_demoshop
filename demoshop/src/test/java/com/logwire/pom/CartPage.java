package com.logwire.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By termsofservice = By.id("termsofservice");
    By checkout = By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    public void ClickTerms(){
        driver.findElement(termsofservice).click();
    }

    public void ClickCheckout(){
        driver.findElement(checkout).click();
    }
}
