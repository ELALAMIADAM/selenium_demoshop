package com.logwire.pf;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage {
    WebDriver driver;
    
    @FindBy(id = "gender-male")
    private WebElement gender_male ;

    @FindBy(id = "FirstName")
    private WebElement First_name ;

    @FindBy(id = "LastName")
    private WebElement Last_name ;

    @FindBy(id = "Email")
    private WebElement email ;

    @FindBy(id = "Password")
    private WebElement password ;

    @FindBy(id = "ConfirmPassword")
    private WebElement ConfirmPassword ;

    @FindBy(id = "register-button")
    private WebElement register_button ;

    By Continue_button = By.className("register-continue-button");

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void CheckGenderMale(){
        gender_male.click();;
    }
    public void EnterFirstName(String s){
        First_name.sendKeys(s);
    }
    public void EnterLastName(String s){
        Last_name.sendKeys(s);
    }
    public void EnterEmail(String s){
        email.sendKeys(s);
    }
    public void EnterPassword(String s){
        password.sendKeys(s);
    }
    public void EnterConfirmPassword(String s){
        ConfirmPassword.sendKeys(s);
    }

    public void ClickRegisterButton(){
        register_button.click();
    }
    public void EnterData(String fn , String ln ,String em ,String ps ){
        CheckGenderMale();
        EnterConfirmPassword(ps);
        EnterPassword(ps);
        EnterEmail(em);
        EnterFirstName(fn);
        EnterLastName(ln+"as");
        ClickRegisterButton();
    }

    public void ClickContinue(){
        driver.findElement(Continue_button).click();
    }




}
