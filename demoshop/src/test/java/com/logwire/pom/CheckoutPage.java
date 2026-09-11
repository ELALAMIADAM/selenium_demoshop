package com.logwire.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    WebDriver driver;
    
    By Company = By.id("BillingNewAddress_Company");
    By Country = By.id("BillingNewAddress_CountryId");
    By state = By.id("BillingNewAddress_StateProvinceId");
    By City = By.id("BillingNewAddress_City");
    By Address1 = By.id("BillingNewAddress_Address1");
    By Address2 = By.id("BillingNewAddress_Address2");
    By Zip = By.id("BillingNewAddress_ZipPostalCode");
    By PhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By Fax = By.id("BillingNewAddress_FaxNumber");

    By credit_card = By.id("paymentmethod_2");
    By Cardholder_name = By.id("CardholderName");
    By Cardholder_nb = By.id("CardNumber");
    By card_code = By.id("CardCode");

    By continue_button = By.cssSelector("[value=\"Continue\"]");
    By continue_button1 = By.className("payment-method-next-step-button");
    By continue_button2 = By.className("payment-info-next-step-button");
    By continue_button3 = By.className("confirm-order-next-step-button");
    By continue_confin = By.className("order-completed-continue-button");


    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public void EnterCompany(String s){
        driver.findElement(Company).sendKeys(s);
    }
    public void EnterCountry(String s){
        Select dropdown = new Select(driver.findElement(Country));
        dropdown.selectByVisibleText(s);
    }
    public void Enterstate(String s){
        driver.findElement(state).sendKeys(s);
    }
    public void EnterCity(String s){
        driver.findElement(City).sendKeys(s);
    }
    public void EnterAddress1(String s){
        driver.findElement(Address1).sendKeys(s);
    }
    public void EnterAddress2(String s){
        driver.findElement(Address2).sendKeys(s);
    }
    public void EnterPhoneNumber(String s){
        driver.findElement(PhoneNumber).sendKeys(s);
    }
    public void EnterZip(String s){
        driver.findElement(Zip).sendKeys(s);
    }
    public void EnterFax(String s){
        driver.findElement(Fax).sendKeys(s);
    }
    public void Entercontinue_button(){
        driver.findElement(continue_button).click();
    }
    public void Entercontinue2_button(){
        driver.findElement(continue_button2).click();
    }
    public By Entercontinue3_button(){
        return continue_button3;
    }
    public void Entercontinue1_button(){
        driver.findElement(continue_button1).click();
    }
    public void SelectCreditCard(){
        driver.findElement(credit_card).click();
    }

    public void EnterCardholderNb(String s){
        driver.findElement(Cardholder_nb).sendKeys(s);
    }
    public void EnterCardholderName(String s){
        driver.findElement(Cardholder_name).sendKeys(s);
    }
    public void ENtercard_code(String s){
        driver.findElement(card_code).sendKeys(s);
    }
    public void ContinueButtonConfirm(){
        driver.findElement(continue_confin).click();
    }

}
