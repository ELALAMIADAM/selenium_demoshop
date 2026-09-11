package com.logwire.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletedPage {
    WebDriver driver;

    By message_success = By.className("title"); 
    public CheckoutCompletedPage(WebDriver driver){
        this.driver=driver;
    }

    public String getMessageSuccess(){
        return driver.findElement(message_success).getText();
    }
}
