package com.qaprosoft.carina.demo.gui.pages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import java.lang.invoke.MethodHandles;


public class PageObjects extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private ExtendedWebElement driver;
    public PageObjects(WebDriver driver) {
        super(driver);
    }

    /*Start Attritubes and methods for login page*/
    @FindBy(id = "username")
    private ExtendedWebElement userfield;

    @FindBy(id = "password")
    private ExtendedWebElement  passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement  loginButton;


    //Enter the username into the user field
    public void typeUserName(String user){
        userfield.type(user);

    }

    //Enter the password into the password field
    public void typePassword(String pass){
        passwordField.type(pass);
    }

    public void clickSubmitButton(){
        this.loginButton.click();
    }

    /*Finish Attritubes and methods for login page*/
    //----------------------------------------------------------
    /*Start Attritubes and methods for add and delete button*/

    @FindBy(xpath = "//button[normalize-space()='Add Element']")
    private ExtendedWebElement addButton;

    @FindBy(id = "elements")
    private ExtendedWebElement containerButton;

    @FindBy(css = ".added-manually")
    private ExtendedWebElement deleteButton;

    public void clickAddButton(){
        LOGGER.info("CLICK ADD BUTTON");
        addButton.click();
    }

    public int countElements(){
        return containerButton.findExtendedWebElements(By.tagName("button")).size();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    /*Finish Attritubes and methods for add and delete button*/
    //----------------------------------------------------------
    /*Start Attritubes and methods for hovers*/

    @FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
    private ExtendedWebElement figureBox;

    @FindBy(partialLinkText = "View profile")
    private ExtendedWebElement linkText;


    public void hoverBox(){
        figureBox.hover();
    }

    public void clickText(){
        linkText.click();
    }

    /*Finish Attritubes and methods for hovers*/
    //----------------------------------------------------------
    /*Start Attritubes and methods for JavaScript Alerts*/

    @FindBy(css = "button[onclick='jsAlert()']")
    private ExtendedWebElement jsAlert;

    @FindBy(css = "button[onclick='jsConfirm()']")
    private ExtendedWebElement jsConfirm;

    @FindBy(css = "button[onclick='jsPrompt()']")
    private ExtendedWebElement jsPrompt;
    @FindBy(id = "result")
    private  ExtendedWebElement jsAlertMsg;

    public String getMessage(){
        return jsAlertMsg.getText();
    }

    public void clickAlertButtom(){
        jsAlert.click();
    }

    public void acceptAlert(){
        try {
            Alert alerts = getDriver().switchTo().alert();
            Assert.assertEquals(alerts.getText(), "I am a JS Alert");
            alerts.accept();
            //getDriver().switchTo().alert().accept();
        }catch (NoAlertPresentException e){
            LOGGER.info("No alert present on the page");
        }
    }

    public void clickConfirmButtom(){
        jsConfirm.click();
    }

    public void dismissButtom() {
        try {
            Alert confirm = getDriver().switchTo().alert();
            Assert.assertEquals(confirm.getText(), "I am a JS Confirm");
            confirm.dismiss();
            //getDriver().switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            LOGGER.info("No alert present on the page");
        }
    }

    public void clickPromptButtom(){
        jsPrompt.click();
    }

    public void promptButtom(String text) {
        try {
            Alert prompt = getDriver().switchTo().alert();
            Assert.assertEquals(prompt.getText(), "I am a JS prompt");
            prompt.sendKeys(text);
            prompt.accept();
        }catch (NoAlertPresentException ex){
            LOGGER.info("No alert present on the page");
        }
    }
    /*Finish Attritubes and methods for JavaScript Alerts*/
}
