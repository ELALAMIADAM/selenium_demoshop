package com.logwire.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
    WebDriver driver;

    By TitleItem = By.className("product-name");
    By Add_to_cart = By.id("add-to-cart-button-2");
    By name_recip = By.id("giftcard_2_RecipientName");
    By email_recip = By.id("giftcard_2_RecipientEmail");
    By message_success = By.className("content");
    By shopping_cart = By.cssSelector("[href=\"/cart\"]");
    
    public ItemPage(WebDriver driver){
        this.driver=driver;
    }

    public String getTitleItem(){
        return driver.findElement(TitleItem).getText();
    }

    public void EnterNameRecip(String s){
        driver.findElement(name_recip).sendKeys(s);
    }

    public void EnterEmailRecip(String s){
        driver.findElement(email_recip).sendKeys(s);
    }

    public void ClickAdd2Cart(){
        driver.findElement(Add_to_cart).click();
    }

    public String getMessageSuccess(){
        return driver.findElement(message_success).getText();
    }

    public void ClickCart(){
        driver.findElement(shopping_cart).click();
    }
}
