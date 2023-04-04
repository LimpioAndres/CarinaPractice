package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class PageOb extends AbstractPage{

    private ExtendedWebElement driver;

    public PageOb (WebDriver driver){
        super(driver);
    }

    /*Start Attritubes and methods for click elements in NerdWallet*/

    @FindBy (id = "travel")
    private ExtendedWebElement idButtom;

    @FindBy (xpath = "//p[normalize-space()='Get rewards for the way you travel']") /*//p[contains(text(), 'Get rewards for the way you travel')]*/
    private ExtendedWebElement textTravel;

    public void clickButtom(){
        idButtom.click();
    }

    public String getMessage(){
        return textTravel.getText();
    }

    /*Finish Attritubes and methods for click elements in NerdWallet*/
    //-----------------------------------------------------------------------------

    /*Start Attritubes and methods for click elements and login in Amazon.mx*/

    @FindBy(id="nav-link-accountList-nav-line-1")
    private ExtendedWebElement identifyButtom;

    @FindBy(id="ap_email")
    private ExtendedWebElement emailLabel;

    @FindBy(id="continue")
    private  ExtendedWebElement continueButtom;

    @FindBy (id="ap_password")
    private  ExtendedWebElement passwordLabel;

    @FindBy (id = "signInSubmit")
    private  ExtendedWebElement signInButtom;

    @FindBy (xpath = "//span[contains(text(), 'Hola Andres')]")
    private ExtendedWebElement signLabel;

    public void clickIdentifyButtom(){
        identifyButtom.click();
    }
    public void inputEmail(String email){
        emailLabel.type(email);
    }

    public void clickContinueButtom(){
        continueButtom.click();
    }

    public void inputPassword(String pass){
        passwordLabel.type(pass);
    }

    public void clickSignInButtom(){
        signInButtom.click();
    }

    public String getNameAccount(){
        return signLabel.getText();
    }
}
