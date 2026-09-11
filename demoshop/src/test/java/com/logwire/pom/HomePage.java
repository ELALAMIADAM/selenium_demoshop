package com.logwire.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By register_link = By.className("ico-register");
    By Login_link = By.className("ico-login");
    By LogOut_link = By.className("ico-logout");
    By add_product = By.cssSelector("[value=\"Add to cart\"]");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void ClickRegisterLink(){
        driver.findElement(register_link).click();
    }

    public void  ClickLogin(){
        driver.findElement(Login_link).click();
    }

    public void ClickLogout(){
        driver.findElement(LogOut_link).click();
    }

    public By AddToCart(){
        return add_product ;
    }
}
