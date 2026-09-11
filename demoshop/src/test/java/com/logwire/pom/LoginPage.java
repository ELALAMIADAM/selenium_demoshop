package com.logwire.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    
    By email = By.id("Email");
    By password = By.id("Password");
    By RememeberHim = By.id("RememberMe");
    By login_button = By.className("login-button");

    public LoginPage(WebDriver driver){
    this.driver=driver;
    }

    public void EnterEmail(String s){
        driver.findElement(email).sendKeys(s);
    }
    public void EnterPassword(String s){
        driver.findElement(password).sendKeys(s);
    }
    public void CheckRememberMe(){
        driver.findElement(RememeberHim).click();
    }
    public void ClickLoginButton(){
        driver.findElement(login_button).click();
    }

}
